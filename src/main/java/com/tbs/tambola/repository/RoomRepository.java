package com.tbs.tambola.repository;

import com.tbs.tambola.model.RoomStatus;
import com.tbs.tambola.model.RoomType;
import com.tbs.tambola.model.db.Room;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends PagingAndSortingRepository<Room, String> {
  List<Room> findByRoomType(RoomType roomType, Pageable pageable);

  List<Room> findAllByRoomStatus(RoomStatus roomStatus, Pageable pageable);
}
