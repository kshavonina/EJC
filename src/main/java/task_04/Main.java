package task_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.changeWord());
        System.out.println(main.isPalindrome());
    }

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
