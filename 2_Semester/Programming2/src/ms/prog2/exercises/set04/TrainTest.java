package ms.prog2.exercises.set04;

public class TrainTest {
    static void main(String[] args) {
        // 1. Eine Lokomotive „Big Chief“ mit der Nummer 5311 und der Länge 23 m wird erzeugt
        Locomotive bigChief = new Locomotive(23, 5311);

        // 2. Ein Zug namens „Santa Fe“ mit der Lokomotive „Big Chief“ wird erzeugt.
        Train santaFe = new Train(bigChief);

        // 3. An „Santa Fe“ werden drei Wagen mit den Längen 12 m, 15 m, 20 m und den Passagierkapazitäten 50, 75, 100 Personen angehängt.
        santaFe.add(new Car(12, 50), 0);
        santaFe.add(new Car(15, 75), 1);
        santaFe.add(new Car(20, 100), 2);

        // 4. Eine Lokomotive „Steel Horse“ mit der Nummer 5409 und der Länge 21 m wird erzeugt.
        Locomotive steelHorse = new Locomotive(21, 5409);

        // 5. Ein Zug namens „Rio Grande Express“ mit der Lokomotive „Steel Horse“ wird erzeugt.
        Train rioGrande = new Train(steelHorse);

        // 6. An den „Rio Grande Express“ werden zwei Wagen mit den Längen 13 m und 18 m sowie den Passagierkapazitäten 60 und 80 Personen angehängt.
        rioGrande.add(new Car(13, 60), 0);
        rioGrande.add(new Car(18, 80), 1);

        // 7. Alle Wagen von „Santa Fe“ werden in den „Rio Grande Express“ übernommen.
        rioGrande.relink(santaFe);

        // 8. Die Wagenreihenfolge im „Rio Grande Express“ wird umgedreht.
        rioGrande.revert();

        System.out.println("Santa Fe:");
        System.out.println(santaFe);
        System.out.println("\nRio Grande Express:");
        System.out.println(rioGrande);
    }
}
