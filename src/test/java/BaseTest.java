import java.util.List;
import org.sql2o.*;
import java.util.ArrayList;
import org.junit.*;
import static org.junit.Assert.*;

public class BaseTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void base_instantiatesCorrectly(){
    Base testBase = new Base("Lagos", 1);
    assertEquals(testBase.getLocation(),"Lagos");
    assertEquals(testBase.isDestroyed(), false);
    testBase.setDestroyed();
    assertEquals(testBase.isDestroyed(), true);
  }
}
