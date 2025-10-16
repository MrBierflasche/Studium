public class ExcerciseSet03 {
    public static void main(String[] args) {
        //printName(Terminal.readString("Bitte geben Sie ihren Namen ein"));
        //planProject();
//       System.out.println("Anzahl Tage des Monats: " + getDaysOfMonth(1, 2000));
//       System.out.println("Anzahl Tage des Monats: " + getDaysOfMonth(4, 2000));
//       System.out.println("Anzahl Tage des Monats: " + getDaysOfMonth(2, 2000));
//       System.out.println("Anzahl Tage des Monats: " + getDaysOfMonth(2, 2100));
//       System.out.println("Anzahl Tage des Monats: " + getDaysOfMonth(2, 2103));
         getDayOfTheWeek(9, 11, 1989);
         getDayOfTheWeek(11, 9, 2001);
    }

    public static int getDayOfTheWeek(int day, int month, int year){
        // März bis Dezember wie üblich die Nummern 3–12 haben, Januar und Februar den Monaten 13 und 14 des Vorjahres entsprechen
        if (month == 1) {
            month = 13;
            year--;
        }else if (month == 2) {
            month = 14;
            year--;
        }

        int q = day;
        int m = month;

        // J die Jahrhundertzahl (das sind die ersten beiden Stellen der vierstelligen Jahreszahl)
        int J = year / 100;

        // K die letzten beiden Stellen der vierstelligen Jahreszahl (für Januar und Februar entsprechend die Zahl des Vorjahres)
        int K = year % 100;

        // Gaußklammer kann so verwendet werden da keine negativen Zahlen herauskommen und bei der int Division automatisch abgerundet wird
        int hgreg = (q + ((m + 1) * 13) / 5 + K + (K/ 4) + (J / 4) - 2 * J  ) % 7;

        // Wochentage ändern entsprechend dem Arbeitsblatt
        int weekday =   ((hgreg + 5) % 7) + 1;

        return weekday;
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
