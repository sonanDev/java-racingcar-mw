# 기능 분리 힌트
* 자동차는 자동차 이름과 위치 정보를 가지는 Car 객체를 추가해 구현한다.
* 사용자가 입력한 이름의 숫자 만큼 자동차 대수를 생성한다.
* 사용자 이름을 쉼표(,)를 기준으로 분리하려면 String 클래스의 split(",") 메서드를 활용한다.

# JUnit, AssertJ 구현 힌트
## Exception 구현 힌트
* [AssertJ Exception Assertions](https://www.baeldung.com/assertj-exception-assertion) 문서 참고
```java
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

assertThatExceptionOfType(IndexOutOfBoundsException.class)
  .isThrownBy(() -> {
      // ...
}).hasMessageMatching("Index: \\d+, Size: \\d+");
```
* 자주 발생하는 Exception의 경우 Exception별 메서드 제공하고 있음
  * assertThatIllegalArgumentException()
  * assertThatIllegalStateException()
  * assertThatIOException()
  * assertThatNullPointerException()
```java
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

assertThatIllegalArgumentException().isThrownBy(() -> {
    // ...
});
```
## 테스트 데이터 전달
* [Guide to JUnit 5 Parameterized Tests](https://www.baeldung.com/parameterized-tests-junit-5) 문서 참고
```java
@ParameterizedTest
@ValueSource(strings = {"", "  "})
void isBlank_ShouldReturnTrueForNullOrBlankStrings(String input) {
    assertTrue(Strings.isBlank(input));
}
```
