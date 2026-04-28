package ms.prog2.exercises.set08;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DuplicateFileFinder {
    private static class DuplicateProcessor implements FlexibleFileTreeWalker.FileProcessor {

        // Key: Dateiname:Größe und Value: Liste der Pfade
        private final Map<String, List<String>> files = new HashMap<>();
        @Override
        public void process(File file) throws IOException {
            String key = file.getName() + ":" + file.length();

            // Falls Schlüssel noch nicht existiert, neue leere Liste anlegen
            files.putIfAbsent(key, new ArrayList<>());

            // Pfad zur Liste hinzufügen
            files.get(key).add(file.getCanonicalPath() );
        }


        // Gibt nur Einträge aus, die mehr als einen Pfad haben ==> Duplikate
        public void printDuplicates() {
            boolean found = false;

            for (Map.Entry<String, List<String>> entry : files.entrySet()) {
                List<String> paths = entry.getValue();

                if (paths.size() > 1) {  // mehr als ein Pfad == Duplikat
                    found = true;
                    System.out.println("Duplikat gefunden: " + entry.getKey());
                    for (String path : paths) {
                        System.out.println("  -> " + path);
                    }
                    System.out.println();
                }
            }

            if (!found) {
                System.out.println("Keine Duplikate gefunden.");
            }
        }
    }

    static void main() throws IOException {
        DuplicateProcessor processor = new DuplicateProcessor();

        new FlexibleFileTreeWalker(processor).walk(".");

        processor.printDuplicates();
    }
}
