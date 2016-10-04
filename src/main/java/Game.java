import org.sql2o.*;
import java.util.List;
import java.util.ArrayList;
import java.sql.Timestamp;
import java.util.Date;
import java.text.DateFormat;

public class Game{

  private int turns = 1;
  private User player1;
  private User player2;
  private boolean gameOver = false;
  private User victor;

  public Game(String _player1Name,String  _player2Name,int  _numberOfBases) {
    player1 = new User(_player1Name, 1, _numberOfBases);
    player2 = new User(_player2Name, 2, _numberOfBases);
  }

  public int getTurns(){
    return (turns + 1);
  }

  public User getPlayer1(){
    return player1;
  }

  public User getPlayer2(){
    return player2;
  }

  public User getHitPlayer(int _playerNum){
    if(_playerNum == 1){
      return this.getPlayer1();
    } else if (_playerNum == 2){
      return this.getPlayer2();
    } else{
      throw new IllegalArgumentException("you must enter either 1 or 2 as an argument");
    }
  }

  public User getVictor(){
    return victor;
  }

  public boolean isGameOver(){
    return gameOver;
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

  public void saveVictor(){
    try(Connection con = DB.sql2o.open()){
      String sql = "INSERT INTO hall_of_fame (name, turns, moment) VALUES (:name, :turns, now())";
      con.createQuery(sql)
        .addParameter("name", victor)
        .addParameter("turns", turns)
        .executeUpdate();
    }
  }

  public void attackPlayer(User _playerHit, int _baseHit, int _nodeHit){
    if(_baseHit==0 || _nodeHit == 0){
    } else{
      _playerHit.getBases().get(_baseHit-1).hitNode(_nodeHit);
      boolean allDestroyed = true;
      for(Base base: _playerHit.getBases()){
        if(base.isDestroyed() == false){
          allDestroyed = false;
        }
      }
      if (allDestroyed == true){
        _playerHit.setLoser();
      }
    }
  }


}
