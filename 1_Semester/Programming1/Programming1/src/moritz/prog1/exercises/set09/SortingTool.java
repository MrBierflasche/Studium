package moritz.prog1.exercises.set09;

import java.util.Arrays;
import java.util.Random;

public class SortingTool {
    private int[] intArray;
    private int[] workingArray;
    private int comparison;
    private double swaps;
    private int[] lastSwapped ;

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
        workingArray = intArray.clone();
        comparison = 0;
        swaps = 0;

        // unsortiert ausgeben
        for (int k : workingArray) {
            System.out.print(k + " ");
        }
        System.out.println();

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
    }
}
