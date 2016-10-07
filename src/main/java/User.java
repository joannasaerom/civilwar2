import org.sql2o.*;
import java.util.List;
import java.util.ArrayList;
import java.sql.Timestamp;
import java.util.Date;
import java.text.DateFormat;

public class User{

  private String name;
  private int playerNum;
  private boolean loser;
  private String targetsHit="";
  private String targetsMissed="";
  private List<Base> bases = new ArrayList<Base>();

  public User(String _name, int _playerNum, int _numberOfBases){
    name = _name;
    playerNum = _playerNum;
    loser = false;
  }

  public String getName(){
    return name;
  }

  public int getPlayerNum(){
    return playerNum;
  }

  public boolean isLoser(){
    return loser;
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

  public void setLoser(){
    loser = true;
  }

  public void addToTargetsHit(String _targetHit){
    if(targetsHit.equals("")){
      this.targetsHit += _targetHit;
    } else{
      this.targetsHit += ("," + _targetHit);
    }
  }

  public void addToTargetsMissed(String _targetMissed){
    if(targetsMissed.equals("")){
      this.targetsMissed += _targetMissed;
    } else{
      this.targetsMissed += ("," + _targetMissed);
    }
  }

  public void addBase(String _location){
    Base base = new Base(_location, playerNum);
    bases.add(base);
  }

  public void addBases(String _allBaseLocations){
    String[] allBases = _allBaseLocations.split(",");
    for(String baseName : allBases){
      this.addBase(baseName);
    }
  }

}
