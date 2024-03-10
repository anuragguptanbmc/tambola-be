package com.tbs.tambola.model;

import com.tbs.tambola.interfaces.Board;
import java.util.LinkedList;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardImpl implements Board {
  private final int rows;
  private final int columns;
  private final int maxNumber;
  private boolean[] isChecked;
  private LinkedList<Integer> checkedNumbers;
  private LinkedList<Integer> remainingNumbers;

  public BoardImpl(int rows, int columns) {
    this.rows = rows;
    this.columns = columns;
    this.maxNumber = rows * columns;
    this.isChecked = new boolean[this.maxNumber + 1];
    this.checkedNumbers = new LinkedList<>();
    this.remainingNumbers = new LinkedList<>();
    for (int i = 1; i <= maxNumber; i += 1) {
      remainingNumbers.add(i);
    }
  }

  @Override
  public int getNextNumber() {

    int number = 0;

    this.checkedNumbers.add(number);
    return number;
  }

  @Override
  public boolean isValidBoardNumber(int number) {
    return number > 0 && number <= this.maxNumber;
  }

  @Override
  public boolean isNumberChecked(int number) {
    return this.isValidBoardNumber(number) && this.isChecked[number];
  }
}
