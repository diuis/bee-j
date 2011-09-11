/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.demis.gallisto.bjs.utils;

/**
 *
 * @author Demis Gallisto
 */
public final class NumberUtils {

  private NumberUtils() {
    super();
  }

  public static boolean isInteger(final String _str) {
    boolean res = false;
    if (_str != null && !_str.isEmpty()) {
      try {
        Integer.parseInt(_str);
      } catch (final NumberFormatException _e) {
      }
      res = true;
    }
    return res;
  }
}
