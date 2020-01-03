package com.sonan.racing.model;

import com.sonan.mvc.Model;
import java.util.ArrayList;
import java.util.List;

/**
 * 자동차 경주 대회에 대한 모델
 *
 * @github: http://github.com/sonanDev
 * @createdBy: jindam91@gmail.com
 * @created: 2020-01-02
 * @since: 1.8
 */
public class ContestModel implements Model<ContestModel> {
  private static final Integer DEFAULT_CURRENT_STEP = 0;
  private static final Integer DEFAULT_MAX_STEP = 0;
  private List<ParticipantModel> participants;
  private Integer currentStep;
  private Integer maxStep;

  public ContestModel(List<ParticipantModel> participants, Integer currentStep,
      Integer maxStep) {
    this.participants = participants;
    this.currentStep = currentStep;
    this.maxStep = maxStep;
  }

  public ContestModel(List<ParticipantModel> participants, Integer maxStep) {
    this(participants, DEFAULT_CURRENT_STEP, maxStep);
  }

  public ContestModel(List<ParticipantModel> participants) {
    this(participants, DEFAULT_CURRENT_STEP, DEFAULT_MAX_STEP);
  }

  public List<ParticipantModel> getParticipants() {
    return participants;
  }

  public Integer getCurrentStep() {
    return currentStep;
  }

  public Integer getMaxStep() {
    return maxStep;
  }


  @Override
  public ContestModel clone() {
    return new ContestModel(cloneParticipants(), currentStep, maxStep);
  }

  public List<ParticipantModel> cloneParticipants() {
    List<ParticipantModel> cloneParticipants = new ArrayList();
    for (ParticipantModel participant: participants) {
      cloneParticipants.add(participant.clone());
    }
    return cloneParticipants;
  }
}
