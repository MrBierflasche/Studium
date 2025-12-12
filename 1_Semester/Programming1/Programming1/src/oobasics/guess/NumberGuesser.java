package oobasics.guess;

public interface NumberGuesser {
    void setRange(int min,int max);

    int guessNumber();

    void setResult(GuessResult result);
}
