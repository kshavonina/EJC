package task_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class ZlatopolskyTasks {
    //153, 154
    // task 9.153
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

    // task 9.154
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
            charactersSet.add(text.charAt(i));
        }

        return charactersSet.size();
    }

}
