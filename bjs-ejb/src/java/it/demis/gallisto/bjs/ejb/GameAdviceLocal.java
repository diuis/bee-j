/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.demis.gallisto.bjs.ejb;

import javax.ejb.Local;

/**
 *
 * @author Demis Gallisto
 */
@Local
public interface GameAdviceLocal {
  
  String advice();
  
}
