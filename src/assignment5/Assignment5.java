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
//ceates the correct variable
        int correct = 0;
//creates a new scanner
        Scanner input = new Scanner(System.in);

        //player 1 enters in the word 
        System.out.println("please enter in a word for player 2 to guess");
        //get word
        String word = input.nextLine();
        //turnes the word into lower case
        word = word.toLowerCase();
        //clear the screen
        for (int i = 0; i < 99; i++) {
            System.out.println("");
        }
        //storeing the original word
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
        while (lives > 0 && correct < legnth) {
            //telling the player lives and further instructions + the current guessed word
            System.out.println("you have " + lives + " lives left");
            System.out.print(sb + "   ");
            System.out.print("player 2 please enter in a letter that you have not entered in before ");
            System.out.println("");
//gets guess
            String guess = input.nextLine();
            //turnes it into lower case to keep it the same as the original word 
            String g = guess.toLowerCase();

            //turnes the first letter enterred into a char
            char guessl = g.charAt(0);

            //checks each letter for the selected letter
            int u = 0;
            while (u < legnth) {
//gets the letter at u
                char selectedL = word2.charAt(u);
//if it is the same as the guessed letter replace it in the word converted into dashes
                if (selectedL == guessl) {
                    sb.setCharAt(u, guessl);
                    correct++;
                }

                u++;
            }
//if u reaches the end of the word decrese lives counter
            if (u == legnth && !word2.contains(guess)) {
                lives--;
            }
        }
//when the correct counter is the legnth of the word check if they used the same letter twice
        if (correct == legnth) {
            for (int i = 0; i < legnth;) {

                char selectedL = sb.charAt(i);

                if (selectedL != '-') {
                    i++;
                    if (i == legnth) {

                        System.out.println("You have guesed the word corectly");
                        System.out.println("Payer 1 has lost");
                        System.out.println("Player 2 wins");
                        break;
                    }
if (selectedL == '-') {
                    System.out.println("you cheated you lose");
                }
                }
                
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
