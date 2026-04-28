package ms.prog2.exercises.set08;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LargeFileFinder {
    private static class SortingFileProcessor implements FlexibleFileTreeWalker.FileProcessor {

        private final List<File> files = new ArrayList<>();

        @Override
        public void process(File file) {
            files.add(file);
        }

        // Sortiert und gibt dann aus
        public void printSorted() throws IOException {
            files.sort(new Comparator<File>() {
                @Override
                public int compare(File a, File b) {
                    return -Long.compare(a.length(), b.length());  // absteigend = größte Datei zuerst
                }
            });

            for (File file : files) {
                System.out.printf("%-100s%6d%n",
                        file.getCanonicalPath(),
                        file.length());
            }
        }
    }

    public static void main(String[] args) throws IOException {
        SortingFileProcessor processor = new SortingFileProcessor();

        new FlexibleFileTreeWalker(processor).walk(".");

        processor.printSorted();
    }
}
