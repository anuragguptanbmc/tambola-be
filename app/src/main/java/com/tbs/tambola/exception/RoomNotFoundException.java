package com.tbs.tambola.exception;

public class RoomNotFoundException extends Exception {

  private static final long serialVersionUID = 1L;
  private static final String MESSAGE = "Room not Found";

  public RoomNotFoundException() {
    super(MESSAGE);
  }
}
