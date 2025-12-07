package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PracticeOne {
    public static void main(String[] args) {

        List<String> words = Arrays.asList("kalesh", "swathi", "teja", "padmasri", "pavan");
        List<String> capitalWords = words.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println(capitalWords);

        long count = words.stream()
                .filter(word->word.startsWith("p"))
                .count();
        System.out.println("Number of words starts with P : " +count);
    }
}
