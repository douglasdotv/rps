package br.com.dv.rockpaperscissors;

import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Enter your name: ");
        String userName = scanner.nextLine();
        System.out.printf("Hello, %s%n", userName);

        HashMap<String, Integer> players = new HashMap<>();

        try {
            InputStream inputStream = Main.class.getClassLoader().getResourceAsStream("rating.txt");
            assert inputStream != null;
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] lineWords = line.split("\\s+");
                players.put(lineWords[0], Integer.parseInt(lineWords[1]));
            }
            reader.close();
            inputStream.close();
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }

        Integer rating = players.get(userName);
        if (rating == null) {
            rating = 0;
        }

        String enteredMoves = scanner.nextLine();

        List<String> potentialMoves;
        if (enteredMoves.isEmpty()) {
            potentialMoves = List.of("rock", "scissors", "paper");
        } else {
            potentialMoves = Arrays.stream(enteredMoves.split(","))
                    .map(String::trim)
                    .collect(Collectors.toList());
        }

        System.out.println("Okay, let's start");

        while (true) {
            String userInput = scanner.next();

            if (Objects.equals(userInput, "!exit")) {
                System.out.print("Bye!");
                scanner.close();
                break;
            }

            if (Objects.equals(userInput, "!rating")) {
                System.out.printf("Your rating: %d%n", rating);
            } else if (!potentialMoves.contains(userInput)) {
                System.out.println("Invalid input");
            } else {
                int randomIndex = random.nextInt(potentialMoves.size());
                String computerMove = potentialMoves.get(randomIndex);

                if (Objects.equals(userInput, computerMove)) {
                    System.out.printf("There is a draw (%s)%n", userInput);
                    rating += 50;
                } else {
                    List<String> newPotentialMoves = new ArrayList<>();
                    int userInputIndex = potentialMoves.indexOf(userInput);

                    for (int i = userInputIndex + 1; i < potentialMoves.size(); i++) {
                        newPotentialMoves.add(potentialMoves.get(i));
                    }

                    for (int i = 0; i < userInputIndex; i++) {
                        newPotentialMoves.add(potentialMoves.get(i));
                    }

                    randomIndex = random.nextInt(newPotentialMoves.size());
                    computerMove = newPotentialMoves.get(randomIndex);
                    if (randomIndex >= newPotentialMoves.size() / 2) {
                        System.out.printf("Well done. The computer chose %s and failed%n", computerMove);
                        rating += 100;
                    } else {
                        System.out.printf("Sorry, but the computer chose %s%n", computerMove);
                    }
                }
            }
        }
    }

}
