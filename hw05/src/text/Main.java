package text;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        String path = "hw05/src/text.txt";
        String text = readFile(path);

        int sentencesNumber = TextUtils.getSentencesNumber(text);
        System.out.println("Количество предложений: " + sentencesNumber);

        String longestWord = TextUtils.getLongestWord(text);
        System.out.println("Самое длинное слово: " + longestWord);

        List<String> longWords = TextUtils.getLongWords(text);
        System.out.println("Слова длиной больше 6 символов: " + longWords);

        String mostCommonWord = TextUtils.getMostCommonWord(text);
        System.out.println("Самое распространенное слово длиной больше 2 символов: " + mostCommonWord);

        int lettersNumber = TextUtils.getLettersNumber(text);
        System.out.println("Количество букв алфавита, использованных в тексте: " + lettersNumber);
    }

    private static String readFile(String path) {
        try {
            return Files.readString(Paths.get(path));
        } catch (NoSuchFileException e) {
            throw new RuntimeException("Нет файла " + path);
        } catch (IOException e) {
            throw new RuntimeException("Ошибка чтения файла " + path);
        }
    }
}
