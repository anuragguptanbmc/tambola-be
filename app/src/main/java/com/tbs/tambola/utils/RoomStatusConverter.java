package com.tbs.tambola.utils;

import com.tbs.tambola.model.RoomStatus;
import javax.persistence.AttributeConverter;

public class RoomStatusConverter implements AttributeConverter<RoomStatus, String> {

  @Override
  public String convertToDatabaseColumn(RoomStatus roomStatus) {
    return roomStatus.name();
  }

  @Override
  public RoomStatus convertToEntityAttribute(String dbData) {
    return RoomStatus.valueOf(dbData);
  }
}
