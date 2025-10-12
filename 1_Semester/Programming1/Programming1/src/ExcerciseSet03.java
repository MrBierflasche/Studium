public class ExcerciseSet03 {
    public static void main(String[] args) {
        //printName(Terminal.readString("Bitte geben Sie ihren Namen ein"));
        //planProject();
//       System.out.println("Anzahl Tage des Monats: " + getDaysOfMonth(1, 2000));
//       System.out.println("Anzahl Tage des Monats: " + getDaysOfMonth(4, 2000));
//       System.out.println("Anzahl Tage des Monats: " + getDaysOfMonth(2, 2000));
//       System.out.println("Anzahl Tage des Monats: " + getDaysOfMonth(2, 2100));
//       System.out.println("Anzahl Tage des Monats: " + getDaysOfMonth(2, 2103));

    }

    public static int getDayOfTheWeek(int day, int month, int year){
        month = month+2;
        int dayOfTheWeek = day + ((month + 1) * 13) / 5  ;
        return 0;
    }

    public static int getDaysOfMonth(int month, int year){
        switch (month){
            case 1, 3, 5, 7,8,10,12 :
                return 31;
            case 4, 6, 9, 11:
                return 30;
            case 2:
                if( ((year % 4 == 0) && year % 100 != 0) || (year % 400 == 0)){
                    return 29;
                }
                return 28;
        }
        return 0;
    }

    public static void planProject(){
        int projectSize = Terminal.readInt("Bitte geben Sie den Projektumfang in Stunden an");
        int hourlyRate = Terminal.readInt("Bitte geben Sie den Stundensatz (in ganzen Euros pro Arbeitsstunde)");
        int employeesCount = Terminal.readInt("Bitte geben Sie den Anzahl der verfügbaren Mitarbeiter an");

        System.out.println("Die Gesamtkosten für das Projekt sind: "+ hourlyRate * hourlyRate);

        int workingDays = projectSize / (employeesCount * 8);
        // Bei Kommazahlen Anzahl der benötigten Arbeitstage auf die nächste natürliche Zahl erweitern
        if (projectSize % (employeesCount * 8) != 0) {
            workingDays++;
        }

        System.out.println("Benötigte Arbeitstage: " + workingDays);
    }

    public static void printName(String name){
        for(int i = 0; i< 3; i++){
            System.out.println(name);
        }
    }
}
