public class Training25BeaverDemo {
    public static void main(String[] args) {
        int population = 6;
        int rateOfGrowth = 30;
        int year = 0;

        while(year < 20){
            System.out.println("In year" + year + " the excepted number is: " + population);
            population = population + ( population * rateOfGrowth  / 100);
            year++;
        }
    }
}
