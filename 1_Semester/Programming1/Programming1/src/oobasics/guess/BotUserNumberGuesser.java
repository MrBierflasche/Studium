package oobasics.guess;

public class BotUserNumberGuesser implements NumberGuesser {
    int min;
    int max;
    int number;
    @Override
    public void setRange(int min, int max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public int guessNumber() {
        number =  (min + max) / 2;
        return (min + max) / 2;
    }

    @Override
    public void setResult(GuessResult result) {
        if(result == GuessResult.SMALLER) {
            max = number -1;
        }
        else if (result == GuessResult.BIGGER){
            min = number +1;
        }
    }
}
