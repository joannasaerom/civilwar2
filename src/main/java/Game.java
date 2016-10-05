import org.sql2o.*;
import java.util.List;
import java.util.ArrayList;
import java.sql.Timestamp;
import java.util.Date;
import java.text.DateFormat;

public class Game{

  private int turns;
  private User player1;
  private User player2;
  private boolean gameOver;
  private User victor;
  private boolean isTwoPlayer;

  public Game(String _player1Name,String  _player2Name, int  _numberOfBases, boolean _isTwoPlayer) {
    player1 = new User(_player1Name, 1, _numberOfBases);
    player2 = new User(_player2Name, 2, _numberOfBases);
    isTwoPlayer = _isTwoPlayer;
    gameOver = false;
    turns = 1;
  }

  public int getTurns(){
    return turns;
  }

  public User getPlayerOfTurn(){
    if (turns%2==0){
      return player2;
    } else {
      return player1;
    }
  }

  public User getNonTurnPlayer(){
    if (turns%2==0){
      return player1;
    } else {
      return player2;
    }
  }

  public User getPlayer1(){
    return player1;
  }

  public User getPlayer2(){
    return player2;
  }

  // public User getHitPlayer(int _playerNum){
  //   if(_playerNum == 1){
  //     return this.getPlayer1();
  //   } else if (_playerNum == 2){
  //     return this.getPlayer2();
  //   } else{
  //     throw new IllegalArgumentException("you must enter either 1 or 2 as an argument");
  //   }
  // }

  public User getVictor(){
    return victor;
  }

  public boolean isGameOver(){
    return gameOver;
  }

  public boolean isTwoPlayer(){
    return isTwoPlayer;
  }

  public void changeTurns(){
    if (player1.isLoser() == true){
      victor = player2;
      this.saveVictor();
      gameOver = true;
    } else if (player2.isLoser() == true){
      victor = player1;
      this.saveVictor();
      gameOver = true;
    }
    if(gameOver == false){
      turns++;
    }
  }

  public void attackPlayer(String _targetLocation){
    if((this.getPlayerOfTurn().getTargetsMissed().indexOf(_targetLocation) != -1) || (this.getPlayerOfTurn().getTargetsHit().indexOf(_targetLocation) != -1)){
      throw new IllegalArgumentException("this target has already been chosen");
    }
    for(Base base : this.getNonTurnPlayer().getBases()){
      if(!_targetLocation.equals(base.getLocation())){
        this.changeTurns();
        this.getPlayerOfTurn().addToTargetsMissed(_targetLocation);
      } else{
        base.setDestroyed();
        this.getPlayerOfTurn().addToTargetsHit(_targetLocation);
      }
    }
    boolean allDestroyed = true;
    for(Base base: this.getNonTurnPlayer().getBases()){
      if(base.isDestroyed() == false){
        allDestroyed = false;
      }
    }
    if (allDestroyed == true){
      this.getNonTurnPlayer().setLoser();
    }
  }

  public void saveVictor(){
    try(Connection con = DB.sql2o.open()){
      String sql = "INSERT INTO hall_of_fame (name, turns, moment) VALUES (:name, :turns, now())";
      con.createQuery(sql)
        .addParameter("name", victor.getName())
        .addParameter("turns", turns)
        .executeUpdate();
    }
  }



}
