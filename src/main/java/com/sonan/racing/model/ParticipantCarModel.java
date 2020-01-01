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
public class ParticipantCar implements Model {
  private String name;
  private Integer distance;

  public ParticipantCar(String name, Integer distance) {
    this.name = name;
    this.distance = distance;
  }

  public String getName() {
    return name;
  }

  public Integer getDistance() {
    return distance;
  }
}
