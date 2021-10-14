package com.company;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.sql.SQLOutput;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Roulette spin = new Roulette();
        Scanner scanner = new Scanner(System.in);
        boolean playRoulette;
        double userTotalBetSize;
        HashMap<String, Double> playerColorAndBet = new HashMap<String, Double>();
        HashMap<Integer, Double> playerNumberAndBet = new HashMap<Integer,Double>();
        double playerBetOdd;
        double playerBetEven;
        double playerBetFirstDozen;
        double playerBetSecondDozen;
        double playerBetThirdDozen;
        Users users = new Users();

        System.out.println("Welcome to Roulette!");
        System.out.println("Do you wish to start playing? yes/no");
        playRoulette = scanner.nextLine().equalsIgnoreCase("yes");

        while (playRoulette) {


            System.out.println("What bet are you looking to make?");
            System.out.println("1. Bet on number");
            System.out.println("2. Bet on color");
            System.out.println("3. Bet on odd/even");
            System.out.println("4. Bet on dozen");
            System.out.println("5. SPIN THE BALL!");
            System.out.println("Write number for desired action.");
            int action = scanner.nextInt();
            switch (action) {
                case 1 -> {
                    System.out.println("How many numbers would you like to bet on?: ");
                    int numberOfBets = scanner.nextInt();
                    for (int i = 0; i <= numberOfBets; i++) {
                        System.out.println("Enter your number: ");
                        int tempNum = scanner.nextInt();
                        System.out.println("How much do you want to bet on this number?: ");
                        double tempBet = scanner.nextDouble();
                        playerNumberAndBet.put(tempNum,tempBet);
                    }
                }
                case 2 -> {
                    System.out.println("What color would you like to bet on (BLACK, RED, GREEN): ");
                    String color = scanner.next();
                    spin.setColorChoice(color);
                    System.out.println("How much would you like to bet on " + spin.getColorChoice() + "?: ");
                    double playerColorBet = scanner.nextDouble();
                    spin.playerColorAndBet.put(spin.getColorChoice(), playerColorBet);
                }
                case 3 -> {
                    System.out.println("Wanna bet on odd or even?: ");
                    if (scanner.nextLine().equalsIgnoreCase("odd")) {
                        System.out.println("How much do you want to bet on odd?: ");
                        playerBetOdd = scanner.nextDouble();
                    } else {
                        System.out.println("How much do you want to bet on even?: ");
                        playerBetEven = scanner.nextDouble();
                    }
                }
                case 4 -> {
                    System.out.println("Choose which dozen you would like to place bet on: ");
                    System.out.println("1. 1st 12(1-12)");
                    System.out.println("2. 2nd 12(13-24)");
                    System.out.println("3. 3rd 12(25-36)");
                    if ((scanner.nextLine().equalsIgnoreCase("1"))) {
                        System.out.println("How much would you like to bet on this dozen?: ");
                        spin.setFirstDozen(scanner.nextDouble());
                    } else if (scanner.nextLine().equalsIgnoreCase("2")) {
                        System.out.println("How much would you like to bet on this dozen?: ");
                        spin.setSecondDozen(scanner.nextDouble());
                    } else if (scanner.nextLine().equalsIgnoreCase("3")) {
                        System.out.println("How much would you like to bet on this dozen?: ");
                        spin.setThirdDozen(scanner.nextDouble());
                    } else {
                        System.out.println("That is not an option.");
                    }
                }
                case 5 -> {
                    spin.spinTheBall();
                    spin.ballNumberValues();
                }
            }
            spin.didColorHit();
            System.out.println(users.getTotalWinRoulette());
        }
    }
}