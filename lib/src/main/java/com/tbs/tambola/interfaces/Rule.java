package com.tbs.tambola.interfaces;

import com.tbs.tambola.model.Ticket;

public interface Rule {
  public boolean isValid(Ticket ticket, Board board);
}
