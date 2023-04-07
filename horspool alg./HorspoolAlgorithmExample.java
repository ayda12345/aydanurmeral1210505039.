
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class HorspoolAlgorithmExample {

    public static void main(String[] args) {
        String filepath ="text.txt";
        String content = "Bu dosyaya örnek yazılmaktadır.";
        try {
            FileWriter fileWriter = new FileWriter(filepath);
            fileWriter.write(content);
            fileWriter.close();
            System.out.println("Dosya oluşturuldu.");
        } catch (IOException e) {
            System.out.println("Dosya oluşturma hatası: " + e.getMessage());
        }

        String[] wordsToFind = {"upon", "sigh", "Dormouse", "jury-box","swim"};
        Map<String, Integer> wordCounts = new HashMap<>();

        for (String word : wordsToFind) {
            int count = findWordCount(filepath, word);
            wordCounts.put(word, count);
        }

        for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
            System.out.println("Kelime '" + entry.getKey() + "' " + entry.getValue() + " kez bulundu.");
        }
    }

    public static int findWordCount(String text, String word) {
        int count = 0;
        int textLength = text.length();
        int wordLength = word.length();

        for (int i = 0; i <= textLength - wordLength; i++) {
            if (text.charAt(i) == word.charAt(0)) {
                int j = 0;
                while (j < wordLength && text.charAt(i + j) == word.charAt(j)) {
                    j++;
                }
                if (j == wordLength) {
                    count++;
                }
            }
        }

        return count;
    }
}
