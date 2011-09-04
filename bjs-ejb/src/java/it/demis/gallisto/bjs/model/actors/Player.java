package it.demis.gallisto.bjs.model.actors;

import it.demis.gallisto.bjs.model.Hand;
import it.demis.gallisto.bjs.strategies.GameStrategy;
import it.demis.gallisto.bjs.strategies.impl.PlayerQualifier;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import javax.annotation.PostConstruct;
import javax.inject.Inject;

/**
 *
 * @author Demis Gallisto
 */
public class Player extends GameActor {

  private List<Hand> hands;

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

  @PostConstruct
  public void init() {
    _log.log(Level.INFO, "player created, his name is {0}", this.getName());
  }

  public List<Hand> getHands() {
    return hands;
  }

  public void setHands(final List<Hand> _hands) {
    this.hands = _hands;
  }

  @Inject
  public void setStrategy(@PlayerQualifier final GameStrategy _strategy) {
    super.setStrategy(_strategy);
  }
}
