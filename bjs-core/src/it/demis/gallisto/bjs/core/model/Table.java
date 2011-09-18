/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.demis.gallisto.bjs.core.model;

import it.demis.gallisto.bjs.core.model.actors.BlackjackDealer;
import it.demis.gallisto.bjs.core.model.actors.BlackjackPlayer;
import java.io.Serializable;

/**
 *
 * @author Demis Gallisto
 */
public interface Table extends Serializable {

  BlackjackDealer getDealer();

  BlackjackPlayer getPlayer();
}
