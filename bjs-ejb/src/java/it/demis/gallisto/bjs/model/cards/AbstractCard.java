/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.demis.gallisto.bjs.model.cards;

import javax.validation.constraints.NotNull;

/**
 *
 * @author Demis Gallisto
 */
public abstract class AbstractCard implements PlayingCard {

  protected Facing facing = Facing.DOWN;
  protected String suit;
  @NotNull
  protected String value;

  public Facing getFacing() {
    return this.facing;
  }

  public String getSuit() {
    String res = null;
    if (this.getFacing().equals(Facing.DOWN)) {
      res = "";
    } else {
      res = this.suit;
    }
    return res;
  }

  @Override
  public String getValue() {
    String res = null;
    if (this.getFacing().equals(Facing.DOWN)) {
      res = "";
    } else {
      res = this.value;
    }
    return res;
  }

  public void setFacing(final Facing _facing) {
    this.facing = _facing;
  }

  protected void setSuit(final String _suit) {
    this.suit = _suit;
  }

  protected void setValue(final String _value) {
    this.value = _value;
  }
}
