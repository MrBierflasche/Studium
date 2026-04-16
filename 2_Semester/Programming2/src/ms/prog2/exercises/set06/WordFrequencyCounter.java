package ms.prog2.exercises.set06;

import java.io.*;
import java.util.*;

public class WordFrequencyCounter {
    private int lineCount = 0;
    private int wordCount = 0;
    // Map: Wort -> Häufigkeit
    private Map<String, Integer> frequencyMap = new HashMap<>();

    public void analyzeText(File textFile) {
        try {
            BufferedReader in =
                    new BufferedReader(new FileReader(textFile));
// Iterate through each line of the file
            while (true) {
                String currLine = in.readLine();
                if (currLine == null)
                    break;
                analyzeLine(currLine);
            }
        } catch (IOException ex) {
            System.out.println(
                    "Error occurred while reading from "
                            + textFile.getAbsolutePath() + ":");
            System.out.println(ex);
        }
    }
    private void analyzeLine(String line) {
        if (line.trim().isEmpty()) {
            return;  // leere Zeilen überspringen
        }

        lineCount++;

        // Zeile in Wörter zerlegen
        StringTokenizer tokenizer = new StringTokenizer(line);
        while (tokenizer.hasMoreTokens()) {
            String word = tokenizer.nextToken().toLowerCase();
            wordCount++;

            // Häufigkeit aktualisieren
            if (frequencyMap.containsKey(word)) {
                frequencyMap.put(word, frequencyMap.get(word) + 1);
            } else {
                frequencyMap.put(word, 1);
            }
        }
    }
    public void printResults() {
        System.out.println("Line Count: " + lineCount);
        System.out.println("Word Count: " + wordCount);
        System.out.println("Frequency of occurrence of each word:");

        // Einträge in eine Liste füllen
        List<WordEntry> entries = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : frequencyMap.entrySet()) {
            entries.add(new WordEntry(entry.getKey(), entry.getValue()));
        }

        // Sortieren: zuerst nach Häufigkeit (absteigend), dann alphabetisch
        Collections.sort(entries, new WordEntryComparator());

        int col = 0;
        for (WordEntry entry : entries) {
            System.out.printf("%10s : %3d   ", entry.getWord(), entry.getCount());
            col++;
            if (col == 3) {          // nach 3 Einträgen -> neue Zeile
                System.out.println();
                col = 0;
            }
        }
        System.out.println();
    }


    public static void main(String[] args) {
        WordFrequencyCounter counter = new WordFrequencyCounter();
        counter.analyzeText(new File("data/Song.txt"));
        counter.printResults();
    }
}
