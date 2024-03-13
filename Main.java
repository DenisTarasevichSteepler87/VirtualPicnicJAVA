import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            File file = new File("input.txt");
            Scanner scanner = new Scanner(file);

            int wordCount = 0;
            String longestWord = "";
            HashMap<String, Integer> wordFrequency = new HashMap<>();

            while (scanner.hasNext()) {
                String word = scanner.next();
                wordCount++;
                
                if (word.length() > longestWord.length()) {
                    longestWord = word;
                }
                
                wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
            }

            System.out.println("Количество слов в файле: " + wordCount);
            System.out.println("Самое длинное слово: " + longestWord);

            System.out.println("Частота слов:");
            for (String word : wordFrequency.keySet()) {
                System.out.println(word + ": " + wordFrequency.get(word));
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Ошибка при чтении файла");
        }
    }
}