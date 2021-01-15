package com.tbs.tambola.controller;

import com.tbs.tambola.exception.RoomNotFoundException;
import com.tbs.tambola.model.Room;
import com.tbs.tambola.service.RoomService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/v1/api/tambola")
@Api(value = "Room Controller")
@RequiredArgsConstructor
public class RoomController {
  private final RoomService roomService;

  @PostMapping(value = "/room", produces = MediaType.APPLICATION_JSON_VALUE)
  @ApiOperation(value = "Create a room with given configuration")
  @ApiResponses(
      value = {
        @ApiResponse(responseCode = "OK", description = "Room created"),
      })
  /**
   * Create a room, For joining the room we have other end point
   *
   * @param roomConfig Room Config
   * @return The room created by the user
   */
  public ResponseEntity<Room> createRoom(@RequestBody Room room) {
    roomService.createRoom(room);
    return new ResponseEntity<>(room, HttpStatus.OK);
  }

  @GetMapping("/room/{roomId}")
  @ApiOperation(value = "Get room configuration")
  @ApiResponses(
      value = {
        @ApiResponse(responseCode = "OK", description = "Get the room configuration"),
        @ApiResponse(responseCode = "Not Found", description = "Room not Found"),
      })
  public ResponseEntity<Room> joinRoom(@PathVariable String roomId) {
    try {
      Room room = roomService.getRoom(roomId);
      return new ResponseEntity<>(room, HttpStatus.OK);
    } catch (RoomNotFoundException e) {
      log.info(e.getMessage().concat(roomId));
    }
    return new ResponseEntity<Room>(HttpStatus.NOT_FOUND);
  }
}
