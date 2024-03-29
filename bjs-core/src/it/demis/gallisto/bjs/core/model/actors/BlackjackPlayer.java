package it.demis.gallisto.bjs.core.model.actors;

import it.demis.gallisto.bjs.core.model.BlackjackHand;
import it.demis.gallisto.bjs.core.model.Hand;
import it.demis.gallisto.bjs.core.model.cards.PlayingCard;
import it.demis.gallisto.bjs.core.strategies.GameStrategy;
import it.demis.gallisto.bjs.core.strategies.StrategyException;
import it.demis.gallisto.bjs.core.strategies.impl.PlayerQualifier;
import java.util.UUID;
import java.util.logging.Level;
import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.inject.Inject;

/**
 *
 * @author Demis Gallisto
 */
@ManagedBean
public class BlackjackPlayer extends GameActor {

  public BlackjackPlayer() {
    this(null);
  }

  public BlackjackPlayer(final String _name) {
    String name = null;
    if (_name == null || _name.isEmpty()) {
      name = "anonymous player [" + UUID.randomUUID() + "]";
    } else {
      name = _name;
    }
    this.setName(name);
  }

  public void initHand(final PlayingCard[] _card) {
    if (_card == null || _card.length != 2) {
      throw new IllegalArgumentException("not valid parameter card: it's null or its size is != 2");
    }
    this.setHand(new BlackjackHand());
    for (final PlayingCard itm : _card) {
      if (itm == null) {
        throw new IllegalArgumentException("not valid parameter card array: one of its element is null");
      }
      this.getHand().addCard(itm);
    }
    if (_log.isLoggable(Level.INFO)) {
      _log.log(Level.INFO, "hand initialized [number of cards= {0}]", _card.length);
    }
  }

  @PostConstruct
  public void init() {
    _log.log(Level.INFO, "player created, his name is {0}", this.getName());
  }

  public String getAdvice(final Hand _dealerHand) throws StrategyException {
    String res = null;
    res = this.getStrategy().getAdvice(this.getHand(), _dealerHand, null).name();
    return res;
  }

  public boolean hit(final PlayingCard _card) {
    boolean res = true;
    if (_card == null) {
      throw new IllegalArgumentException("not valid parameter card: it's null");
    }
    this.getHand().addCard(_card);
    if (this.getHand().isBusting()) {
      res = false;
      if (_log.isLoggable(Level.INFO)) {
        _log.log(Level.INFO, "hand is busting: {0}", this.getHand());
      }
    }
    return res;
  }

  @Override
  @Inject
  public void setStrategy(@PlayerQualifier final GameStrategy _strategy) {
    super.setStrategy(_strategy);
  }
}
