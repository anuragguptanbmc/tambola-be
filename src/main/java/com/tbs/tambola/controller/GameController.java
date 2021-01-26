package com.tbs.tambola.controller;

import com.tbs.tambola.model.rest.WSMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Controller;

@Slf4j
@Controller
@RequiredArgsConstructor
public class GameController {

  @MessageMapping("/room/{roomId}")
  public WSMessage sendToRoom(@DestinationVariable String roomId, @Payload WSMessage message) {
    log.info("Room id {}, Message {}", roomId, message.toString());
    return message;
  }
}
