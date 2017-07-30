package task_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Tasks from Zlatopolsky textbook.
 *
 * @author Kseniya Shavonina
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.changeWord());
        System.out.println(main.isPalindrome());
    }

    /**
     * Makes a new string from odd characters of the string
     * read from console.
     *
     * @return changed string.
     */
    private String changeWord() {
        String word = "";

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            word = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            if (i % 2 == 1) {
                result.append(word.charAt(i));
            }
        }

        return result.toString();
    }

    /**
     * Checks if the string from the console is palindrome.
     *
     * @return true if yes, false - otherwise.
     */
    private boolean isPalindrome() {
        String phrase = "";

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            phrase = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        phrase = phrase.replace(" ", "");
        String reversedPhrase = new StringBuilder(phrase).reverse().toString();

        return phrase.equals(reversedPhrase);
    }
}
