import org.sql2o.*;
import java.util.List;
import java.util.ArrayList;
import java.sql.Timestamp;
import java.util.Date;
import java.text.DateFormat;

public class Game{

  private int turns = 0;
  private User player1;
  private User player2;
  private boolean gameOver = false;
  private User victor;

  public Game(String _player1Name,String  _player2Name,int  _numberOfBases) {
    player1 = new User(_player1Name, 1, _numberOfBases);
    player2 = new User(_player2Name, 2, _numberOfBases);
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


}
