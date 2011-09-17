/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.demis.gallisto.bjs.model.actors;

import it.demis.gallisto.bjs.events.CardRemovedEvent;
import it.demis.gallisto.bjs.model.cards.PlayingCard;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.event.Observes;

/**
 *
 * @author Demis Gallisto
 */
public class Memory {

  private Logger _log = Logger.getLogger(this.getClass().getName());
  private List<PlayingCard> cards = new ArrayList<>();

  public void addRemovedCard(final @Observes CardRemovedEvent _evt) {
    if (_evt != null) {
      if (_evt.getRemovedCard() != null) {
        this.cards.add(_evt.getRemovedCard());
      }
      if (_log.isLoggable(Level.INFO)) {
        _log.info("card removed: " + _evt);
      }
    }
  }
}
