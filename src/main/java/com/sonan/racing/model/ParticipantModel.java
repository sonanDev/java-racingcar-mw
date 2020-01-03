package com.sonan.racing.model;

import com.sonan.mvc.Model;

/**
 * 참가한 자동차에 대한 모델
 *
 * @github: http://github.com/sonanDev
 * @createdBy: jindam91@gmail.com
 * @created: 2020-01-02
 * @since: 1.8
 */
public class ParticipantModel implements Model<ParticipantModel> {
  private static final Integer DEFAULT_DISTANCE = 0;
  private String name;
  private Integer distance;

  public ParticipantModel(String name) {
    this(name, DEFAULT_DISTANCE);
  }

  public ParticipantModel(String name, Integer distance) {
    this.name = name;
    this.distance = distance;
  }

  public String getName() {
    return name;
  }

  public Integer getDistance() {
    return distance;
  }

  @Override
  public ParticipantModel clone() {
    return new ParticipantModel(name, distance);
  }

  @Override
  public String toString() {
    return getName();
  }
}
