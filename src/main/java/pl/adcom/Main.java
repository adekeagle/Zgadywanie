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
        int mistakes = 0;
        int maxMistakes = 3;

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Aktualne słowo: " + hiddenWord);
            System.out.println("Podaj literę: ");
            letter = sc.next().charAt(0);

            String newHiddenWord = showLetter(hiddenWord, word, letter);

            if (newHiddenWord.equals(hiddenWord)) {
                mistakes++;
                System.out.println("Brak takiej literki. Pozostało Ci " + (maxMistakes - mistakes) + " szans");
            } else {
                hiddenWord = newHiddenWord;
            }

            if (mistakes >= maxMistakes) {
                System.out.println("Przekroczyłeś limit błędów. Koniec gry! ");
                break;
            }

            if (!hiddenWord.contains("_")) {
                System.out.println("Gratulacje! Odgadłeś słowo: " + word);
                break;
            }
        }
        System.out.println("Koniec gry!");
        sc.close();
    }

    private static String hiddenWord(String word) {
        StringBuilder sb = new StringBuilder();

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
        StringBuilder sb = new StringBuilder(hiddenWord);

        for (int i = 0; i < word.length(); i++) {

            if (word.charAt(i) == letter) {
                sb.setCharAt(i, letter);
            }
        }

        return sb.toString();
    }
}