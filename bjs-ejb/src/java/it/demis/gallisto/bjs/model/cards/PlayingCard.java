/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.demis.gallisto.bjs.model.cards;

import java.io.Serializable;

/**
 *
 * @author Demis Gallisto
 */
public interface PlayingCard extends Serializable {

  Facing getFacing();

  void setFacing(Facing _facing);

  String getValue();
  
  String getSuit();
}
