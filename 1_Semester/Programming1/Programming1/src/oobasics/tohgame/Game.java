package oobasics.tohgame;

public class Game {
    private Rod rodA;
    private Rod rodB;
    private Rod rodC;

    public void start(int numOfDisks){
       this.rodA = new Rod(RodID.A, numOfDisks);
       this.rodB = new Rod(RodID.B, numOfDisks);
       this.rodC = new Rod(RodID.C, numOfDisks);

       for(int radius = numOfDisks; radius > 0; radius--){
           this.rodA.push(new Disk(radius));
       }
    }

    public void moveTover (Rod start, Rod destination, Rod depot ,int numOfDisks){
        if(numOfDisks == 0){
            return;
        }

    }

    public void moveDisk(Rod r1, Rod r2){
        Disk d = r1.pop();
        r2.push(d);
        System.out.println(d + " " +r1 +" -> " +r2);
    }

    static void main() {
        Game game = new Game();
        game.start(3);
    }
}
