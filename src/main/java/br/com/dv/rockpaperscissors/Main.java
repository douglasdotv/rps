package br.com.dv.rockpaperscissors;

import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String playerMove = scanner.nextLine();

        List<String> potentialMoves = List.of("rock", "scissors", "paper");

        Random random = new Random();
        int randomIndex = random.nextInt(potentialMoves.size());
        String computerMove = potentialMoves.get(randomIndex);

        if (Objects.equals(playerMove, computerMove)) {
            System.out.printf("There is a draw (%s)", playerMove);
        } else {
            switch (playerMove) {
                case "rock":
                    if (Objects.equals(computerMove, "paper")) {
                        System.out.printf("Sorry, but the computer chose %s", computerMove);
                    } else {
                        System.out.printf("Well done. The computer chose %s and failed", computerMove);
                    }
                    break;
                case "paper":
                    if (Objects.equals(computerMove, "scissors")) {
                        System.out.printf("Sorry, but the computer chose %s", computerMove);
                    } else {
                        System.out.printf("Well done. The computer chose %s and failed", computerMove);
                    }
                    break;
                case "scissors":
                    if (Objects.equals(computerMove, "rock")) {
                        System.out.printf("Sorry, but the computer chose %s", computerMove);
                    } else {
                        System.out.printf("Well done. The computer chose %s and failed", computerMove);
                    }
                    break;
                default:
                    throw new IllegalArgumentException("Invalid player move.");
            }
        }
    }

}
