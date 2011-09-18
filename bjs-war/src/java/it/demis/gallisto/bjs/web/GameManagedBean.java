/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.demis.gallisto.bjs.web;

import it.demis.gallisto.bjs.core.model.BlackjackTable;
import it.demis.gallisto.bjs.core.model.cards.PlayingCard;
import it.demis.gallisto.bjs.core.strategies.StrategyException;
import java.text.DateFormat;
import java.util.Date;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

/**
 *
 * @author Demis Gallisto
 */
@ManagedBean(name="game")
@RequestScoped
public class GameManagedBean {

  private transient final Logger log = Logger.getLogger(this.getClass().getName());
  private Date startDate;
  @Inject
  private BlackjackTable table;
  private boolean gameStarted;

  public GameManagedBean() {
    super();
  }

  public boolean isGameStarted() {
    return gameStarted;
  }

  protected void setGameStarted(final boolean _gameStarted) {
    this.gameStarted = _gameStarted;
  }

  public BlackjackTable getTable() {
    return table;
  }

  protected void setTable(final BlackjackTable _table) {
    this.table = _table;
  }

  public Date getStartDate() {
    return startDate;
  }

  protected void setStartDate(Date startDate) {
    this.startDate = startDate;
  }

  public void playerStay() {
    if (this.log.isLoggable(Level.INFO)) {
      log.info("player stay");
    }
  }

  public void playerHit() {
    if (this.log.isLoggable(Level.INFO)) {
      log.info("player hit");
    }
  }

  public String getAdvice() {
    String res = null;
    if (this.isGameStarted()) {
      try {
        res = this.getTable().getPlayer().getAdvice(this.getTable().getDealer().getHand());
      } catch (final StrategyException _e) {
        log.log(Level.SEVERE, "error on getting an advice", _e);
      }
    } else {
      res = "start the game for advice";
    }
    return res;
  }
  
  public void newGame() {
    log.info("Start a new black jack game...");
    this.setStartDate(new Date());

    log.log(Level.INFO, " new blackjack start date: {0}", DateFormat.getDateTimeInstance().format(this.getStartDate()));
    this.table.getPlayer().initHand(this.getTable().getDealer().getCardsForPlayer());

    log.info(" --- ");
    log.log(Level.INFO, " dealer name: {0}", this.table.getDealer().getName());
    for (final PlayingCard card : this.table.getDealer().getHand().getAllCards()) {
      log.log(Level.INFO, " dealer (all) card: {0}", card);
    }
    for (final PlayingCard card : this.table.getDealer().getHand().getUpCards()) {
      log.log(Level.INFO, " dealer (up) card: {0}", card);
    }
    log.log(Level.INFO, " dealer game strategy: {0}", this.table.getDealer().getStrategy());
    log.info(" --- ");
    log.log(Level.INFO, " player name: {0}", this.table.getPlayer().getName());
    for (final PlayingCard card : this.table.getPlayer().getHand().getUpCards()) {
      log.log(Level.INFO, " player up card: {0}", card);
    }
    log.log(Level.INFO, " player game strategy: {0}", this.table.getPlayer().getStrategy());


    this.setGameStarted(true);
    log.info("...game started!");
  }
}
