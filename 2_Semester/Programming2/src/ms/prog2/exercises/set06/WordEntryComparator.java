package ms.prog2.exercises.set06;

import java.util.Comparator;

public class WordEntryComparator implements Comparator<WordEntry> {
    @Override
    public int compare(WordEntry a, WordEntry b) {
        // absteigend
        if (a.getCount() > b.getCount()) {
            return -1;  //a vor b
        }
        if (a.getCount() < b.getCount()) {
            return  1;  // b vor a
        }

        // aufsteigend
        return a.getWord().compareTo(b.getWord());   // gleich -> alphabetisch
    }
}
