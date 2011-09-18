/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.demis.gallisto.bjs.core.utils;

import java.util.logging.Logger;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

/**
 *
 * @author Demis Gallisto
 */
public class LoggerFactory {

  @Produces
  public Logger createLogger(final InjectionPoint _injectionPoint) {
    final String name = _injectionPoint.getMember().getDeclaringClass().getName();
    return Logger.getLogger(name);
  }
}
