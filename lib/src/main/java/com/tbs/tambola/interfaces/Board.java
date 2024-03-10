package com.tbs.tambola.interfaces;

public interface Board {
  /**
   * randomly generate next number
   *
   * @return board number
   */
  public int getNextNumber();

  /**
   * Check if number exists in given board
   *
   * @return true false
   */
  public boolean isValidBoardNumber(int number);

  /**
   * Check if number is already checked
   *
   * @return true false
   */
  public boolean isNumberChecked(int number);
}
