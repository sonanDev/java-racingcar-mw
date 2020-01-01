package com.sonan.racing;

/**
 * 자동차 경주 대회를 개최할 수 있는 클래스.
 *
 * @github: http://github.com/sonanDev
 * @createdBy: jindam91@gmail.com
 * @created: 2020-01-02
 * @since: 1.8
 */
@FunctionalInterface
public interface Contest<T> {

  /**
   * 대회를 개최한다. 개최하면 최종 우승자 차들을 반환한다.
   * 대회에서 정한 최대 턴 내에서, 가장 멀리간 차가 최종 우승자이다.
   * 공동 우승 가능하다.
   *
   * @param participantCars 참가한 자동차들.
   * @param maxStep 대회에서의 최대 턴 횟수.
   * @return 최종 우승한 자동차들.
   */
  T[] hold(T[] participantCars, Integer maxStep);
}
