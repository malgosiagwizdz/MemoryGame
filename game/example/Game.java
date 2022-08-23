package example;

import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {
    public void play() {
        ArrayList<String> wordList = this.readWords("Words.txt");
        ArrayList<String> riddleWords = this.chooseWords(wordList);
        drawGameBoard(riddleWords);

    }

    public void drawGameBoard(ArrayList<String> riddleWords) {
        System.out.println("  1 2 3 4");
        String[] lineA = riddleWords.toArray(new String[0]);
        String[] lineB = lineA;
        String[] wordBoard = { " X", " X", " X", " X", " X", " X", " X", " X" };
        System.out.println("A" + wordBoard[0] + wordBoard[1] + wordBoard[2] + wordBoard[3]);
        System.out.println("B" + wordBoard[4] + wordBoard[5] + wordBoard[6] + wordBoard[7]);
    }

    public ArrayList<String> readWords(String fileName) {
        ArrayList<String> wordList = new ArrayList<String>();
        try {
            File plik = new File(fileName);

            Scanner input = new Scanner(plik);

            while (input.hasNextLine()) {
                wordList.add(input.nextLine());
            }
            input.close();
        } catch (Exception e) {
        }
        return wordList;
    }

    public ArrayList<String> chooseWords(ArrayList<String> words) {
        ArrayList<String> w = new ArrayList<String>();
        Random rand = new Random();
        int i = rand.nextInt(words.size());
        for (int k = 0; k < 4; k++)
            w.add(words.get(i));
        return w;
    }
}
