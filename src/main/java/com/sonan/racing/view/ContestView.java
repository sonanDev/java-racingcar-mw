package com.sonan.racing.view;

import com.sonan.mvc.View;
import com.sonan.racing.model.ContestModel;
import com.sonan.racing.model.ParticipantModel;
import com.sonan.racing.model.WinnerModel;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

/**
 * @github: http://github.com/sonanDev
 * @createdBy: jindam91@gmail.com
 * @created: 2020-01-02
 * @since: 1.8
 */
public class ContestView implements View<ContestModel> {
  private static final String PREFIX_CONTEST = "\n실행 결과\n";
  private static final String DELIMITER_CURRENT_STEP = "\n";
  private static final String PREFIX_CURRENT_STEP = "";
  private static final String SUFFIX_CURRENT_STEP = "\n\n";

  /**
   * 대회의 진행상황을 반환한다. 진행된 Step에 따라 화면 구성을 달리 반환된다.
   *
   * @param model
   * @return
   */
  @Override
  public String generate(ContestModel model) {
    StringBuilder sb = new StringBuilder();
    if (isFirstStep(model)) {
      sb.append(PREFIX_CONTEST);
    }
    sb.append(generateCurrentStepOfParticipants(model));
    if (isFinalStep(model)) {
      sb.append(generateWinner(model));
    }
    return sb.toString();
  }

  /**
   * 진행중인 대회의 현재 단계를 표기 문구로 반환.
   *
   * @param workingContest
   * @return
   */
  public String generateCurrentStepOfParticipants(ContestModel workingContest) {
    StringJoiner sj = new StringJoiner(DELIMITER_CURRENT_STEP, PREFIX_CURRENT_STEP, SUFFIX_CURRENT_STEP);
    View view = new ParticipantView();
    workingContest.getParticipants().forEach(participant -> {
      String step = view.generate(participant.clone());
      sj.add(step);
    });
    return sj.toString();
  }

  /**
   * contest 참가자들의 거리를 비교해 승리자를 판단한 뒤, 승리자에 대한 표기 문구를 반환
   *
   * @param endedContest
   * @return
   */
  public String generateWinner(ContestModel endedContest) {
    WinnerModel winner = initWinner(endedContest);
    for (ParticipantModel participant: endedContest.getParticipants()) {
      winner = makeNewWinner(participant, winner);
    }
    return new WinnerView().generate(winner);
  }

  private boolean isFirstStep(ContestModel workingContest) {
    if (workingContest.getCurrentStep() == 1) {
      return true;
    }
    return false;
  }

  private boolean isFinalStep(ContestModel workingContest) {
    if (workingContest.getCurrentStep() == workingContest.getMaxStep()) {
      return true;
    }
    return false;
  }

  /**
   * 참가자가 승자라 판단하여, WinnerModel을 새로 만들어 반환한다.
   *
   * @param participant
   * @return
   */
  private WinnerModel makeNewWinner(ParticipantModel participant, WinnerModel comparableCurrentWinner) {
    List<ParticipantModel> newWinnerParticipants;
    Integer distance = participant.getDistance();
    if (distance > comparableCurrentWinner.getDistance()) {
      newWinnerParticipants = Arrays.asList(participant);
      return new WinnerModel(newWinnerParticipants, distance);
    }
    if (distance == comparableCurrentWinner.getDistance()) {
      newWinnerParticipants = comparableCurrentWinner.cloneParticipants();
      newWinnerParticipants.add(participant);
      return new WinnerModel(newWinnerParticipants, distance);
    }
    return comparableCurrentWinner.clone();
  }

  private boolean isNewWinner(ParticipantModel participant, WinnerModel comparableCurrentWinner) {
    if (participant.getDistance() >= comparableCurrentWinner.getDistance()) {
      return true;
    }
    return false;
  }

  /**
   * 초기 Winner는 참가자 모두를 승자로 임명한다.
   *
   * @param contest
   * @return
   */
  private WinnerModel initWinner(ContestModel contest) {
    return new WinnerModel(contest.cloneParticipants());
  }
}
