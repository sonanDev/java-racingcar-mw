package com.sonan.mvc;

/**
 * mvc의 Controller
 *
 * @github: http://github.com/sonanDev
 * @createdBy: jindam91@gmail.com
 * @created: 2020-01-02
 * @since: 1.8
 */
public interface Controller<T extends Model> {

  /**
   * activate은 parameter로 받은 원본 model을 토대로 controller에서 계산을 수행하게 된다.
   * activate 내에서 계산 이후의 model을 반환한다.
   *
   * @param model
   * @return 계산 이후의 model
   */
  T activate(T model);
}
