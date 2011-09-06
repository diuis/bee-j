/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.demis.gallisto.bjs.web;

import it.demis.gallisto.bjs.model.GameTable;
import java.util.Date;

import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Demis Gallisto
 */
@Named("game")
@RequestScoped
public class GameManagedBean {

  private final Logger log = Logger.getLogger(this.getClass().getName());
  private Date startDate;
  @Inject
  private GameTable table;
  private boolean gameStarted;

  public boolean isGameStarted() {
    return gameStarted;
  }

  protected void setGameStarted(final boolean _gameStarted) {
    this.gameStarted = _gameStarted;
  }

  public GameTable getTable() {
    return table;
  }

  protected void setTable(final GameTable _table) {
    this.table = _table;
  }

  public Date getStartDate() {
    return startDate;
  }

  protected void setStartDate(Date startDate) {
    this.startDate = startDate;
  }

  public GameManagedBean() {
    super();
  }

  public void newGame() {
    log.info("Start a new black jack game...");
    this.setStartDate(new Date());
    this.table.getPlayer().initHand(this.getTable().getDealer().getCardsForPlayer());
    this.setGameStarted(true);
    log.info("...game started!");
  }
}
