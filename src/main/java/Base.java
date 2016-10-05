import org.sql2o.*;
import java.util.List;
import java.util.ArrayList;


public class Base{

  private String location;
  private int playerNum;
  // private int length;
  private boolean destroyed = false;
  // private List<Boolean> nodes = new ArrayList<Boolean>();

  //eventually i think we can put in a second argument for length, I've tried to design it so that later it would be an easy update.
  public Base(String _location, int _playerNum){
    location = _location;
    playerNum = _playerNum;
    for (int i = 0; i < length; i++) {
      nodes.add(false);
    }
  }

  public String getLocation(){
    return location;
  }

  public boolean setDestroyed(){
    destroyed = true;
  }

  public boolean isDestroyed(){
    return destroyed;
  }

  //this method will implement the hit on the correct node and will also return a boolean regarding whether the base has been destroyed or not.
  // public void hitNode(int _nodeHit){
  //   nodes.set((_nodeHit-1), true);
  //   if(nodes.contains(false)){
  //     destroyed = false;
  //   } else{
  //     destroyed = true;
  //   }
  // }




}
