/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment5;

import java.util.Scanner;

/**
 *
 * @author nate
 */
public class Assignment5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int correct = 0;

        Scanner input = new Scanner(System.in);

        //player 1 enters in the word 
        System.out.println("please enter in a word for player 2 to guess");
        String word = input.nextLine();
        word = word.toLowerCase();
        //clear the screen
        for (int i = 0; i < 99; i++) {
            System.out.println("");
        }
        String word2 = word;
        //show how long the word is useing dashes
        int legnth = word.length();
        for (int l = 0; l < legnth; l++) {
            String temp = word.substring(l, l + 1);
            char temp1 = temp.charAt(0);

            word = word.replace(temp1, '-');
            //var word is now dashes
        }
        //convert word into string builder
        StringBuilder sb = new StringBuilder(word);
        int lives = 5;
        //making guesses
        while (lives > 0) {
            System.out.println("you have " + lives + " lives left");
            System.out.println(sb);
            System.out.println("player 2 make your guess");

            String guess = input.nextLine();
            char guessl = guess.charAt(0);

            //checks each letter for the selected letter
            for (int i = 0; i < legnth; i++) {

                char selectedL = word2.charAt(i);

                if (selectedL == guessl) {
                    sb.setCharAt(i, guessl);
                    correct++;
                }

            }
           
            System.out.println("type out a diferent letter");
            if (correct == legnth) {
                System.out.println("You have guesed the word corectly");
                System.out.println("Payer 1 has lost");
                System.out.println("Player 2 wins");
                break;
            }
        }

        if (lives == 0) {

            //tells the player who wins and loses
            System.out.println("Payer 2 has lost");
            System.out.println("the real word is " + word2);
            System.out.println("Player 1 wins");

        }

    }
}
