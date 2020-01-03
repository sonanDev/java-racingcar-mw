package com.sonan.racing.controller;

import com.sonan.mvc.Controller;
import com.sonan.racing.model.ParticipantModel;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 대회 참가자에 대한 Controller
 *
 * @github: http://github.com/sonanDev
 * @createdBy: jindam91@gmail.com
 * @created: 2020-01-02
 * @since: 1.8
 */
public class ParticipantController implements Controller<ParticipantModel> {
  private static final int DEFAULT_MIN_RANDOM = 0;
  private static final int DEFAULT_MAX_RANDOM = 9;
  private static final int DEFAULT_THRESHOLD_RANDOM = 4;
  private int minRandom;
  private int maxRandom;
  private int thresholdRandom; // if 4 and min is 0 and max is 5 -> 1 more step case random number 4,5

  public ParticipantController() {
    this(DEFAULT_MIN_RANDOM, DEFAULT_MAX_RANDOM, DEFAULT_THRESHOLD_RANDOM);
  }

  public ParticipantController(int minRandom, int maxRandom, int thresholdRandom) {
    this.minRandom = minRandom;
    this.maxRandom = maxRandom;
    this.thresholdRandom = thresholdRandom;
  }

  /**
   * ParticipantController는 자신이 특정 확률로 움직일 수 있다고 판단된다면, 움직여서 distance가 1증가한다.
   * 움직일 수 없다고 판단된다면, 멈춰서서 distance는 그대로이다.
   * 위 수행이후 계산된 distance를 가진 새 ParticipantModel을 반환한다.
   *
   * @param model
   * @return
   */
  public ParticipantModel activate(ParticipantModel model) {
    if (canMove()) {
      return move(model);
    }
    return pause(model);
  }

  private boolean canMove() {
    return ThreadLocalRandom.current().nextInt(minRandom, maxRandom) >= thresholdRandom;
  }

  private ParticipantModel move(ParticipantModel model) {
    return new ParticipantModel(model.getName(), model.getDistance() + 1);
  }

  private ParticipantModel pause(ParticipantModel model) {
    return new ParticipantModel(model.getName(), model.getDistance());
  }
}
