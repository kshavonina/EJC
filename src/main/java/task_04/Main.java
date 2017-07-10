package task_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        task04_1();

        task04_2();
    }

    static String task04_1() {
        String word = null;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            word = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            if (i % 2 == 1) {
                res.append(word.charAt(i));
            }
        }

        return res.toString();
    }

    static boolean task04_2() {
        String phrase = null;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            phrase = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        phrase = phrase.replace(" ", "");
        String reversedPhrase = new StringBuilder(phrase).reverse().toString();
        //StringBuilder sbPhrase = new StringBuilder(phrase);

        if (phrase.equals(reversedPhrase)) {
            return true;
        }

        return false;
    }
}
