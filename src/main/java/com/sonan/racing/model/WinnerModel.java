package com.sonan.racing.model;

import com.sonan.mvc.Model;
import java.util.ArrayList;
import java.util.List;

/**
 * @github: http://github.com/sonanDev
 * @createdBy: jindam91@gmail.com
 * @created: 2020-01-02
 * @since: 1.8
 */
public class WinnerModel implements Model<WinnerModel> {
  private static final Integer DEFAULT_DISTANCE = 0;
  private List<ParticipantModel> participants;
  private Integer distance;

  public WinnerModel(List<ParticipantModel> participants) {
    this(participants, DEFAULT_DISTANCE);
  }

  public WinnerModel(List<ParticipantModel> participants, Integer distance) {
    this.participants = participants;
    this.distance = distance;
  }

  public List<ParticipantModel> getParticipants() {
    return participants;
  }

  public Integer getDistance() {
    return distance;
  }

  @Override
  public WinnerModel clone() {
    return new WinnerModel(cloneParticipants(), distance);
  }

  public List<ParticipantModel> cloneParticipants() {
    List<ParticipantModel> cloneNames = new ArrayList();
    cloneNames.addAll(participants);
    return cloneNames;
  }
}
