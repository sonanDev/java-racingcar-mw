package com.sonan.racing.view;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.sonan.mvc.Model;
import com.sonan.mvc.View;
import com.sonan.racing.model.ParticipantModel;
import com.sonan.racing.model.WinnerModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * @github: http://github.com/sonanDev
 * @createdBy: jindam91@gmail.com
 * @created: 2020-01-03
 * @since: 1.8
 */
public class WinnerViewTest implements CSVSourceSupport {

  @DisplayName("최종 우승자 출력")
  @ParameterizedTest
  @CsvSource(value = {"pobi,honux|pobi, honux가 최종 우승했습니다.", "pobi|pobi가 최종 우승했습니다."}, delimiter = '|')
  void generate(String names, String expect) {
    View view = new WinnerView();
    Model model = getWinnerByNames(names);
    assertEquals(expect, view.generate(model));
  }

  List<ParticipantModel> getParticipantsByNames(String names) {
    List<ParticipantModel> winnerParticipants = new ArrayList();
    toList(names).forEach(name -> {
      winnerParticipants.add(new ParticipantModel(name));
    });
    return winnerParticipants;
  }

  WinnerModel getWinnerByNames(String names) {
    return new WinnerModel(getParticipantsByNames(names));
  }
}
