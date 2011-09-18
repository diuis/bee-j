/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.demis.gallisto.bjs.core.model.cards;

/**
 *
 * @author Demis Gallisto
 */
public class BlackJackCardDecorator implements PlayingCardDecorator {

  private FrenchCard card;

  public BlackJackCardDecorator(final FrenchCard _card) {
    super();
    if (_card == null) {
      throw new IllegalArgumentException("the input parameter card is null");
    }
    this.card = _card;
  }

  @Override
  public Facing getFacing() {
    return this.card.getFacing();
  }

  @Override
  public void setFacing(final Facing _facing) {
    this.card.setFacing(_facing);
  }

  @Override
  public String getValue() {
    return this.card.getValue();
  }

  @Override
  public String getSuit() {
    return this.card.getSuit();
  }

  /**
   * This method is NOT thread-safe
   */
  @Override
  public int getCalculatedValue() {
    int res = 0;
    if (this.getFacing().equals(Facing.UP)) {
      try {
        res = Integer.parseInt(this.getValue());
      } catch (final NullPointerException | NumberFormatException _e) {
        if (this.getValue() != null) {
          switch (this.getValue()) {
            case "J":
              res = 10;
              break;
            case "Q":
              res = 10;
              break;
            case "K":
              res = 10;
              break;
            default:
              throw new IllegalStateException("card value not supported: " + this.getValue());
          }
        } else {
          throw new IllegalStateException("not expected null card value", _e);
        }
      }
    }
    return res;
  }
}
