package task_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * Another set of tasks from Zlatopolsky textbook.
 *
 * @author Kseniya Shavonina
 * @version 1.0
 */
public class ZlatopolskyTasks {
    /**
     * Task 9.153 from Zlatopolsky textbook.
     * Counts maximal length of a sequence of the same characters in string read
     * from the console.
     *
     * @return maximal length of a sequence of the same characters.
     */
    int maxCountSameCharacters() {
        System.out.println("Print text: ");
        String text = "";

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            text = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (text.length() == 0) {
            return 0;
        }

        if (text.length() == 1) {
            return 1;
        }

        int countSameCharacters = 1;
        int maxCountSameCharacters = 1;

        for (int i = 1; i < text.length(); i++) {
            if (text.charAt(i) == text.charAt(i - 1)) {
                countSameCharacters++;
            } else {
                if (countSameCharacters > maxCountSameCharacters) {
                    maxCountSameCharacters = countSameCharacters;
                }

                countSameCharacters = 1;
            }
        }

        if (countSameCharacters > maxCountSameCharacters) {
            maxCountSameCharacters = countSameCharacters;
        }

        return maxCountSameCharacters;
    }

    /**
     * Task 9.154 from Zlatopolsky textbook.
     * Counts number of different characters that are not digits in the entered string.
     *
     * @return number of different characters.
     */
    int differentCharactersCount() {
        System.out.println("Print text: ");
        String text = "";

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            text = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (text.length() == 0) {
            return 0;
        }

        if (text.length() == 1) {
            return 1;
        }

        Set<Character> charactersSet = new HashSet<>();

        for (int i = 0; i < text.length(); i++) {
            if (!Character.isDigit(text.charAt(i))) {
                charactersSet.add(text.charAt(i));
            }
        }

        return charactersSet.size();
    }
}
