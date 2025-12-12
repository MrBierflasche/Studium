package oobasics.guess;

import java.util.Random;
import java.util.Scanner;

public class GuessMyNumberGame2 {
    static void main()
    {
        GuessMyNumberGame2 game = new GuessMyNumberGame2(0 ,10);
        game.start(new BotUserNumberGuesser());
    }
    private final Random rand = new Random();
    private final int min;
    private final int max;
    int myNumber;

    public GuessMyNumberGame2(int min,int max){
        this.min=min;
        this.max=max;
    }

    public  void start(NumberGuesser guesser){
        myNumber = rand.nextInt(min, max + 1);
        guesser.setRange(min,max);
        int guess ;
        do{
            guess = guesser.guessNumber();
            guesser.setResult( myNumber < guess ? GuessResult.SMALLER : (myNumber > guess) ? GuessResult.BIGGER : GuessResult.EQUAL);
        }while(guess !=  myNumber);
        System.out.println("Well Done");
    }
}
