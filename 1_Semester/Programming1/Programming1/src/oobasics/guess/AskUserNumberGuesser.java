package oobasics.guess;

import java.util.Scanner;

public class AskUserNumberGuesser  implements NumberGuesser {
    private final Scanner scanner = new Scanner(System.in);
    @Override
    public void setRange(int min, int max) {
        System.out.println("Guess my number between "+min+" and "+max);
    }

    @Override
    public int guessNumber() {
        return scanner.nextInt();
    }

    @Override
    public void setResult(GuessResult result) {
        System.out.println("My Number is "+result.name().toLowerCase());
    }
}
