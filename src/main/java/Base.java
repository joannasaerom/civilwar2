import org.sql2o.*;
import java.util.List;
import java.util.ArrayList;


public class Base{

  //i think it's best not to send bases to the database, therefore I'm not sure it needs an id.
  private int playerNum;
  //player 1 or 2, is the idea
  private int length;
  private boolean destroyed = false;
  private List<Boolean> nodes = new ArrayList<Boolean>();

  //eventually i think we can put in a second argument for length, I've tried to design it so that later it would be an easy update.
  public Base(int _length, int _playerNum){
    // userId = _userId;
    length = _length;
    playerNum = _playerNum;
    for (int i = 0; i < length; i++) {
      nodes.add(false);
    }
  }

  public boolean isDestroyed(){
    return destroyed;
  }

  //this method will implement the hit on the correct node and will also return a boolean regarding whether the base has been destroyed or not.
  public void hitNode(int _nodeHit){
    //there's an error here, is there a better way to assign a new value to a list member than in the next line?
    nodes.get((_nodeHit-1)) = true;
    if(nodes.contains(false)){
      destroyed = false;
    } else{
      destroyed = true;
    }
  }




}
