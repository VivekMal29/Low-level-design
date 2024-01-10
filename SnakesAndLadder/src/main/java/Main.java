import Entities.Player;
import Service.Game;

import java.awt.desktop.SystemEventListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Snakes and Ladder Game ...");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the board size :");
        int boardSize = scanner.nextInt();

        System.out.println("Please enter the number of Players :");
        int noOfPlayers = scanner.nextInt();

        System.out.println("Please enter the number of Snakes :");
        int numSnakes = scanner.nextInt();

        System.out.println("Please enter the number of Ladder :");
        int numLadder = scanner.nextInt();

        System.out.println("Please enter the number of Dice :");
        int numOfDice = scanner.nextInt();

        System.out.println("Ready to play with :");
        System.out.println("Board Size: " + boardSize);
        System.out.println("Number of Players : " + noOfPlayers);
        System.out.println("Number of Snakes: " + numSnakes);
        System.out.println("Number of Ladder: " + numLadder);
        System.out.println("Number of Dice: " + numOfDice);

        Game snakesAndLadderGame = new Game(boardSize,numSnakes,numLadder,noOfPlayers,numOfDice);

        snakesAndLadderGame.initializeDice();
        snakesAndLadderGame.initializeBoard();
        snakesAndLadderGame.initializePlayers();

        snakesAndLadderGame.play();

        Player winner =snakesAndLadderGame.players.get((snakesAndLadderGame.winnerId) - 1);
        System.out.println("winner is " + winner.name);
        System.out.println("Steps taken by winner :");
        winner.stepsTaken.forEach(System.out::println);
    }


}