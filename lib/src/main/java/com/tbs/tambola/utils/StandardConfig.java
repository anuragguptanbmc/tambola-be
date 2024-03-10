package com.tbs.tambola.utils;

import java.util.ArrayList;
import java.util.Collections;

public class StandardConfig {
  public static final int ROWS = 3;
  public static final int COLS = 9;
  public static final int MAX_NUMBERS = 15;
  public static final int TOTAL_NUMBERS = ROWS * COLS;
  public static final int NUMBERS_TO_DELETE = TOTAL_NUMBERS - MAX_NUMBERS;
  /** Generate full ticket and randomly remove few numbers */
  public static Integer[][] generateStandard() {
    Integer[][] ticket = generateFull();
    // Delete other numbers
    Integer[] deletingIndex = generateUniqueNumbers(0, TOTAL_NUMBERS - 1, NUMBERS_TO_DELETE);
    for (int i = 0; i < NUMBERS_TO_DELETE; ++i) {
      ticket[deletingIndex[i] % 3][deletingIndex[i] / 3] = null;
    }
    return ticket;
  }

  /** randomly fill the full ticket using standard rows */
  public static Integer[][] generateFull() {
    return generateFull(ROWS, COLS);
  }

  /** randomly fill the full ticket */
  public static Integer[][] generateFull(int rows, int cols) {
    Integer[][] ticket = new Integer[rows][cols];
    for (int j = 0; j < cols; ++j) {
      Integer[] column = generateUniqueNumbers(1 + j * 10, 10 * (j + 1), rows);
      for (int i = 0; i < rows; i++) {
        ticket[i][j] = column[i];
      }
    }
    return ticket;
  }

  public static Integer[] generateUniqueNumbers(int lower, int upper, int count) {
    int size = upper - lower + 1;
    if (count > size) {
      throw new UnsupportedOperationException();
    }
    Integer[] numbers = new Integer[count];
    ArrayList<Integer> list = new ArrayList<>(size);
    for (int i = 0; i < size; ++i) {
      list.set(i, lower + i);
    }
    Collections.shuffle(list);
    for (int i = 0; i < count; ++i) {
      numbers[i] = list.get(i);
    }
    return numbers;
  }
}
