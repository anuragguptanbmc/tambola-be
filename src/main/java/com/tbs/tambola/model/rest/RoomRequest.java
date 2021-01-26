package com.tbs.tambola.model.rest;

import com.tbs.tambola.model.RoomType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RoomRequest {
  private RoomType roomType;
}
