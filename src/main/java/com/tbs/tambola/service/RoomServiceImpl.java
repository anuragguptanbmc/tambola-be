package com.tbs.tambola.service;

import com.tbs.tambola.exception.RoomNotFoundException;
import com.tbs.tambola.model.Room;
import com.tbs.tambola.model.RoomType;
import com.tbs.tambola.repository.PlayerRepository;
import com.tbs.tambola.repository.RoomRepository;
import com.tbs.tambola.utils.RoomIDGenerator;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {
  private final RoomRepository roomRepository;
  private final PlayerRepository playerRepository;

  @Override
  public Room createRoom(Room room) {
    room.setId(RoomIDGenerator.getRandom());
    Room createdRoom = roomRepository.save(room);
    log.info("Created room {}", room.getId());
    return createdRoom;
  }

  @Override
  public Room updateRoom(Room room) {
    Room updateRoom = roomRepository.save(room);
    log.info("Updated room {}", room.getId());
    return updateRoom;
  }

  @Override
  public Room getRoom(String roomId) throws RoomNotFoundException {
    Room room = roomRepository.findById(roomId).orElseThrow(RoomNotFoundException::new);
    log.info("Found room {}", room.getId());
    return room;
  }

  @Override
  public List<Room> getPublicRooms(int pageCount, int pageSize) {
    return roomRepository.findByRoomType(RoomType.PUBLIC, PageRequest.of(pageCount, pageSize));
  }

  @Override
  public boolean deleteRoom(String roomId) {
    roomRepository.deleteById(roomId);
    playerRepository.deleteAllByRoomId(roomId);
    log.info("Deleted Room {} and Player", roomId);
    return true;
  }
}
