package com.tbs.tambola.factory;

import com.tbs.tambola.model.Ticket;
import com.tbs.tambola.model.TicketType;
import com.tbs.tambola.utils.StandardConfig;

public class TicketFactory {
  public static Ticket getTicket(TicketType type) {
    switch (type) {
      case STANDARD:
        return new Ticket(StandardConfig.generateStandard());
      case FULL:
        return new Ticket(StandardConfig.generateFull());

      default:
        throw new UnsupportedOperationException("Unknown Ticket type");
    }
  }
}
