package com.tbs.tambola.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "player")
@NoArgsConstructor
public class Player {
  @Id
  @Column(name = "player_id", nullable = false, updatable = false)
  private String id;

  @Column(nullable = false)
  private String name;

  @ManyToOne
  @JoinColumn(name = "room_id", nullable = false)
  private Room room;
}
