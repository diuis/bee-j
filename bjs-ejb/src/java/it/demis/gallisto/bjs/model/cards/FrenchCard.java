/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.demis.gallisto.bjs.model.cards;

/**
 *
 * @author Demis Gallisto
 */
public class FrenchCard extends AbstractCard implements PlayingCard {

  private FrenchCard() {
    super();
  }

  public FrenchCard(final String _value, final String _suit) {
    super();
    if (_value == null || _value.isEmpty() || _suit == null) {
      throw new IllegalArgumentException("broken preconditions: null a/o empty 'value' a/o 'suit' param(s)");
    }
    final String valueUpCase = _value.toUpperCase();
    switch (valueUpCase) {
      case "J":
        this.setValue("J");
        break;
      case "Q":
        this.setValue("Q");
        break;
      case "K":
        this.setValue("K");
        break;
      default:
        try {
          final int intValue = Integer.parseInt(_value);
          if (intValue >= 1 && intValue <= 10) {
            this.setValue(_value);
          } else {
            throw new IllegalArgumentException("broken preconditions: value is not >= 1 and <= 10");
          }
        } catch (final NumberFormatException _e) {
          throw new IllegalArgumentException("broken preconditions: value is not a valid number (1..10) or J|Q|K", _e);
        }
    }
    this.setSuit(_suit);
  }

  public String toString() {
    return "FrenchCard{" + "value=" + this.getValue() + ", suit=" + this.getSuit() + '}';
  }
}
