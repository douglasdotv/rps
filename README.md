# rps-1

[![en](https://img.shields.io/badge/lang-en-red.svg)](https://github.com/douglasdotv/rps-1/blob/master/README.md)
[![pt-br](https://img.shields.io/badge/lang-pt--br-green.svg)](https://github.com/douglasdotv/rps-1/blob/master/README.pt-br.md)

This is my own solution for [rps](https://hyperskill.org/projects/314?track=12), a Hyperskill Java Backend Developer track project.

It's a simple game in which the user can play against the computer. The user is prompted to enter their name, and their rating is retrieved from a file called "rating.txt" which contains a list of players and their ratings. If the user is not found in the file, their rating is set to 0. The user can then enter a list of moves they want to play with, separated by commas. If no moves are entered, default moves are selected. The computer will randomly choose one of those moves, and there is also an in-built logic to decide each move weaknesses. If the user types "!exit", the game will end, and if they type "!rating", their current rating will be displayed. The game will continue to run until the user exits it. Each round, if the user and the computer have the same move, it's a draw and the user's rating will increase by 50. If the user wins, the user's rating will increase by 100.

This project is composed by the following classes:

- Main: entry point of the application
- GameManager: manages the game, it has methods to ask for the player name, establish their rating, ask for the moves and play the game with them
- FileHandler: reads the file "rating.txt" and puts the data in a HashMap
- Player: player model, holds player name and rating

### How to run

1. Make sure you have Java 8 or higher and Maven installed.
2. Open the command prompt (or a similar text-based interface) and navigate to the root directory of the project.. 
3. Clone the repository through the following command:
```
git clone https://github.com/douglasdotv/rps-1.git
```
4. On the project root folder, run the following command to build the project: 
```
mvn package
```
5. Finally, run the following command to start the game:
```
java -jar target/rps-1.0-SNAPSHOT.jar
```

Note: if you encounter any issues building or running the project, please ensure that you have the latest version of Java and Maven installed, and that your system environment variables are configured correctly.
