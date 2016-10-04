import org.sql2o.*;
import java.util.List;
import java.util.ArrayList;
import java.sql.Timestamp;
import java.util.Date;
import java.text.DateFormat;

public class User{

  // private int id;
  private String name;
  private int playerNum;
  private boolean loser;

  //i think it's best to relate bases this way, they wouldn't go on a database (or so i think...)
  private List<Base> bases = new ArrayList<Base>();



  public User(String _name, int _playerNum, int _numberOfBases){
    name = _name;
    playerNum = _playerNum;
    loser = false;
  }

  public boolean isLoser(){
    return loser;
  }

  public void setLoser(){
    loser = true;
  }


  public void addBase(int _length){
    Base base = new Base(_length, playerNum);
    bases.add(base);
  }

  public void addFiveBasesOfOne(){
    for (int i = 0; i < 5; i++) {
      this.addBase(1);
    }
  }

  public String getName(){
    return name;
  }

  public List<Base> getBases(){
    return bases;
  }

}
