package com.sonan.racing.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @github: http://github.com/sonanDev
 * @createdBy: jindam91@gmail.com
 * @created: 2020-01-03
 * @since: 1.8
 */
public interface CSVSourceSupport {
  String NEWLINE = "#NL#";
  String NEWLINE_REAL = "\n";
  String COMMA = ",";

  default String replaceNewLine(String value) {
    return value.replace(NEWLINE, NEWLINE_REAL);
  }

  default String[] splitByComma(String value) {
    return value.split(COMMA);
  }

  default List<String> toList(String value) {
    return Arrays.asList(splitByComma(value));
  }

  default List<Integer> toListInteger(String value) {
    List<Integer> result = new ArrayList();
    String[] valueArray = splitByComma(value);
    for (int i = 0; i < valueArray.length; i++) {
      result.add(Integer.valueOf(valueArray[i]));
    }
    return result;
  }
}
