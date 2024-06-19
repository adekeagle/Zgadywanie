package pl.adcom;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String[] words  = {"samochód", "Ala ma kota", "książka"};

        Random randomIndex = new Random();
        int index = randomIndex.nextInt(words.length);
        String word = words[index];
        String hiddenWord = hiddenWord(word);
        char letter;
        int mistakes = 3;

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Aktualne słowo: " + hiddenWord);
            System.out.println("Podaj literę: ");
            letter = sc.next().charAt(0);

            hiddenWord = showLetter(hiddenWord, word, letter);

            System.out.println(hiddenWord);

            if (!hiddenWord.contains("_")) {
                System.out.println("Gratulacje! Odgadłeś słowo: " + word);
                break;
            }
        }
        sc.close();
    }

    private static String hiddenWord(String word) {
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == ' ') {
                sb.append(' ');
            } else {
                sb.append('_');
            }
        }

        return sb.toString();
    }

    private static String showLetter(String hiddenWord, String word, char letter) {
        StringBuffer sb = new StringBuffer(hiddenWord);

        for (int i = 0; i < word.length(); i++) {

            if (word.charAt(i) == letter) {
                sb.setCharAt(i, letter);
            }
        }

        return sb.toString();
    }

    private static boolean checkIfExists(String word, char letter) {

        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == letter) {
                return true;
            }
        }
        return false;
    }
}