package com.sonan.racing.view;

import com.sonan.mvc.View;
import com.sonan.racing.model.ParticipantCarModel;

/**
 * @github: http://github.com/sonanDev
 * @createdBy: jindam91@gmail.com
 * @created: 2020-01-02
 * @since: 1.8
 */
public class ContestStepView implements View<ParticipantCarModel> {
  private static final String DELIMITER = " : ";
  private static final String VIEW_OF_DISTANCE = "-";

  @Override
  public String toString(ParticipantCarModel model) {
    StringBuilder sb = new StringBuilder();
    return sb.append(model.getName())
        .append(DELIMITER)
        .append(getDistanceAsString(model))
        .toString();
  }

  private String getDistanceAsString(ParticipantCarModel model) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < model.getDistance(); i++) {
      sb.append(VIEW_OF_DISTANCE);
    }
    return sb.toString();
  }
}
