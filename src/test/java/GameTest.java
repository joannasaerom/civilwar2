import java.util.List;
import org.sql2o.*;
import java.util.ArrayList;
import org.junit.*;
import static org.junit.Assert.*;

public class GameTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void game_instantiatesCorrectly(){
    Game testGame = new Game("Kakarot", "Vegeta", 5, true);
    assertTrue(testGame instanceof Game);
  }

  @Test
  public void getters_worksProperly(){
    Game testGame = new Game("Kakarot", "Vegeta", 5, true);
    assertEquals(1, testGame.getTurns());
    assertEquals(testGame.getPlayer1(), testGame.getPlayerOfTurn());
    assertEquals(testGame.getPlayer2(), testGame.getNonTurnPlayer());
    assertEquals(testGame.isGameOver(), false);
    assertEquals(testGame.isTwoPlayer(), true);
  }

  @Test
  public void changeTurns_functionsProperly(){
    Game testGame = new Game("Kakarot", "Vegeta", 5, true);
    testGame.changeTurns();
    assertEquals(testGame.isGameOver(), false);
    assertEquals(2, testGame.getTurns());
    testGame.getPlayer1().setLoser();
    testGame.changeTurns();
    assertEquals(testGame.isGameOver(), true);
  }

}
