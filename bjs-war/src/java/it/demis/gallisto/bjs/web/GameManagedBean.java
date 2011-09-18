/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.demis.gallisto.bjs.web;

import it.demis.gallisto.bjs.core.model.BlackjackTable;
import it.demis.gallisto.bjs.core.model.Table;
import it.demis.gallisto.bjs.core.model.cards.PlayingCard;
import it.demis.gallisto.bjs.core.strategies.StrategyException;
import java.io.Serializable;
import java.text.DateFormat;
import java.util.Date;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

/**
 *
 * @author Demis Gallisto
 */
@ManagedBean(name = "game")
@ViewScoped
public class GameManagedBean implements Serializable {

  private transient final Logger log = Logger.getLogger(this.getClass().getName());
  private Date startDate;
  @Inject
  private Table table;
  private boolean gameStarted;
  private boolean gameStopped;

  public GameManagedBean() {
    super();
  }

  public boolean isGameStopped() {
    return gameStopped;
  }

  public void setGameStopped(final boolean _gameStopped) {
    this.gameStopped = _gameStopped;
  }

  public boolean isGameStarted() {
    return this.gameStarted;
  }

  protected void setGameStarted(final boolean _gameStarted) {
    this.gameStarted = _gameStarted;
  }

  public Table getTable() {
    return this.table;
  }

  protected void setTable(final Table _table) {
    this.table = _table;
  }

  public Date getStartDate() {
    return this.startDate;
  }

  protected void setStartDate(final Date _startDate) {
    this.startDate = _startDate;
  }

  public void playerStay() {
    if (this.log.isLoggable(Level.INFO)) {
      log.info("player stay");
    }
    this.getTable().getDealer().showAll();
    this.setGameStopped(true);
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

  @PostConstruct
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
    this.setGameStopped(false);
    log.info("...game started!");
  }
}
