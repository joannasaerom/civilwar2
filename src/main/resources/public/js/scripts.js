
$("#map").click(function(){
  $("#attack-result").text("<input name='playerHit' class='hide' value='" + playerHit + "'>" +
    "<input name='baseHit' class='hide' value='" + baseHit + "'>" +
    "<input name='nodeHit' class='hide' value='" + nodeHit + "'>"
  );
});
