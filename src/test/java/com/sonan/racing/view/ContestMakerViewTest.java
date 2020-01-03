package com.sonan.racing.view;

import static org.junit.jupiter.api.Assertions.*;

import com.sonan.mvc.Model;
import com.sonan.mvc.View;
import com.sonan.racing.model.ContestModel;
import com.sonan.racing.model.ParticipantModel;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * @github: http://github.com/sonanDev
 * @createdBy: jindam91@gmail.com
 * @created: 2020-01-03
 * @since: 1.8
 */
class ContestMakerViewTest implements CSVSourceSupport{
  @DisplayName("대회가 개최할 수 있는 ContestModel이 만들어지는 과정을 확인.")
  @ParameterizedTest
  @CsvSource(value = {
      "|"
      + "|"
      + "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)." + NEWLINE,

      "pobi,crong,honux|"
      + "|"
      + "시도할 회수는 몇회인가요?" + NEWLINE,


      "pobi,crong,honux|"
      + "5|"
      + "대회를 개최하는데 필요한 모든 입력이 완료된 상태입니다." + NEWLINE,

  }, delimiter = '|')
  void generate(String names, String maxStep, String expect) {
    String expectWithNewLine = replaceNewLine(expect);
    View view = new ContestMakerView();
    Model model = getContestModelByParams(names, maxStep);
    assertEquals(expectWithNewLine, view.generate(model));
  }

  ContestModel getContestModelByParams(String names, String maxStep) {
    if (names == null) {
      return null;
    }
    List<ParticipantModel> participants = new ArrayList();
    toList(names).forEach((name) -> {
      participants.add(new ParticipantModel(name));
    });
    return new ContestModel(participants, toInteger(maxStep));
  }

  private Integer toInteger(String value) {
    if (value == null) {
      return null;
    }
    return Integer.valueOf(value);
  }
}