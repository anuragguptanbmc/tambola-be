package com.tbs.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.tbs.tambola.utils.RoomIDGenerator;
import org.junit.jupiter.api.Test;

public class RoomIDGeneratorTest {

  @Test
  public void testGetRandom() {
    // when
    String roomId = RoomIDGenerator.getRandom();
    // then
    assertEquals(roomId.length(), 10);
  }
}
