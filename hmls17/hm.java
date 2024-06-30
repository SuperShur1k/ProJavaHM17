package org.example.lesson17.hmls17;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class hm {
    public static void main(String[] args) {
        uniqueWords("testhm17.txt");
    }
//    Распечатайте уникальные слова из файла в обратном порядке - имя файла передается в метод в виде параметра
//public static void uniqueWords(String filename)
    public static void uniqueWords(String filename) {
        Map<String, Integer> wordCountMap = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    word = word.toLowerCase();
                    wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Set<String> uniqueWords = new HashSet<>();
        for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
            if (entry.getValue() == 1) {
                uniqueWords.add(entry.getKey());
            }
        }

        List<String> sortedUniqueWords = new ArrayList<>(uniqueWords);
        sortedUniqueWords.sort(Comparator.reverseOrder());

        System.out.println("Уникальные слова из файла в обратном порядке:");
        sortedUniqueWords.forEach(System.out::println);
    }
}