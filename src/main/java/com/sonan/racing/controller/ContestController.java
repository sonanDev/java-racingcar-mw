package com.sonan.racing;

import com.sonan.mvc.Controller;
import com.sonan.racing.model.Contest;
import com.sonan.racing.model.ParticipantCar;
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
public class ContestController implements Controller<Contest> {

  public Contest activate(Contest model) {
    List<ParticipantCar> cars = model.getParticipants();
    Integer maxStep = model.getMaxStep();

    //redirect ContestStepController
    ContestStepController stepController = new ContestStepController();
    for (int i = 0; i < maxStep; i++) {
      List<ParticipantCar> nextCars = new Li
      for (ParticipantCar car: cars) {

      }
    }

    stepController.activate()

  }

  private

}
