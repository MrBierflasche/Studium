package ms.prog2.exercises.set04;

public class Train {
    private final Locomotive locomotive;
    public Train(Locomotive locomotive) {
        this.locomotive = locomotive;
    }

    // Prüft, ob der Zug über mehr als nur eine Lokomotive verfügt
    public boolean hasCars(){
        return locomotive.getFirst() != null;
    }

    // hängt in den Zug einen gegebenen Wagen an der spezifizierten Index-Position
    public void add(Car car, int index){
        if (car == null || index < 0) {
            return;
        }

        if(index == 0){
            car.setNext(locomotive.getFirst());
            locomotive.setFirst(car);
            return;
        }

        Car current = locomotive.getFirst();
        int i = 0;
        // geht durch die Liste bis zur gewünschten Position
        while(current != null && i < index - 1){
            current = current.getNext();
            i++;
        }

        if( current != null ){
            car.setNext(current.getNext()); // neuer Wagen zeigt auf den nächsten Wagen
            current.setNext(car); // vorheriger Wagen zeigt auf den neuen Wagen
        }
    }

    // liefert die gesamte Passagierkapazität des Zuges.
    public int getPassengers(){
        int sum = 0;
        Car current = locomotive.getFirst();

        while(current != null){
            sum  += current.getCapacity();
            current = current.getNext();
        }

        return sum;
    }

    // liefert die Länge des Zuges in Metern.
    private int getLength(){
        int sum =  locomotive.getLength();
        Car  current = locomotive.getFirst();

        while(current != null){
            sum += current.getLength();
            current = current.getNext();
        }

        return sum;
    }

    // hängt den ersten Wagen aus dem Zug aus und liefert den ausgehängten Wagen als Ergebnis zurück
    public Car removeFirst(){
        Car first = locomotive.getFirst();
        if(first == null){
            return null;
        }

        locomotive.setFirst(first.getNext()); //Lok zeigt auf den zweiten Wagen
        first.setNext(null); // entfernten Wagen kein Nachfolger mehr

        return first;
    }

    // Hängt alle Wagen eines anderen Zuges an diesen Zug an
    public void relink(Train other) {
        if (other == null || !other.hasCars()){
            return;
        }

        Car otherFirst = other.locomotive.getFirst();
        other.locomotive.setFirst(null); // anderer Zug verliert alle Wagen

        // wenn dieser Zug noch keine Wagen hat, dann als otherFirst einfügen
        if (!this.hasCars()) {
            locomotive.setFirst(otherFirst);
            return;
        }

        Car current = locomotive.getFirst();

        // zum letzten Wagen gehen
        while (current.getNext() != null) {
            current = current.getNext();
        }
        current.setNext(otherFirst); // letzten Wagen mit anderen Zug erster Wagen verbinden
    }

    // dreht die Abfolge der Wagen in diesem Zug um
    public void revert(){
        Car previous = null; // zeigt auf den Wagen, der nach dem Umdrehen vor dem aktuellen steht
        Car current = locomotive.getFirst(); // aktueller Wagen
        Car next; // der Wagen vor dem aktuellen

        while (current != null) {
            next = current.getNext(); // nächsten Wagen merken
            current.setNext(previous); // Richtung umdrehen
            previous = current;
            current = next;
        }

        locomotive.setFirst(previous); // neuer erster Wagen ist der vorher letzte
    }

    // liefert eine Beschreibung, aus der alle wichtigen Zug-Daten hervorgehen
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        // Lokomotiv-Daten
        sb.append("Lokomotive: Länge=")
                .append(locomotive.getLength())
                .append(", Typ=")
                .append(locomotive.getType())
                .append("\n");

        Car current = locomotive.getFirst();
        int i = 0;

        while (current != null) {
            sb.append("Wagen ")
                    .append(i)
                    .append(": Länge=").append(current.getLength())
                    .append(", Kapazität=").append(current.getCapacity())
                    .append("\n");

            current = current.getNext();
            i++;
        }

        // Gesamtinfos
        sb.append("Gesamtlänge: ").append(getLength()).append("\n");
        sb.append("Gesamtkapazität: ").append(getPassengers());

        return sb.toString();
    }

}
