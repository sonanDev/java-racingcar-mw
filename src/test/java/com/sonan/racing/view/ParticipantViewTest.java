package com.sonan.racing.view;

import static org.junit.jupiter.api.Assertions.*;

import com.sonan.mvc.Model;
import com.sonan.mvc.View;
import com.sonan.racing.model.ParticipantModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * @github: http://github.com/sonanDev
 * @createdBy: jindam91@gmail.com
 * @created: 2020-01-02
 * @since: 1.8
 */
class ParticipantViewTest {

  @DisplayName("실행 결과 하나씩 출력")
  @ParameterizedTest
  @CsvSource(value = {"aaaa|5|aaaa : -----", "aaaa|0|aaaa :"}, delimiter = '|')
  void generate(String name, Integer distance, String expect) {
    View view = new ParticipantView();
    Model model = new ParticipantModel(name, distance);
    assertEquals(expect, view.generate(model));
  }
}