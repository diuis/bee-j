/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.demis.gallisto.bjs.web;

import it.demis.gallisto.bjs.model.BlackjackTable;
import it.demis.gallisto.bjs.model.cards.PlayingCard;
import it.demis.gallisto.bjs.strategies.StrategyException;
import java.text.DateFormat;
import java.util.Date;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.swing.text.DateFormatter;

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
  private BlackjackTable table;
  private boolean gameStarted;

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

  public GameManagedBean() {
    super();
  }

  public String getAdvice() {
    String res = null;
    try {
      res = this.getTable().getPlayer().getAdvice(this.getTable().getDealer().getHand());
    } catch (final StrategyException _e) {
      _e.printStackTrace();
    }
    return res;
  }

  public void newGame() {
    log.info("Start a new black jack game...");
    this.setStartDate(new Date());

    log.log(Level.INFO, " new blackjack start date: {0}", DateFormat.getDateTimeInstance().format(this.getStartDate()));
    log.info(" --- ");
    log.log(Level.INFO, " dealer name: {0}", this.table.getDealer().getName());
    for (final PlayingCard card : this.table.getDealer().getHand().getUpCards()) {
      log.log(Level.INFO, " dealer up card: {0}", card);
    }
    log.log(Level.INFO, " dealer game strategy: {0}", this.table.getDealer().getStrategy());
    log.info(" --- ");
    log.log(Level.INFO, " player name: {0}", this.table.getPlayer().getName());
    log.log(Level.INFO, " player game strategy: {0}", this.table.getPlayer().getStrategy());


    this.table.getPlayer().initHand(this.getTable().getDealer().getCardsForPlayer());
    this.setGameStarted(true);
    log.info("...game started!");
  }
}
