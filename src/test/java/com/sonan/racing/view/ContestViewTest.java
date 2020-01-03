package com.sonan.racing.view;

import static org.junit.jupiter.api.Assertions.*;

import com.sonan.mvc.Model;
import com.sonan.mvc.View;
import com.sonan.racing.model.ContestModel;
import com.sonan.racing.model.ParticipantModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * @github: http://github.com/sonanDev
 * @createdBy: jindam91@gmail.com
 * @created: 2020-01-02
 * @since: 1.8
 */
class ContestViewTest implements CSVSourceSupport {

  @DisplayName("실행 결과 Step 별로 출력.")
  @ParameterizedTest
  @CsvSource(value = {
      "pobi,crong|"
      + "1,1|"
      + "1,5|"
      + NEWLINE
      + "실행 결과" + NEWLINE
      + "pobi : -" + NEWLINE
      + "crong : -" + NEWLINE
      + NEWLINE,

      "pobi,crong|"
      + "2,3|"
      + "2,5|"
      + "pobi : --" + NEWLINE
      + "crong : ---" + NEWLINE
      + NEWLINE,

      "pobi,crong|"
      + "5,4|"
      + "5,5|"
      + "pobi : -----" + NEWLINE
      + "crong : ----" + NEWLINE
      + NEWLINE
      + "pobi가 최종 우승했습니다.",

      "pobi,crong,honux|"
      + "5,4,5|"
      + "5,5|"
      + "pobi : -----" + NEWLINE
      + "crong : ----" + NEWLINE
      + "honux : -----" + NEWLINE
      + NEWLINE
      + "pobi, honux가 최종 우승했습니다."

  }, delimiter = '|')
  void generate(String names, String distances, String steps, String expect) {
    String expectWithNewLine = replaceNewLine(expect);
    View view = new ContestView();
    Model model = getContestByParams(names, distances, steps);
    assertEquals(expectWithNewLine, view.generate(model));
  }

  ContestModel getContestByParams(String names, String distances, String steps) {
    List<Integer> stepList = toListInteger(steps);
    return new ContestModel(getParticipantsByParams(names, distances), stepList.get(0), stepList.get(1));
  }

  List<ParticipantModel> getParticipantsByParams(String names, String distances) {
    List<ParticipantModel> winnerParticipants = new ArrayList();
    Iterator<Integer> distanceIter = toListInteger(distances).iterator();
    toList(names).forEach(name -> {
      winnerParticipants.add(new ParticipantModel(name, distanceIter.next()));
    });
    return winnerParticipants;
  }
}