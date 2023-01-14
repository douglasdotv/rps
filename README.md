# rps-1

This is my own solution for [rps](https://hyperskill.org/projects/314?track=12), a Hyperskill Java Backend Developer track project.

It's a simple game in which the user can play against the computer. The user is prompted to enter their name, and their rating is retrieved from a file called "rating.txt" which contains a list of players and their ratings. If the user is not found in the file, their rating is set to 0. The user can then enter a list of moves they want to play with, separated by commas, and the computer will randomly choose one of those moves. There is also an in-built logic to decide each move weaknesses. If the user types "!exit", the game will end, and if they type "!rating", their current rating will be displayed. The game will continue to run until the user types "!exit". Each round, if the user and the computer have the same move, it's a draw and the user's rating will increase by 50. If the user wins, the user's rating will increase by 100.

This project is composed by the following classes:

- Main: entry point of the application and creates an instance of GameManager
- GameManager: manages the game, it has methods to ask for the player name, establish their rating, ask for the moves and play the game with them
- FileHandler: reads the file "rating.txt" and puts the data in a HashMap
- Player: player model, holds player name and rating