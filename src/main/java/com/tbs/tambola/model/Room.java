package com.tbs.tambola.model;

import com.tbs.tambola.utils.RoomStatusConverter;
import com.tbs.tambola.utils.RoomTypeConverter;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Getter
@Setter
@Table(name = "room")
@NoArgsConstructor
public class Room {
  @Id
  @Column(name = "room_id", nullable = false, updatable = false)
  private String id;

  @OneToMany(mappedBy = "room")
  private List<Player> player;

  @Column(nullable = false, updatable = false)
  @Convert(converter = RoomTypeConverter.class)
  private RoomType roomType = RoomType.PRIVATE;

  @Column(nullable = false, updatable = false)
  @Convert(converter = RoomStatusConverter.class)
  private RoomStatus roomStatus = RoomStatus.LOBBY;

  @Column(updatable = false)
  @CreationTimestamp
  @Temporal(TemporalType.TIMESTAMP)
  private Date createdAt;
}
