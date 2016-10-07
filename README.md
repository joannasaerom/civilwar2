Civil War 2
by [Jeremy Fryd, Andy Malkin, Joanna Anderson, Thomas Rivas, and Ryan Vinyard]

version 0.0.1, October 7, 2016

## Description
The year is 2089. Humanities' ambitions have grown by leaps and bounds, and a rogue AI has gained control of most of the United States' nuclear arsenal. It is up to you, the commander, to fight off the AI threat. One player can play against a computer controlled opponent, or one player can take on the role of the AI.

### Specifications

| Behavior                                                                      | Input                                                                                                                    | Output                                                                                                  |
|-------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------|
| Can launch an instance of the game                                            | Game start                                                                                                               | Form for User 1 and User 2's names                                                                      |
| Can accept user names and display game map                                    | Vegeta, Kakarot                                                                                                          | "Vegeta, select your five military bases" and display of game map                                       |
| Allows player 1, then player 2 to highlight up to 5 US States                 | Oregon, Idaho, Mississippi, Florida, Kansas selected                                                                     | Oregon, Idaho, Mississippi, Florida, Kansas highlighted on map. Vegeta cannot highlight any more states |
| Accepts player's inputs of states and stores them as variables                | Player clicks "add bases" and then "finalize"                                                                            | selectedStateNames stores state values,                                                                 |
| Accepts both players unique state selections, or overlapping state selections | Vegeta picks Oregon, Idaho, Mississippi, Florida, Kansas . Kakarot picks Oregon, North Carolina, Maine, Idaho, and Texas | Vegeta and Kakarot's values are stored separately into objects                                          |
| Accepts player "attack" and switches to opposing player if attack is missed   | Vegeta selects Nebraska and attacks                                                                                      | Kakarot's turn                                                                                          |
| Player is allowed another attack if attack is successful                      | Kakarot picks Oregon                                                                                                     | Kakarot's turn (again)                                                                                  |
| Game ends when all of one player's bases are destroyed                        | Kakarot destroys all of Vegeta's bases                                                                                   | Kakrot is declared victor in game over screen                                                           |
| Game can store previous victors in "hall of fame"                             | Kakarot destroys all of Vegeta's bases in 20 turns, on January 1st 2016 at 10:00                                         | In database: Kakarot, 20 turns, January 1st 2016 10:00                                                  |
| Game state can be refreshed with play again button                            | Play again clicked                                                                                                       | Game refreshes, variables reset                                                                         |

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
