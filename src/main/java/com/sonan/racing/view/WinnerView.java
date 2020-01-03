package com.sonan.racing.view;

import com.sonan.mvc.View;
import com.sonan.racing.model.WinnerModel;
import java.util.StringJoiner;

/**
 * @github: http://github.com/sonanDev
 * @createdBy: jindam91@gmail.com
 * @created: 2020-01-03
 * @since: 1.8
 */
public class WinnerView implements View<WinnerModel> {
  private static final String DELIMITER = ", ";
  private static final String PREFIX = "";
  private static final String SUFFIX = "가 최종 우승했습니다.";

  @Override
  public String generate(WinnerModel model) {
    StringJoiner sj = new StringJoiner(DELIMITER, PREFIX, SUFFIX);
    model.getParticipants().forEach(participant -> sj.add(participant.getName()));
    return sj.toString();
  }
}
