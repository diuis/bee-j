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
 * This class is for future use (for example, strategies based on cards counting)
 * 
 * @author Demis Gallisto
 */
public class Memory {

  private transient Logger _log = Logger.getLogger(this.getClass().getName());
  private List<PlayingCard> cards = new ArrayList<>();

  public List<PlayingCard> getCards() {
    return this.cards;
  }

  public void addRemovedCard(final @Observes CardRemovedEvent _evt) {
    if (_evt != null) {
      if (_evt.getRemovedCard() != null) {
        this.cards.add(_evt.getRemovedCard());
      }
      if (_log.isLoggable(Level.INFO)) {
        _log.log(Level.INFO, "card removed: {0}", _evt);
      }
    }
  }
}
