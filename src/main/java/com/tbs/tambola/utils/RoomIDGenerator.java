package com.tbs.tambola.utils;

import java.util.Random;

/** This class will just generate room ID and will not check if it is avaiable or not */
public class RoomIDGenerator {
  public static int leftLimit = 48; // numeral '0'
  public static int rightLimit = 122; // letter 'z'
  public static int targetStringLength = 10;

  public static String getRandom() {
    Random random = new Random();
    return random
        .ints(leftLimit, rightLimit + 1)
        .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
        .limit(targetStringLength)
        .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
        .toString();
  }
}
