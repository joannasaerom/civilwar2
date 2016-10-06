import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/one-player", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      request.session().attribute("two-player-mode", false);
      model.put("template", "templates/one-player.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/two-player", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      request.session().attribute("two-player-mode", true);
      model.put("template", "templates/two-player.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/select-bases", (request, response) ->{
      Map<String, Object> model = new HashMap<String, Object>();
      String player1Name = request.queryParams("name1");
      String player2Name = request.queryParams("name2");
      Game game = new Game(player1Name, player2Name, 5, request.session().attribute("two-player-mode"));
      request.session().attribute("game", game);
      request.session().attribute("player1", game.getPlayer1());
      request.session().attribute("player2", game.getPlayer2());
      model.put("template", "templates/select-bases.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/play/:playerOfTurn/start", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Game game = request.session().attribute("game");
      String player1Bases = request.queryParams("player1-bases");
      String player2Bases = request.queryParams("player2-bases");
      game.getPlayer1().addBases(player1Bases);
      game.getPlayer2().addBases(player2Bases);
      model.put("game", game);
      model.put("template", "templates/gameplay.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/play/:playerOfTurn/:turns", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Game game = request.session().attribute("game");
      String target = request.queryParams("target");
      game.attackPlayer(target);
      model.put("game", game);
      if (game.isGameOver()==true){
        game.saveVictor();
        game.getHallOfFame();
        model.put("hall-of-fame", HallOfFame.class);
        model.put("template", "templates/game-over.vtl");
      } else{
        model.put("template", "templates/gameplay.vtl");
      }
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

  }
}
