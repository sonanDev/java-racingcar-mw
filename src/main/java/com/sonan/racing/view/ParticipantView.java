package com.sonan.racing.view;

import com.sonan.mvc.View;
import com.sonan.racing.model.ParticipantModel;
import java.util.StringJoiner;

/**
 * @github: http://github.com/sonanDev
 * @createdBy: jindam91@gmail.com
 * @created: 2020-01-02
 * @since: 1.8
 */
public class ParticipantView implements View<ParticipantModel> {
  private static final String DELIMITER = " : ";
  private static final String VIEW_OF_DISTANCE = "-";

  @Override
  public String generate(ParticipantModel model) {
    StringJoiner sj = new StringJoiner(DELIMITER);
    return sj.add(model.getName())
        .add(getDistanceAsString(model))
        .toString()
        .trim();
  }

  private String getDistanceAsString(ParticipantModel model) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < model.getDistance(); i++) {
      sb.append(VIEW_OF_DISTANCE);
    }
    return sb.toString();
  }
}
