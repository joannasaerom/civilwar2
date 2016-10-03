import org.sql2o.*;
import java.util.List;
import java.util.ArrayList;


public class Base{

  //i think it's best not to send bases to the database, therefore I'm not sure it needs an id.
  // private int id;
  private int userId;
  private int length;

  public Base(int _userId){
    userId = _userId;
    length = 1;
  }

  List<boolean> nodes = new ArrayList<boolean>();

  public String buildBase(){
    for (i = 0; i< length; i++) {
      nodes.add(false);
    }
  }

  //this method will implement the hit on the correct node and will also return a boolean regarding whether the base has been destroyed or not.
  public boolean hit(int _nodeHit){
    nodes.get(_nodehit-1) = true;
    if(nodes.contains(false)){
      return false;
    } else{
      return true;
    }
  }




}
