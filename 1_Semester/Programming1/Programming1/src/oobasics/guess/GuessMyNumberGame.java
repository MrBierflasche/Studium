package oobasics.guess;

import java.util.Random;
import java.util.Scanner;

public class GuessMyNumberGame {
    static void main()
    {
        GuessMyNumberGame game = new GuessMyNumberGame();
        game.start();
    }
    private  final Scanner sc =new Scanner(System.in);
    private final Random rand = new Random();

    public  void start(){
        System.out.println("Guess My Number Game between 1 and 10");
        int numberToGuess = rand.nextInt(11);
        int guess = sc.nextInt();
        while ( guess !=numberToGuess){
            if(guess > numberToGuess){
                System.out.println("Gesuchte Zahl kleiner wie " + guess);
            }else {
                System.out.println("Gesuchte Zahl groesser wie " + guess);
            }
            guess = sc.nextInt();
        }

        System.out.println("Richtig " + guess);
    }
}
