#Civil War 2


### Description

This project is an iteration of the game "Battleship" in which the board is a chosen section of Google Maps. As of now, available "bases" are states of the US, and players win by hitting just one of the five pre-selected by their local opponent ('Two-Player Sudden Death').


&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;![Base Selection Page](Screenshots/select_bases.png?raw=true "Base Selection Page")


### Functionality

* program welcomes users with a title screen where they can choose to play in one or two-player mode (only the latter currently available)
* program takes in names for players 1 &amp; 2, creating corresponding user objects and a game object to run the show
* one at a time, each player can click on the five (and only five) US states they wish to have as their 'bases'
* only US states are clickable, and they highlight when chosen
* if a highlighted state is clicked, it is unhighlighted and unselected
* players choose one base per turn to attack, switching to the other players turn if they miss
* a history of former misses are highlighted on the map during a players turn, these states are un-clickable and will not unhighlight
* once one player hits another's pre-selected base, the game is sent to a game over screen with a list of past winners and an option to replay
* winning player's name, turn count to victory, and time of victory are added to the hall_of_fame database


### Setup

* clone repository
* [install gradle](https://gradle.org/gradle-download/?_ga=1.156561343.568755268.1470681169) for building the program
* [install postgres](https://www.postgresql.org/) for database integration
* run postgres:`postgres`
* run psql:`psql`
* In the psql window, run the following commands:

`CREATE DATABASE hall_of_fame;`

`\c hall_of_fame`

`CREATE TABLE victors (id serial PRIMARY KEY, name varchar, turns int, moment timestamp);`

`CREATE DATABASE hall_of_fame_test WITH TEMPLATE hall_of_fame;`

* run  `gradle test` to ensure reliability
* launch program with `gradle run` and visit your local server at http://localhost:4567/


### Features to be Added

In it's current form, the game also doesn't feature much more strategy than guessing what US state you're opponent might have chosen. We built the backend to allow for bases that extend to cover multiple nodes (states), which are like the lengths of the ships in Battleship, and we would love to write some rules and interface representations for the 'Choose Your Bases' stage so that bordering states could be parts of one larger base. We'd also love to build a little AI to face-off against in a one-player mode!


### Technologies Used

Java, Spark, JUnit, Gradle, HTML, CSS, Javascript.


### Credit

Licensed under GNU 3.0

Copyright (c) 2016 _Jeremy Fryd, Andy Malkin, Joanna Anderson, Thomas Rivas, Ryan Vinyard_ All Rights Reserved.
