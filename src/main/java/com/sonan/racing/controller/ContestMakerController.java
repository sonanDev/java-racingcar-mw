package com.sonan.racing.controller;

import com.sonan.mvc.Controller;
import com.sonan.racing.model.ContestModel;
import com.sonan.racing.model.ParticipantModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @github: http://github.com/sonanDev
 * @createdBy: jindam91@gmail.com
 * @created: 2020-01-03
 * @since: 1.8
 */
public class ContestMakerController implements Controller<ContestModel> {
  private static final String COMMA = ",";
  private static Scanner sc = new Scanner(System.in);

  /**
   * model이 대회 개최할 준비가 안됐으면 추가 입력을 받아 새 Contest Model을 만들어 반환한다.
   *
   * @param model
   * @return
   */
  @Override
  public ContestModel activate(ContestModel model) {
    if (!isReadyContest(model)) {
      String input = sc.next();
      return getNewContestModel(model, input);
    }
    return model.clone();
  }


  /**
   * 대회를 개최할 준비를 마쳤는 지 확인용
   * @param model
   * @return
   */
  public boolean isReadyContest(ContestModel model) {
    if (model == null || model.getMaxStep() == null || model.getMaxStep() == 0) {
      return false;
    }
    return true;
  }

  /**
   * baseModel을 기본으로 inputParam이 무엇에 대한 입력인 지 판단하여 이 값이 적용된 새로운 ContestModel을 반환한다.
   *
   * @param baseModel
   * @param inputParam
   * @return
   */
  private ContestModel getNewContestModel(ContestModel baseModel, String inputParam) {
    if (baseModel == null) {
      List<ParticipantModel> participants = getNewParticipants(inputParam);
      return new ContestModel(participants);
    }
    if (baseModel.getMaxStep() == null || baseModel.getMaxStep() == 0) {
      Integer maxStep = toInteger(inputParam);
      return new ContestModel(baseModel.cloneParticipants(), maxStep);
    }
    return baseModel.clone();
  }

  private List<String> splitByComma(String value) {
    return Arrays.asList(value.split(COMMA));
  }

  private List<ParticipantModel> getNewParticipants(String value) {
    List<ParticipantModel> participants = new ArrayList();
    splitByComma(value).forEach((name) -> {
      participants.add(new ParticipantModel(name));
    });
    return participants;
  }

  private Integer toInteger(String value) {
    if (value == null) {
      return null;
    }
    return Integer.valueOf(value);
  }
}
