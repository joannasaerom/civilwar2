WORLD WAR III in Java
by [Jeremy Fryd, Andy Malkin, Joanna Anderson, Thomas Rivas, and Ryan Vinyard]

version 0.0.1, October 7, 2016

## Description
The year is 2089. Humanities ambitions have grown by leaps and bounds, and a rogue AI has gained control of most of the United States' nuclear arsenal. It is up to you, the commander, to fight off the AI threat. One player can play against a computer controlled opponent, or one player can take on the role of the AI.

### Specifications

| Behavior                                                                    | Input                                                                        | Output                                                                                                                                                    |
|-----------------------------------------------------------------------------|------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------|
| Can launch a one-player game                                                | One player is selected                                                       | Form for the user's name                                                                                                                                  |
| User selects a two-player game                                              | Two player is selected                                                       | Form for the user 1 and user 2's names                                                                                                                    |
| In one player, can accept user name and display game map                    | "John"                                                                       | "John, select your five military bases" and display of game map                                                                                           |
| In one player, allows user to highlight 5 US states                         | Oregon, Idaho, Mississippi, Florida, Kansas selected                         | Oregon, Idaho, Mississippi, Florida, Kansas highlighted on the map. User cannot highlight any more states                                                 |
| Accepts player's inputs of states and stores them as variables              | Player clicks "add" and then "finalize"                                      | selectedStateNames stores state values                                                                                                                    |
| In two player, accepts two players state choices, even if they are the same | Player 1 selects states and finalizes, Player 2 selects states and finalizes | Player's values are stored separately into objects                                                                                                        |
| Turn changes to opposing player upon missed attack                          | Player 1 selects a state to attack and confirms                              | Player 1's attack is declared a miss, Player 2's turn. On subsequent Player 1 turns, state of missed attack is automatically highlighted and unselectable |
| Player is allowed another attack if attack is successful                    | Player 2 selects a state to attack and confirms                              | Player 2's attack is declared successful, player 1's base is set to destroyed, Player 2's turn begins again                                               |
| Game ends when all of one player's bases destroyed                          | Player 1 destroys all player 2 bases                                         | Player 1 is declared victor                                                                                                                               |
| Game can store previous victors                                             | Player 1: John, wins in 12 turns on January 1st, 10:00                       | In database: John, 12 turns, January 1st 10:00                                                                                                            |
| Game state can be refreshed with play again button                          | Play again clicked                                                           | Game refreshes, variables reset                                                                                                                           |
|                                                                             |                                                                              |                                                                                                                                                           |

### Database Commands

In PSQL:

CREATE DATABASE hall_of_fame;

*\c hall_of_fame*

CREATE TABLE victors (id serial PRIMARY KEY, name varchar, turns int, moment timestamp);

CREATE DATABASE hall_of_fame_test WITH TEMPLATE hall_of_fame;


## Known Issues

Some cleanup required. To do.

## Technology Used
Java, Spark, JUnit, Gradle, HTML, CSS, Javascript.

## Legal
Licensed under GNU 3.0

Copyright (c) 2016 _Jeremy Fryd, Andy Malkin, Joanna Anderson, Thomas Rivas, Ryan Vinyard_ All Rights Reserved.
