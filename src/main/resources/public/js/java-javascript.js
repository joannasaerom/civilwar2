var selectedStateNames = [];
var selectedStatesString;

$(document).ready(function() {

  $("#player1-add-bases-button").click(function(){
    if(selectedStateNames.length === 0) {
      selectedStates.forEach(function(state){
        selectedStateNames.push(state.name);
      });
      selectedStatesString = selectedStateNames.join(",");
      console.log(selectedStatesString);
      $("#player1-put-bases-for-java").append("<input name='player1-bases' class='hide' value='" + selectedStatesString + "'>");
    }
    console.log(selectedStatesString);
  });

  $("#player2-add-bases-button").click(function(){
    if(selectedStateNames.length === 0) {
      selectedStates.forEach(function(state){
        selectedStateNames.push(state.name);
      });
      selectedStatesString = selectedStateNames.join(",");
      console.log(selectedStatesString);
      $("#player2-put-bases-for-java").append("<input name='player2-bases' class='hide' value='" + selectedStatesString + "'>");
    }
    console.log(selectedStatesString);
  });

});
