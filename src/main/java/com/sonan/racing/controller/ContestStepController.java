package com.sonan.racing.controller;

import com.sonan.mvc.Controller;
import com.sonan.racing.model.ParticipantCarModel;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 대회에서 1회 Step이 수행되는 Controller
 *
 * @github: http://github.com/sonanDev
 * @createdBy: jindam91@gmail.com
 * @created: 2020-01-02
 * @since: 1.8
 */
public class ContestStepController implements Controller<ParticipantCarModel> {
  private static final int DEFAULT_MIN_RANDOM = 0;
  private static final int DEFAULT_MAX_RANDOM = 9;
  private static final int DEFAULT_THRESHOLD_RANDOM = 4;
  private int minRandom;
  private int maxRandom;
  private int thresholdRandom; // if 4 and min is 0 and max is 5 -> 1 more step case random number 4,5

  public ContestStepController() {
    this(DEFAULT_MIN_RANDOM, DEFAULT_MAX_RANDOM, DEFAULT_THRESHOLD_RANDOM);
  }

  public ContestStepController(int minRandom, int maxRandom, int thresholdRandom) {
    this.minRandom = minRandom;
    this.maxRandom = maxRandom;
    this.thresholdRandom = thresholdRandom;
  }

  public ParticipantCarModel activate(ParticipantCarModel model) {
    if (canMove()) {
      return move(model);
    }
    return pause(model);
  }

  private boolean canMove() {
    return ThreadLocalRandom.current().nextInt(minRandom, maxRandom) >= thresholdRandom;
  }

  private ParticipantCarModel move(ParticipantCarModel model) {
    return new ParticipantCarModel(model.getName(), model.getDistance() + 1);
  }

  private ParticipantCarModel pause(ParticipantCarModel model) {
    return new ParticipantCarModel(model.getName(), model.getDistance());
  }
}
