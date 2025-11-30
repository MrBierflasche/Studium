package moritz.prog1.exercises.set09;

import rl.util.painttool.AbstractController;
import rl.util.painttool.PaintTool;

import java.awt.*;
import java.util.Arrays;
import java.util.Random;

public class MySortingTool extends AbstractController {
    private int[] intArray;
    private int[] workingArray;
    private int comparison;
    private double swaps;
    private int[] lastSwapped ;
    private PaintTool ptool;


    @Override
    public String getTitle() {
        return "Sorting Tool";
    }

    @Override
    public String[] getButtonNames() {
        return new String[] {
                "Init 10", "Init 100", "Init 200", "Init 400",
                "BubbleSort", "InsertionSort", "SelectionSort"
        };
    }

    @Override
    public void onButtonPressed(PaintTool ptool, int button) {
        if (this.ptool == null) {
            this.ptool = ptool;
        }
        switch(button) {
            case 0: this.setInitData(10, false); break;
            case 1: this.setInitData(100, false); break;
            case 2: this.setInitData(200, false); break;
            case 3: this.setInitData(400, false); break;
            case 4: this.performExperiment(Algorithmus.BUBBLESORT); break;
            case 5: this.performExperiment(Algorithmus.INSERTIONSORT); break;
            case 6: this.performExperiment(Algorithmus.SELECTIONSORT); break;
        }
    }

    public void setInitData(int length, boolean sorted  ){
        Random rand = new Random();
        intArray = new int[length];
        for(int i = 0; i < length; i++){
            intArray[i] = rand.nextInt(250);
        }

        if(sorted){
            Arrays.sort(intArray);
        }
    }

    public void performExperiment(Algorithmus algo){
        if (intArray == null|| intArray.length == 0){
            return;
        }
        workingArray = intArray.clone();
        comparison = 0;
        swaps = 0;

        // unsortiert ausgeben
       display();

        switch(algo){
            case BUBBLESORT:
                for(int i= workingArray.length -1;i > 0 ;i--){
                    for(int j = 0;j < i;j++){
                        if(isGreater(workingArray[j], workingArray[j+1])){
                            swap( j , j + 1, Algorithmus.BUBBLESORT );
                            display();
                        }
                    }
                }
                break;
            case INSERTIONSORT:
                for (int i = 1; i < workingArray.length; i++) {
                    int temp = workingArray[i];
                    int pos = i;

                    while (pos > 0 && isGreater(workingArray[pos - 1], temp)) {
                        swap(pos, pos - 1, Algorithmus.INSERTIONSORT);
                        pos--;
                        display();
                    }

                    if (pos != i) {  // nur anzeigen, wenn temp wirklich verschoben wurde => also Swap
                        workingArray[pos] = temp;
                        display();
                    } else {
                        workingArray[pos] = temp; // nur Zuweisung nicht anzeigen
                    }
                }
                break;
             case SELECTIONSORT:
                 for (int i = 0; i < workingArray.length - 1; i++) {
                     int minPos = i;
                     for (int j = i + 1; j < workingArray.length; j++) {
                         if (isGreater(workingArray[minPos], workingArray[j]))
                             minPos = j;
                     }
                     if (minPos != i) {
                         swap(i, minPos, Algorithmus.SELECTIONSORT);
                         display();
                     }
                 }
                 break;
        }

        printStatistics(algo);
    }

    private void printStatistics(Algorithmus algo){

        if (ptool != null) {
            ptool.setColor(Color.BLACK);
            int heigth = ptool.getCanvas().getHeight();
            ptool.addText(10, heigth -20 , algo.toString());
            ptool.addText(10, heigth -10, "comparisons: " + comparison + " swaps: " + swaps);
            return;
        }
        System.out.println(algo + ":");
        System.out.println("comparisons: " + comparison + " swaps: " + swaps);
        System.out.println();
    }

    private void swap (int i, int j, Algorithmus algo){
        int temp = workingArray[i];
        workingArray[i] = workingArray[j];
        workingArray[j] = temp;

        if (algo == Algorithmus.INSERTIONSORT) {
            swaps += 0.5; // Verschiebeoperation
        } else {
            swaps += 1;   // normaler Swap
        }
        lastSwapped = new int[]{i, j};
    }

    private boolean isGreater(int a, int b){
        comparison++;
        return a > b;
    }
    private void display(){
        if (lastSwapped == null) {
            lastSwapped = new int[0];
        }

        if (ptool == null) {
            for (int i = 0; i < workingArray.length; i++) {
                boolean swapped = false;
                // Überprüfen, welches Element beim letzten Swap getauscht wurde
                for (int idx : lastSwapped) {
                    if (i == idx) {
                        swapped = true;
                        break;
                    }
                }
                System.out.print(workingArray[i]);
                if (swapped) {
                    System.out.print("!");
                }
                System.out.print(" ");
            }
            System.out.println();
            lastSwapped = new int[0];
            return;
        }

        ptool.clearCanvas();

        int width = ptool.getCanvas().getWidth();
        int height = ptool.getCanvas().getHeight() - 40; // Platz für Statistik unten

        int n = workingArray.length;
        int barWidth = Math.max(1, width / n);
        int maxVal = 1;

        // Maximalwert bestimmen
        for (int el : workingArray){
            if (el > maxVal) {
                maxVal = el;
            }
        }

        for (int i = 0; i < n; i++) {

            int value = workingArray[i];

            // Höhe proportional skalieren
            int barHeight = (int) ((value / (double) maxVal) * height);

            int x = i * barWidth;
            int y = height - barHeight;

            boolean swapped = false;
            for (int idx : lastSwapped) {
                if (i == idx) {
                    swapped = true;
                    break;
                }
            }

            // Farbe je nachdem, ob Element zuletzt getauscht wurde
            if (swapped) {
                ptool.setColor(Color.RED);
            } else {
                ptool.setColor(Color.BLUE);
            }

            ptool.addRectangle(x, y, barWidth - 1, barHeight, true);
        }

        ptool.sleep(100);
        lastSwapped = new int[0];
    }
}
