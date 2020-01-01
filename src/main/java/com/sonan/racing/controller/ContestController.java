package com.sonan.racing.controller;

import com.sonan.mvc.Controller;
import com.sonan.racing.model.ContestModel;
import com.sonan.racing.model.ParticipantCarModel;
import java.util.ArrayList;
import java.util.List;

/**
 * 자동차 경주 대회를 개최하는 클래스.
 * controller.
 *
 * @github: http://github.com/sonanDev
 * @createdBy: jindam91@gmail.com
 * @created: 2020-01-02
 * @since: 1.8
 */
public class ContestController implements Controller<ContestModel> {

  public ContestModel activate(ContestModel model) {
    List<ParticipantCarModel> cars = model.getParticipants();
    Integer maxStep = model.getMaxStep();

    //redirect ContestStepController
    ContestStepController stepController = new ContestStepController();
    for (int i = 0; i < maxStep; i++) {
      List<ParticipantCarModel> nextCars = new ArrayList();
      for (ParticipantCarModel car: cars) {
        nextCars.add(stepController.activate(car));
      }
      cars = nextCars;

    }

    stepController.activate()

  }

  private

}
