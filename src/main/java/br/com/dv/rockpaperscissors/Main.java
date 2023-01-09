package br.com.dv.rockpaperscissors;

import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        List<String> potentialMoves = List.of("rock", "scissors", "paper");

        while (true) {
            String userInput = scanner.nextLine();

            if (Objects.equals(userInput, "!exit")) {
                System.out.print("Bye!");
                break;
            }

            boolean isMove = false;
            for (String move : potentialMoves) {
                if (Objects.equals(userInput, move)) {
                    isMove = true;
                    break;
                }
            }

            if (!isMove) {
                System.out.println("Invalid input");
            } else {
                int randomIndex = random.nextInt(potentialMoves.size());
                String computerMove = potentialMoves.get(randomIndex);

                if (Objects.equals(userInput, computerMove)) {
                    System.out.printf("There is a draw (%s)%n", userInput);
                } else {
                    switch (userInput) {
                        case "rock":
                            if (Objects.equals(computerMove, "paper")) {
                                System.out.printf("Sorry, but the computer chose %s%n", computerMove);
                            } else {
                                System.out.printf("Well done. The computer chose %s and failed%n", computerMove);
                            }
                            break;
                        case "paper":
                            if (Objects.equals(computerMove, "scissors")) {
                                System.out.printf("Sorry, but the computer chose %s%n", computerMove);
                            } else {
                                System.out.printf("Well done. The computer chose %s and failed%n", computerMove);
                            }
                            break;
                        case "scissors":
                            if (Objects.equals(computerMove, "rock")) {
                                System.out.printf("Sorry, but the computer chose %s%n", computerMove);
                            } else {
                                System.out.printf("Well done. The computer chose %s and failed%n", computerMove);
                            }
                            break;
                    }
                }
            }
        }
    }

}
