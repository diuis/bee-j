/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.demis.gallisto.bjs.ejb;

import javax.ejb.Stateless;

/**
 *
 * @author Demis Gallisto
 */
@Stateless
public class GameAdviceBean implements GameAdviceLocal {

  @Override
  public String advice() {
    throw new UnsupportedOperationException("Not supported yet.");
  }

}
