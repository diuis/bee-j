package it.demis.gallisto.bjs.model.actors;

import it.demis.gallisto.bjs.model.Hand;
import it.demis.gallisto.bjs.model.cards.PlayingCard;
import it.demis.gallisto.bjs.strategies.GameStrategy;
import it.demis.gallisto.bjs.strategies.StrategyException;
import it.demis.gallisto.bjs.strategies.impl.PlayerQualifier;
import java.util.ArrayList;
import java.util.List;
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
public class Player extends GameActor {

  private List<Hand> hands = new ArrayList<>();

  public Player() {
    this(null);
  }

  public Player(final String _name) {
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
    final Hand hand = new Hand();
    for (final PlayingCard itm : _card) {
      if (itm == null) {
        throw new IllegalArgumentException("not valid parameter card array: one of its element is null");
      }
      hand.addCard(itm);
    }
    this.getHands().add(hand);
  }

  @PostConstruct
  public void init() {
    _log.log(Level.INFO, "player created, his name is {0}", this.getName());
  }

  public List<Hand> getHands() {
    return hands;
  }

  protected void setHands(final List<Hand> _hands) {
    this.hands = _hands;
  }

  public String getAdvice() {
    String res = null;

    return "ciao ";
  }

  public void play() throws StrategyException {
    for (final Hand h : this.getHands()) {
      this.getStrategy().getAdvice(h, null, null);
    }

  }

  public void stay() {
  }

  public void hit() {
  }

  @Inject
  public void setStrategy(@PlayerQualifier final GameStrategy _strategy) {
    super.setStrategy(_strategy);
  }
}
