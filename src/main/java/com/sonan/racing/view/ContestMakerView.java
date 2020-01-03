package com.sonan.racing.view;

import com.sonan.mvc.View;
import com.sonan.racing.model.ContestModel;

/**
 * 대회를 개최하는
 *
 * @github: http://github.com/sonanDev
 * @createdBy: jindam91@gmail.com
 * @created: 2020-01-03
 * @since: 1.8
 */
public class ContestMakerView implements View<ContestModel> {
  private static final String MODEL_MISS_PARTICIPANT = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).\n";
  private static final String MODEL_MISS_MAX_STEP = "시도할 회수는 몇회인가요?\n";
  private static final String MODEL_READY = "대회를 개최하는데 필요한 모든 입력이 완료된 상태입니다.\n";

  /**
   * model에 Participants가 없으면 participant를 등록하는 view가 반환된다.
   * model에 maxStep이 없거나 0이면 maxStep을 등록하는 view가 반환된다.
   * model이 완성됐으면, 준비완료됐다는 view가 반환된다.
   *
   * @param model
   * @return
   */
  @Override
  public String generate(ContestModel model) {
    if (model == null) {
      return MODEL_MISS_PARTICIPANT;
    }
    if (model.getMaxStep() == null || model.getMaxStep() == 0) {
      return MODEL_MISS_MAX_STEP;
    }
    return MODEL_READY;
  }
}
