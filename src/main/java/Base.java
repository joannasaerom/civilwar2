import org.sql2o.*;
import java.util.List;
import java.util.ArrayList;


public class Base{

  private String location;
  private int playerNum;
  private boolean destroyed;

  public Base(String _location, int _playerNum){
    location = _location;
    playerNum = _playerNum;
    destroyed = false;
  }

  public String getLocation(){
    return location;
  }

  public void setDestroyed(){
    destroyed = true;
  }

  public boolean isDestroyed(){
    return destroyed;
  }

}
