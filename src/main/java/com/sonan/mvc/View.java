package com.sonan.mvc;

/**
 * mvc의 View
 *
 * @github: http://github.com/sonanDev
 * @createdBy: jindam91@gmail.com
 * @created: 2020-01-02
 * @since: 1.8
 */
public interface View<T extends Model> {

  /**
   * model을 토대로 View가 원하는 결과물 String을 만들어 반환한다.
   *
   * @param model
   * @return
   */
  String generate(T model);

  /**
   * generate 수행 결과를 System.out.print로 출력한다.
   *
   * @param model
   */
  default void print(T model) {
    System.out.print(generate(model));
  }
}
