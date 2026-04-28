package ms.prog2.exercises.set08;

import java.io.File;
import java.io.IOException;

public class FlexibleFileTreeWalker {

    public interface FileProcessor {
        void process(File file) throws IOException;
    }

    private final FileProcessor processor;
    public FlexibleFileTreeWalker(FileProcessor processor) {
        this.processor = processor;
    }

    public static void main(String[] args) throws IOException {
        new FlexibleFileTreeWalker(new FlexibleFileTreeWalker.FileProcessor() {
            @Override
            public void process(File file) throws IOException {
                System.out.printf("%-100s%6d%n",
                        file.getCanonicalPath(),
                        file.length());
            }
        }).walk(".");
    }

    public void walk(String pathname) throws IOException {
        File[] files = new File(pathname).listFiles();
        if (files != null) {
            for (File file : files)
                if (file.isDirectory())
                    walk(file.getCanonicalPath());
                else
                    processor.process(file);
        }
    }
}