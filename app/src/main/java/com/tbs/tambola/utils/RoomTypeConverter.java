package com.tbs.tambola.utils;

import com.tbs.tambola.model.RoomType;
import javax.persistence.AttributeConverter;

public class RoomTypeConverter implements AttributeConverter<RoomType, String> {

  @Override
  public String convertToDatabaseColumn(RoomType roomType) {
    return roomType.name();
  }

  @Override
  public RoomType convertToEntityAttribute(String dbData) {
    return RoomType.valueOf(dbData);
  }
}
