import java.util.List;
import org.sql2o.*;
import java.util.ArrayList;
import org.junit.*;
import static org.junit.Assert.*;

public class UserTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void user_instantiatesCorrectly(){
  User testUser = new User("Snoop Dogg", 1, 5);
  assertTrue(testUser instanceof User);
  }

  @Test
  public void user_getAndSetLoserMethods(){
    User beck = new User("soy un perdedor", 1, 5);
    assertEquals(beck.isLoser(), false);
    beck.setLoser();
    assertEquals(beck.isLoser(), true);
  }

  @Test
  public void getNameAndPlayerNum_getProperValues(){
    User beck = new User("soy un perdedor", 1, 5);
    assertEquals(beck.getName(), "soy un perdedor");
    assertEquals(beck.getPlayerNum(), 1);
  }

  @Test
  public void addBases_addsBasesToUser(){
    User obama = new User("Barrack", 1, 5);
    obama.addBases("Indonesia,Hawaii,Chicago");
    assertEquals("Hawaii", obama.getBases().get(1).getLocation());
  }

  @Test
  public void addTargetsMissedAndHit_willExtend(){
  User obama = new User("Barrack", 1, 5);
  obama.addToTargetsHit("Iran");
  obama.addToTargetsHit("Cuba");
  assertEquals("Iran, Cuba", obama.getTargetsHit());
  obama.addToTargetsMissed("Libya");
  obama.addToTargetsMissed("Saudi Arabia");
  assertEquals("Libya, Saudi Arabia", obama.getTargetsMissed());
  }



}
