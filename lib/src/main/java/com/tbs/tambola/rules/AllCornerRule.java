package com.tbs.tambola.rules;

import com.tbs.tambola.interfaces.Board;
import com.tbs.tambola.interfaces.Rule;
import com.tbs.tambola.model.Ticket;

public class AllCornerRule implements Rule {

  @Override
  public boolean isValid(Ticket ticket, Board board) {
    return false;
  }
}
