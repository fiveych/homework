package text;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TextUtils {

    private static final String EMPTY = "";

    private TextUtils() {
    }

    public static int getSentencesNumber(String text) {
        final String sentencesDelimiter = "[.!?]\\s+";
        return (int) Arrays.stream(text.split(sentencesDelimiter)).count();
    }

    public static String getLongestWord(String text) {
        return getWordsStream(text)
                .max(Comparator.comparingInt(String::length))
                .orElse(EMPTY);
    }

    public static List<String> getLongWords(String text) {
        final int length = 6;
        return getWordsStream(text)
                .filter(word -> word.length() > length)
                .collect(Collectors.toList());
    }

    public static String getMostCommonWord(String text) {
        final int length = 2;
        return getWordsStream(text)
                .filter(word -> word.length() > length)
                .collect(Collectors.groupingBy(String::toLowerCase, Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(EMPTY);
    }

    private static Stream<String> getWordsStream(String text) {
        final String wordsDelimiter = "[\\s+.,]";
        return Arrays.stream(text.split(wordsDelimiter));
    }

    public static int getLettersNumber(String text) {
        return (int) text.chars()
                .filter(Character::isAlphabetic)
                .map(Character::toLowerCase)
                .distinct()
                .count();
    }
}
