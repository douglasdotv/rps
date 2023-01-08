package br.com.dv.rockpaperscissors;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String userInput = scanner.nextLine();

        String computerMove = switch (userInput) {
            case "paper" -> "scissors";
            case "scissors" -> "rock";
            case "rock" -> "paper";
            default -> null;
        };

        System.out.printf("Sorry, but the computer chose %s", computerMove);
    }

}
