var selectedStates = [];
var targetState="";

$(document).ready(function() {
    initMap();
  });
    //function to check if cursor's long lat is contained within boundaries of a polygon
  google.maps.Polygon.prototype.Contains = function(latLng)
  {
    var j = 0;
    var oddNodes = false;
    var x = latLng.lng();
    var y = latLng.lat();
    for (var i = 0; i < this.getPath().getLength(); i++) {
      j++;
      if (j == this.getPath().getLength()) { j = 0; }
      if (((this.getPath().getAt(i).lat() < y) &&
        (this.getPath().getAt(j).lat() >= y) ||
        (this.getPath().getAt(j).lat() < y) &&
        (this.getPath().getAt(i).lat() >= y))) {
          if (this.getPath().getAt(i).lng() +
            (y - this.getPath().getAt(i).lat()) / (this.getPath().getAt(j).lat() - this.getPath().getAt(i).lat()) * (this.getPath().getAt(j).lng() - this.getPath().getAt(i).lng()) < x) {
              oddNodes = !oddNodes
          }
        }
      }
    return oddNodes;
  }

  function initMap() {
    //generates map
    var map = new google.maps.Map(document.getElementById('sample'), {
      center: {lat: 37.09024, lng: -95.712891},
      zoom:4,
      mapTypeId:google.maps.MapTypeId.ROADMAP,
      disableDefaultUI: true,
      styles: [
            {elementType: 'geometry', stylers: [{color: '#242f3e'}]},
            {elementType: 'geometry.stroke', stylers: [{color: '#ffe6cc'}]},
            {elementType: 'labels.text.stroke', stylers: [{color: '#242f3e'}]},
            {elementType: 'labels.text.fill', stylers: [{color: '#ffe6cc'}]},
            {
              featureType: 'road',
              elementType: 'geometry',
              stylers: [{visibility: 'off'}]
            },
            {
              featureType: 'road',
              elementType: 'geometry.stroke',
              stylers: [{visibility: 'off'}]
            },
            {
              featureType: 'road',
              elementType: 'labels.text.fill',
              stylers: [{visibility: 'off'}]
            },
            {
              featureType: 'road.highway',
              elementType: 'geometry',
              stylers: [{visibility: 'off'}]
            },
            {
              featureType: 'road.highway',
              elementType: 'geometry.stroke',
              stylers: [{visibility: 'off'}]
            },

            {
              //sets color for body of water
              featureType: 'water',
              elementType: 'geometry',
              stylers: [{color: '#17263c'}]
            },
            {
              //sets text for body of water
              featureType: 'water',
              elementType: 'labels.text.fill',
              stylers: [{color: '#ffe6cc'}]
            }
          ]
        });

        map.setOptions({draggable: false, disableDoubleClickZoom: true});

    function States(name, polygon) {
      this.name = name;
      this.polygon = polygon;
    }
//create array list for all 50 states
    var states = [];

//polygon for alaska
    var alaskaPolygon = new google.maps.Polygon({
      paths: alaskaCoords,
      strokeColor: '#aaaaaa',
      strokeOpacity: 0.8,
      strokeWeight: 2,
      fillColor: '#aaaaaa',
      fillOpacity: 0.35
    });
//add alaska to states arry
var alaska = new States("alaska", alaskaPolygon);
    states.push(alaska);


  //polygon for arkansas
      var arkansasPolygon = new google.maps.Polygon({
        paths: arkansasCoords,
        strokeColor: '#aaaaaa',
        strokeOpacity: 0.8,
        strokeWeight: 2,
        fillColor: '#aaaaaa',
        fillOpacity: 0.35
      });
  //add arkansas to states array
  var arkansas = new States("arkansas", arkansasPolygon);

      states.push(arkansas);



var alabamaPolygon = new google.maps.Polygon({
  paths: alabamaCoords,
  strokeColor: '#aaaaaa',
  strokeOpacity: 0.8,
  strokeWeight: 2,
  fillColor: '#aaaaaa',
  fillOpacity: 0.35
});
var alabama = new States("alabama", alabamaPolygon);

states.push(alabama);


var arizonaPolygon = new google.maps.Polygon({
  paths: arizonaCoords,
  strokeColor: '#aaaaaa',
  strokeOpacity: 0.8,
  strokeWeight: 2,
  fillColor: '#aaaaaa',
  fillOpacity: 0.35
});
var arizona = new States("arizona", arizonaPolygon);

states.push(arizona);



var californiaPolygon = new google.maps.Polygon({
  paths: californiaCoords,
  strokeColor: '#aaaaaa',
  strokeOpacity: 0.8,
  strokeWeight: 2,
  fillColor: '#aaaaaa',
  fillOpacity: 0.35
});
var california = new States("california", californiaPolygon);

states.push(california);



var coloradoPolygon = new google.maps.Polygon({
  paths: coloradoCoords,
  strokeColor: '#aaaaaa',
  strokeOpacity: 0.8,
  strokeWeight: 2,
  fillColor: '#aaaaaa',
  fillOpacity: 0.35
});
var colorado = new States("colorado", coloradoPolygon);

states.push(colorado);


var connecticutPolygon = new google.maps.Polygon({
  paths: connecticutCoords,
  strokeColor: '#aaaaaa',
  strokeOpacity: 0.8,
  strokeWeight: 2,
  fillColor: '#aaaaaa',
  fillOpacity: 0.35
});
var connecticut = new States("connecticut", connecticutPolygon);

states.push(connecticut);



var delawarePolygon = new google.maps.Polygon({
  paths: delawareCoords,
  strokeColor: '#aaaaaa',
  strokeOpacity: 0.8,
  strokeWeight: 2,
  fillColor: '#aaaaaa',
  fillOpacity: 0.35
});
var delaware = new States("delaware", delawarePolygon);

states.push(delaware);



var floridaPolygon = new google.maps.Polygon({
  paths: floridaCoords,
  strokeColor: '#aaaaaa',
  strokeOpacity: 0.8,
  strokeWeight: 2,
  fillColor: '#aaaaaa',
  fillOpacity: 0.35
});
var florida = new States("florida", floridaPolygon);

states.push(florida);



var georgiaPolygon = new google.maps.Polygon({
  paths: georgiaCoords,
  strokeColor: '#aaaaaa',
  strokeOpacity: 0.8,
  strokeWeight: 2,
  fillColor: '#aaaaaa',
  fillOpacity: 0.35
});
var georgia = new States("georgia", georgiaPolygon);

states.push(georgia);



var hawaiiPolygon = new google.maps.Polygon({
  paths: hawaiiCoords,
  strokeColor: '#aaaaaa',
  strokeOpacity: 0.8,
  strokeWeight: 2,
  fillColor: '#aaaaaa',
  fillOpacity: 0.35
});
var hawaii = new States("hawaii", hawaiiPolygon);

states.push(hawaii);



var iowaPolygon = new google.maps.Polygon({
  paths: iowaCoords,
  strokeColor: '#aaaaaa',
  strokeOpacity: 0.8,
  strokeWeight: 2,
  fillColor: '#aaaaaa',
  fillOpacity: 0.35
});
var iowa = new States("iowa", iowaPolygon);

states.push(iowa);



var idahoPolygon = new google.maps.Polygon({
  paths: idahoCoords,
  strokeColor: '#aaaaaa',
  strokeOpacity: 0.8,
  strokeWeight: 2,
  fillColor: '#aaaaaa',
  fillOpacity: 0.35
});
var idaho = new States("idaho", idahoPolygon);

states.push(idaho);



var illinoisPolygon = new google.maps.Polygon({
  paths: illinoisCoords,
  strokeColor: '#aaaaaa',
  strokeOpacity: 0.8,
  strokeWeight: 2,
  fillColor: '#aaaaaa',
  fillOpacity: 0.35
});
var illinois = new States("illinois", illinoisPolygon);

states.push(illinois);




var indianaPolygon = new google.maps.Polygon({
  paths: indianaCoords,
  strokeColor: '#aaaaaa',
  strokeOpacity: 0.8,
  strokeWeight: 2,
  fillColor: '#aaaaaa',
  fillOpacity: 0.35
});
var indiana = new States("indiana", indianaPolygon);

states.push(indiana);


var kansasPolygon = new google.maps.Polygon({
  paths: kansasCoords,
  strokeColor: '#aaaaaa',
  strokeOpacity: 0.8,
  strokeWeight: 2,
  fillColor: '#aaaaaa',
  fillOpacity: 0.35
});
var kansas = new States("kansas", kansasPolygon);

states.push(kansas);



var kentuckyPolygon = new google.maps.Polygon({
  paths: kentuckyCoords,
  strokeColor: '#aaaaaa',
  strokeOpacity: 0.8,
  strokeWeight: 2,
  fillColor: '#aaaaaa',
  fillOpacity: 0.35
});
var kentucky = new States("kentucky", kentuckyPolygon);

states.push(kentucky);



var louisianaPolygon = new google.maps.Polygon({
  paths: louisianaCoords,
  strokeColor: '#aaaaaa',
  strokeOpacity: 0.8,
  strokeWeight: 2,
  fillColor: '#aaaaaa',
  fillOpacity: 0.35
});
var louisiana = new States("louisiana", louisianaPolygon);

states.push(louisiana);


var massachusettsPolygon = new google.maps.Polygon({
  paths: massachusettsCoords,
  strokeColor: '#aaaaaa',
  strokeOpacity: 0.8,
  strokeWeight: 2,
  fillColor: '#aaaaaa',
  fillOpacity: 0.35
});
var massachusetts = new States("massachusetts", massachusettsPolygon);

states.push(massachusetts);


var marylandPolygon = new google.maps.Polygon({
  paths: marylandCoords,
  strokeColor: '#aaaaaa',
  strokeOpacity: 0.8,
  strokeWeight: 2,
  fillColor: '#aaaaaa',
  fillOpacity: 0.35
});
var maryland = new States("maryland", marylandPolygon);

states.push(maryland);


var mainePolygon = new google.maps.Polygon({
  paths: maineCoords,
  strokeColor: '#aaaaaa',
  strokeOpacity: 0.8,
  strokeWeight: 2,
  fillColor: '#aaaaaa',
  fillOpacity: 0.35
});
var maine = new States("maine", mainePolygon);

states.push(maine);



var michiganPolygon = new google.maps.Polygon({
  paths: michiganCoords,
  strokeColor: '#aaaaaa',
  strokeOpacity: 0.8,
  strokeWeight: 2,
  fillColor: '#aaaaaa',
  fillOpacity: 0.35
});
var michigan = new States("michigan", michiganPolygon);

states.push(michigan);



var minnesotaPolygon = new google.maps.Polygon({
  paths: minnesotaCoords,
  strokeColor: '#aaaaaa',
  strokeOpacity: 0.8,
  strokeWeight: 2,
  fillColor: '#aaaaaa',
  fillOpacity: 0.35
});
var minnesota = new States("minnesota", minnesotaPolygon);

states.push(minnesota);


var missouriPolygon = new google.maps.Polygon({
  paths: missouriCoords,
  strokeColor: '#aaaaaa',
  strokeOpacity: 0.8,
  strokeWeight: 2,
  fillColor: '#aaaaaa',
  fillOpacity: 0.35
});
var missouri = new States("missouri", missouriPolygon);

states.push(missouri);



var mississippiPolygon = new google.maps.Polygon({
  paths: mississippiCoords,
  strokeColor: '#aaaaaa',
  strokeOpacity: 0.8,
  strokeWeight: 2,
  fillColor: '#aaaaaa',
  fillOpacity: 0.35
});
var mississippi = new States("mississippi", mississippiPolygon);

states.push(mississippi);


var montanaPolygon = new google.maps.Polygon({
  paths: montanaCoords,
  strokeColor: '#aaaaaa',
  strokeOpacity: 0.8,
  strokeWeight: 2,
  fillColor: '#aaaaaa',
  fillOpacity: 0.35
});
var montana = new States("montana", montanaPolygon);

states.push(montana);



var northcarolinaPolygon = new google.maps.Polygon({
  paths: northcarolinaCoords,
  strokeColor: '#aaaaaa',
  strokeOpacity: 0.8,
  strokeWeight: 2,
  fillColor: '#aaaaaa',
  fillOpacity: 0.35
});
var northcarolina = new States("northcarolina", northcarolinaPolygon);

states.push(northcarolina);



var northdakotaPolygon = new google.maps.Polygon({
  paths: northdakotaCoords,
  strokeColor: '#aaaaaa',
  strokeOpacity: 0.8,
  strokeWeight: 2,
  fillColor: '#aaaaaa',
  fillOpacity: 0.35
});
var northdakota = new States("northdakota", northdakotaPolygon);

states.push(northdakota);



var nebraskaPolygon = new google.maps.Polygon({
  paths: nebraskaCoords,
  strokeColor: '#aaaaaa',
  strokeOpacity: 0.8,
  strokeWeight: 2,
  fillColor: '#aaaaaa',
  fillOpacity: 0.35
});
var nebraska = new States("nebraska", nebraskaPolygon);

states.push(nebraska);


var newhampshirePolygon = new google.maps.Polygon({
  paths: newhampshireCoords,
  strokeColor: '#aaaaaa',
  strokeOpacity: 0.8,
  strokeWeight: 2,
  fillColor: '#aaaaaa',
  fillOpacity: 0.35
});
var newhampshire = new States("newhampshire", newhampshirePolygon);

states.push(newhampshire);


var newjerseyPolygon = new google.maps.Polygon({
  paths: newjerseyCoords,
  strokeColor: '#aaaaaa',
  strokeOpacity: 0.8,
  strokeWeight: 2,
  fillColor: '#aaaaaa',
  fillOpacity: 0.35
});
var newjersey = new States("newjersey", newjerseyPolygon);

states.push(newjersey);


var newmexicoPolygon = new google.maps.Polygon({
  paths: newmexicoCoords,
  strokeColor: '#aaaaaa',
  strokeOpacity: 0.8,
  strokeWeight: 2,
  fillColor: '#aaaaaa',
  fillOpacity: 0.35
});
var newmexico = new States("newmexico", newmexicoPolygon);

states.push(newmexico);



var nevadaPolygon = new google.maps.Polygon({
  paths: nevadaCoords,
  strokeColor: '#aaaaaa',
  strokeOpacity: 0.8,
  strokeWeight: 2,
  fillColor: '#aaaaaa',
  fillOpacity: 0.35
});
var nevada = new States("nevada", nevadaPolygon);

states.push(nevada);



var newyorkPolygon = new google.maps.Polygon({
  paths: newyorkCoords,
  strokeColor: '#aaaaaa',
  strokeOpacity: 0.8,
  strokeWeight: 2,
  fillColor: '#aaaaaa',
  fillOpacity: 0.35
});
var newyork = new States("newyork", newyorkPolygon);

states.push(newyork);



var ohioPolygon = new google.maps.Polygon({
  paths: ohioCoords,
  strokeColor: '#aaaaaa',
  strokeOpacity: 0.8,
  strokeWeight: 2,
  fillColor: '#aaaaaa',
  fillOpacity: 0.35
});
var ohio = new States("ohio", ohioPolygon);

states.push(ohio);



var oklahomaPolygon = new google.maps.Polygon({
  paths: oklahomaCoords,
  strokeColor: '#aaaaaa',
  strokeOpacity: 0.8,
  strokeWeight: 2,
  fillColor: '#aaaaaa',
  fillOpacity: 0.35
});
var oklahoma = new States("oklahoma", oklahomaPolygon);

states.push(oklahoma);



var oregonPolygon = new google.maps.Polygon({
  paths: oregonCoords,
  strokeColor: '#aaaaaa',
  strokeOpacity: 0.8,
  strokeWeight: 2,
  fillColor: '#aaaaaa',
  fillOpacity: 0.35
});
var oregon = new States("oregon", oregonPolygon);

states.push(oregon);



var pennsylvaniaPolygon = new google.maps.Polygon({
  paths: pennsylvaniaCoords,
  strokeColor: '#aaaaaa',
  strokeOpacity: 0.8,
  strokeWeight: 2,
  fillColor: '#aaaaaa',
  fillOpacity: 0.35
});
var pennsylvania = new States("pennsylvania", pennsylvaniaPolygon);

states.push(pennsylvania);


var rhodeislandPolygon = new google.maps.Polygon({
  paths: rhodeislandCoords,
  strokeColor: '#aaaaaa',
  strokeOpacity: 0.8,
  strokeWeight: 2,
  fillColor: '#aaaaaa',
  fillOpacity: 0.35
});
var rhodeisland = new States("rhodeisland", rhodeislandPolygon);

states.push(rhodeisland);



var southcarolinaPolygon = new google.maps.Polygon({
  paths: southcarolinaCoords,
  strokeColor: '#aaaaaa',
  strokeOpacity: 0.8,
  strokeWeight: 2,
  fillColor: '#aaaaaa',
  fillOpacity: 0.35
});
var southcarolina = new States("southcarolina", southcarolinaPolygon);

states.push(southcarolina);



var southdakotaPolygon = new google.maps.Polygon({
  paths: southdakotaCoords,
  strokeColor: '#aaaaaa',
  strokeOpacity: 0.8,
  strokeWeight: 2,
  fillColor: '#aaaaaa',
  fillOpacity: 0.35
});

var southdakota = new States("southdakota", southdakotaPolygon);

states.push(southdakota);



var tennesseePolygon = new google.maps.Polygon({
  paths: tennesseeCoords,
  strokeColor: '#aaaaaa',
  strokeOpacity: 0.8,
  strokeWeight: 2,
  fillColor: '#aaaaaa',
  fillOpacity: 0.35
});
var tennessee = new States("tennessee", tennesseePolygon);

states.push(tennessee);


var texasPolygon = new google.maps.Polygon({
  paths: texasCoords,
  strokeColor: '#aaaaaa',
  strokeOpacity: 0.8,
  strokeWeight: 2,
  fillColor: '#aaaaaa',
  fillOpacity: 0.35
});
var texas = new States("texas", texasPolygon);

states.push(texas);


var utahPolygon = new google.maps.Polygon({
  paths: utahCoords,
  strokeColor: '#aaaaaa',
  strokeOpacity: 0.8,
  strokeWeight: 2,
  fillColor: '#aaaaaa',
  fillOpacity: 0.35
});
var utah = new States("utah", utahPolygon);

states.push(utah);



var virginiaPolygon = new google.maps.Polygon({
  paths: virginiaCoords,
  strokeColor: '#aaaaaa',
  strokeOpacity: 0.8,
  strokeWeight: 2,
  fillColor: '#aaaaaa',
  fillOpacity: 0.35
});
var virginia = new States("virginia", virginiaPolygon);

states.push(virginia);



var vermontPolygon = new google.maps.Polygon({
  paths: vermontCoords,
  strokeColor: '#aaaaaa',
  strokeOpacity: 0.8,
  strokeWeight: 2,
  fillColor: '#aaaaaa',
  fillOpacity: 0.35
});
var vermont = new States("vermont", vermontPolygon);

states.push(vermont);



var washingtonPolygon = new google.maps.Polygon({
  paths: washingtonCoords,
  strokeColor: '#aaaaaa',
  strokeOpacity: 0.8,
  strokeWeight: 2,
  fillColor: '#aaaaaa',
  fillOpacity: 0.35
});
var washington = new States("washington", washingtonPolygon);

states.push(washington);



var wisconsinPolygon = new google.maps.Polygon({
  paths: wisconsinCoords,
  strokeColor: '#aaaaaa',
  strokeOpacity: 0.8,
  strokeWeight: 2,
  fillColor: '#aaaaaa',
  fillOpacity: 0.35
});
var wisconsin = new States("wisconsin", wisconsinPolygon);

states.push(wisconsin);



var westvirginiaPolygon = new google.maps.Polygon({
  paths: westvirginiaCoords,
  strokeColor: '#aaaaaa',
  strokeOpacity: 0.8,
  strokeWeight: 2,
  fillColor: '#aaaaaa',
  fillOpacity: 0.35
});
var westvirginia = new States("westvirginia", westvirginiaPolygon);

states.push(westvirginia);

var wyomingPolygon = new google.maps.Polygon({
  paths: wyomingCoords,
  jeremy: wyoming,
  strokeColor: '#aaaaaa',
  strokeOpacity: 0.8,
  strokeWeight: 2,
  fillColor: '#aaaaaa',
  fillOpacity: 0.35
});
var wyoming = new States("wyoming", wyomingPolygon);
states.push(wyoming);

          // var unguessedStates = states.slice(0);
          //
          // for (var i = 0; i < states.length; i++) {
          //   var index = i;
          //   var spliced = 0;
          //   for (var j = 0; j < previousTargetsHit.length; j++) {
          //     for(var k = 0; k < previousTargetsMissed.length; k++){
          //       if(states[i].name===previousTargetsHit[j] || states[i].name===previousTargetsMissed[k]){
          //         unguessedStates.splice(i+spliced, 1);
          //         spliced++;
          //       }
          //     }
          //   }
          // }
          // console.log(unguessedStates);
          // ^^if this works it is genius (albeit redundant)

          console.log(previousTargetsHit);
          console.log(previousTargetsMissed);
          for (var i = 0; i < states.length; i++) {
            for (var j = 0; j < previousTargetsHit.length; j++) {
              if(states[i].name.indexOf(previousTargetsHit) != -1){
                states[i].polygon.setMap(map);
              }
            }
          }

          for (var i = 0; i < states.length; i++) {
            for (var j = 0; j < previousTargetsMissed.length; j++) {
              if(states[i].name.indexOf(previousTargetsMissed) != -1){
                states[i].polygon.setMap(map);
              }
            }
          }

          var statesGuessedString;
          if (previousTargetsHit.length>0){
            statesGuessedString = (previousTargetsMissed + "," + previousTargetsHit);
          } else{
            statesGuessedString = (previousTargetsMissed + previousTargetsHit);
          }

          console.log(statesGuessedString);

          google.maps.event.addListener(map, 'click', function(event){
            for (var i = 0; i < states.length; i++){
              if(states[i].polygon.Contains(event.latLng)) {
                if(statesGuessedString.indexOf(states[i].name) != -1){
                } else{
                  if(targetState.indexOf(states[i].name)===-1 && targetState.length<=1){
                    states[i].polygon.setMap(map);
                    targetState = states[i].name;
                  }
                  google.maps.event.addListener(states[i].polygon, 'click', function(event){
                    for(var k =0; k < states.length; k++){
                      if (states[k].polygon === this){
                        targetState = "";
                        states[k].polygon.setMap(null);
                        $("#attack-finalize").addClass("disable-button");
                      }
                    }
                  });

                }
              }
            }
          });



    };
