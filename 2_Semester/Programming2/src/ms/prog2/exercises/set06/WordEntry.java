package ms.prog2.exercises.set06;

public class WordEntry {
    private String word;
    private int count;

    public WordEntry(String word, int count) {
        this.word  = word;
        this.count = count;
    }

    public String getWord()  {
        return word;
    }
    public int    getCount() {
        return count;
    }
}
