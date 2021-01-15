package com.tbs.tambola.repository;

import com.tbs.tambola.model.Player;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends CrudRepository<Player, String> {
  List<Player> findAllByRoomId(String roomId);

  void deleteAllByRoomId(String roomId);
}
