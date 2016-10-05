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
  //these empty strings may add an undefined value to arrays unnecessarily, remember to troubleshoot!
  private String targetsMissed = "";
  private String targetsHit = "";

  //i think it's best to relate bases this way, they wouldn't go on a database (or so i think...)
  private List<Base> bases = new ArrayList<Base>();



  public User(String _name, int _playerNum, int _numberOfBases){
    name = _name;
    //playerNum can probably be taken out
    playerNum = _playerNum;
    loser = false;
  }

  public boolean isLoser(){
    return loser;
  }

  public void setLoser(){
    loser = true;
  }

  public void addBase(String _location){
    Base base = new Base(_location, playerNum);
    bases.add(base);
  }

  public void addBases(String _allBaseLocations){
    String[] allBases = _allBaseLocations.split("");
    for(_base : allBases){
      this.addBase(_base)
    }
  }

  public String getName(){
    return name;
  }

  public int getPlayerNum(){
    return playerNum;
  }

  public List<Base> getBases(){
    return bases;
  }

  public String getTargetsHit(){
    return targetsHit;
  }

  public String getTargetsMissed(){
    return targetsMissed;
  }

  public void addToTargetsHit(String _targetsHit){
    String [] targetsHitArray = targetsHit.split(",");
    targetsHitArray.add(_targetsHit);
    targetsHit = targetsHitArray.join(",");
  }

  public void addToTargetsHit(String _targetsMissed){
    String [] targetsMissedArray = targetsMissed.split(",");
    targetsMissedArray.add(_targetsMissed);
    targetsMissed = targetsMissedArray.join(",");
  }


}
