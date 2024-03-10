package com.tbs.tambola.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Ticket {
  private final int rows;
  private final int columns;
  // Not keeping primitive as it can be null
  private final Integer[][] numbers;
  private boolean[][] marked;

  public Ticket(Integer[][] numbers) {
    this.rows = numbers.length;
    this.columns = numbers[0].length;
    this.numbers = numbers;
  }

  public void markPosition(int r, int c) {
    int i = r - 1, j = c - 1;
    if (this.numbers[i][j] == null) {
      return;
    }
    this.marked[i][j] = true;
  }

  public boolean isMarked(int r, int c) {
    return this.marked[r - 1][c - 1];
  }
}
