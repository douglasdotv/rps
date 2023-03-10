package br.com.dv.game;

import java.util.*;

public class GameManager {

    private final Scanner scanner;
    private final Random random;
    private final Player player;
    private final HashMap<String, Integer> players;
    private List<String> moves;

    public GameManager() {
        FileHandler fileHandler = new FileHandler("rating.txt");
        this.players = fileHandler.readFile();
        this.scanner = new Scanner(System.in);
        this.random = new Random();
        this.player = new Player();
    }

    public void askPlayerName() {
        System.out.print("Enter your name: ");
        String userName = scanner.nextLine();
        player.setName(userName);
        greet();
    }

    public void establishPlayerRating() {
        Integer rating = players.get(player.getName());
        if (rating == null) {
            rating = 0;
        }
        player.setRating(rating);
    }

    public void askMoves() {
        System.out.println("Enter the moves you wish to use separated by a comma (\",\"): ");
        String chosenMoves = scanner.nextLine();
        if (chosenMoves.isEmpty()) {
            moves = List.of("rock", "scissors", "paper");
        } else {
            moves = Arrays.stream(chosenMoves.replaceAll(", ", ",").split(",")).toList();
        }
    }

    public void playGame() {
        while (true) {
            String userInput = scanner.next();

            if (Objects.equals(userInput, "!exit")) {
                System.out.print("Bye!");
                scanner.close();
                break;
            }

            if (Objects.equals(userInput, "!rating")) {
                System.out.printf("Your rating: %d%n", player.getRating());
            } else if (!moves.contains(userInput)) {
                System.out.println("Invalid input");
            } else {
                int randomIndex = random.nextInt(moves.size());
                String computerMove = moves.get(randomIndex);

                if (Objects.equals(userInput, computerMove)) {
                    System.out.printf("There is a draw (%s)%n", userInput);
                    player.setRating(player.getRating() + 50);
                } else {
                    List<String> newPotentialMoves = new ArrayList<>();
                    int userInputIndex = moves.indexOf(userInput);

                    for (int i = userInputIndex + 1; i < moves.size(); i++) {
                        newPotentialMoves.add(moves.get(i));
                    }
                    for (int i = 0; i < userInputIndex; i++) {
                        newPotentialMoves.add(moves.get(i));
                    }

                    randomIndex = random.nextInt(newPotentialMoves.size());
                    computerMove = newPotentialMoves.get(randomIndex);
                    if (randomIndex >= newPotentialMoves.size() / 2) {
                        System.out.printf("Well done. The computer chose %s and failed%n", computerMove);
                        player.setRating(player.getRating() + 100);
                    } else {
                        System.out.printf("Sorry, but the computer chose %s%n", computerMove);
                    }
                }
            }
            System.out.println("Choose your next move: ");
        }
    }

    public void greet() {
        System.out.printf("Hello, %s%n", player.getName());
    }

    public void printEarlyGameMessages() {
        System.out.println("Okay, let's start");
        System.out.println("Remember: you can only use the moves you've elected! " +
                "\nList of possible moves: " + moves);
        System.out.println("You can also type \"!rating\" to check your score " +
                "or \"!exit\" to end the game.");
        System.out.println("Now, please choose a move: ");
    }

    public void run() {
        askPlayerName();
        establishPlayerRating();
        askMoves();
        printEarlyGameMessages();
        playGame();
    }

}
