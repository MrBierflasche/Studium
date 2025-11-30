package moritz.prog1.exercises.set09;

public class MySortingAlgorithm {

    static void main() {

        MySortingTool sTool = new MySortingTool();
        sTool.setInitData(10, false);

        sTool.performExperiment(Algorithmus.BUBBLESORT);
        sTool.performExperiment(Algorithmus.INSERTIONSORT);
        sTool.performExperiment(Algorithmus.SELECTIONSORT);

//        int[] arr = { 15, 0 , 7, 10 };
//        sort(arr);
//        System.out.println(Arrays.toString(arr));
    }


    // Bubble Sort
    public static void sort(int[] arr){
        for(int i= arr.length -1;i > 0 ;i--){
            for(int j = 0;j < i;j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }

        }
    }
}
