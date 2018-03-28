package at.problemtest.problemtest.pset2;


import at.problemtest.problemtest.pset2.controller.Game;

import java.util.Scanner;

public class pset2main {
    public static void main(String[] args) {
         String playAgain;
        Scanner scanner = new Scanner(System.in);
        System.out.println("welcome to Rock, Paper, Scissor");
        do{
            new Game().play();
            System.out.println("Do u like to play agine? (y/n)");
            playAgain = scanner.next();
        }while (playAgain.toLowerCase().startsWith("y") );

        System.out.println(" Good bye");
        System.exit(0);

    }
}
