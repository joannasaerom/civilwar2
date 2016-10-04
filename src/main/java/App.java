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

    // get("/one-player", (request, response) -> {
    //   Map<String, Object> model = new HashMap<String, Object>();
    //   model.put("template", "templates/index.vtl");
    //   return new ModelAndView(model, layout);
    // }, new VelocityTemplateEngine());

    get("/two-player", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/two-player.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    // post("/one-player/start", (request, response) -> {
    //   Map<String, Object> model = new HashMap<String, Object>();
    //   String player1Name = request.queryParams("name1");
    //   String player2Name = request.queryParams("name2");
    //   Game game = new Game(player1Name, player2Name, 5);
    //   model.put("template", "templates/one-player-gameplay.vtl");
    //   return new ModelAndView(model, layout);
    // }, new VelocityTemplateEngine());

    post("/two-player/start", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      String player1Name = request.queryParams("name1");
      String player2Name = request.queryParams("name2");
      Game game = new Game(player1Name, player2Name, 5);
      User player1 = game.getPlayer1();
      User player2 = game.getPlayer2();
      player1.addFiveBasesOfOne();
      player2.addFiveBasesOfOne();
      request.session().attribute("game", game);
      request.session().attribute("player1", player1);
      request.session().attribute("player2", player2);
      model.put("game", game);
      model.put("player1", player1);
      model.put("player2", player2);
      model.put("template", "templates/two-player-gameplay.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    // post("/one-player/:turns", (request, response) -> {
    //   Map<String, Object> model = new HashMap<String, Object>();
    //   Game game = request.session().attribute("game");
    //   User player1 = request.session().attribute("player1");
    //   User player2 = request.session().attribute("player2");
    //   game.changeTurns();
    //   model.put("game", game);
    //   model.put("player1", player1);
    //   model.put("player2", player2);
    //   if (game.isGameOver()==true){
    //     game.saveVictor();
    //     model.put("template", "templates/game-over.vtl");
    //   } else{
    //     model.put("template", "templates/one-player-gameplay.vtl");
    //   }
    //   return new ModelAndView(model, layout);
    // }, new VelocityTemplateEngine());


    post("/two-player/:turns", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Game game = request.session().attribute("game");
      User player1 = request.session().attribute("player1");
      User player2 = request.session().attribute("player2");
      User playerHit = game.getHitPlayer(Integer.parseInt(request.queryParams("playerHit")));
      int baseHit = Integer.parseInt(request.queryParams("baseHit"));
      int nodeHit = Integer.parseInt(request.queryParams("nodeHit"));
      game.attackPlayer(playerHit, baseHit, nodeHit);
      game.changeTurns();
      model.put("game", game);
      model.put("player1", player1);
      model.put("player2", player2);
      if (game.isGameOver()==true){
        game.saveVictor();
        model.put("template", "templates/game-over.vtl");
      } else{
        model.put("template", "templates/two-player-gameplay.vtl");
      }
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());


  }
}
