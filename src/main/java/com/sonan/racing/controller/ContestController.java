package com.sonan.racing.controller;

import com.sonan.mvc.Controller;
import com.sonan.racing.model.ContestModel;
import com.sonan.racing.model.ParticipantModel;
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

  /**
   * ContestController는 model의 currentStep이 maxStep보다 낮다면, 다음 step을 진행하게 된다.
   * model의 currentStep이 maxStep이라면, 다음 step을 진행하지 않는다.
   *
   * 위의 수행이후의 새 step값과 새 participant를 가진 새 ContestModel을 반환한다.
   * @param model
   * @return
   */
  public ContestModel activate(ContestModel model) {
    if (isFinalStep(model)) {
      return model.clone();
    }
    return getNextStepContestModel(model);
  }

  public boolean isFinalStep(ContestModel model) {
    if (model.getCurrentStep() == model.getMaxStep()) {
      return true;
    }
    return false;
  }

  private ContestModel getNextStepContestModel(ContestModel model) {
    return new ContestModel(getNextStepParticipants(model), model.getCurrentStep() + 1, model.getMaxStep());
  }

  private List<ParticipantModel> getNextStepParticipants(ContestModel model) {
    ParticipantController pc = new ParticipantController();
    List<ParticipantModel> nextParticipants = new ArrayList();
    for (ParticipantModel participant: model.getParticipants()) {
      nextParticipants.add(pc.activate(participant));
    }
    return nextParticipants;
  }
}
