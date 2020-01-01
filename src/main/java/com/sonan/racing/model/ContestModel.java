package com.sonan.racing.model;

import com.sonan.mvc.Model;
import java.util.List;

/**
 * 자동차 경주 대회에 대한 모델
 *
 * @github: http://github.com/sonanDev
 * @createdBy: jindam91@gmail.com
 * @created: 2020-01-02
 * @since: 1.8
 */
public class Contest implements Model {
  private List<ParticipantCar> participants;
  private Integer maxStep;

  public Contest(List<ParticipantCar> participants, Integer maxStep) {
    this.participants = participants;
    this.maxStep = maxStep;
  }

  public List<ParticipantCar> getParticipants() {
    return participants;
  }

  public Integer getMaxStep() {
    return maxStep;
  }
}
