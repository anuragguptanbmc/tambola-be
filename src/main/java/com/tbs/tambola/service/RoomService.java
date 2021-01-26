package com.tbs.tambola.service;

import com.tbs.tambola.exception.RoomNotFoundException;
import com.tbs.tambola.model.db.Room;
import com.tbs.tambola.model.rest.RoomRequest;
import java.util.List;

public interface RoomService {

  public Room createRoom(RoomRequest room);

  public Room updateRoom(Room room);

  public Room getRoom(String roomId) throws RoomNotFoundException;

  public List<Room> getPublicRooms(int pageCount, int pageSize);
  /**
   * Check if game completed Kick all the people and delete the room
   *
   * @param String id of room to be deleted
   * @return true if deleted else false
   */
  public boolean deleteRoom(String roomId);
}
