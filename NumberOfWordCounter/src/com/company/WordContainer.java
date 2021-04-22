package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WordContainer {
    private List<Word> words;

    public List<Word> scanner(){
        words = new ArrayList<>();
        int i = 0;
        while (true){
            Scanner sc = new Scanner(System.in);
            String scannedWord = sc.nextLine();
            if(scannedWord.equals("stop")){
                break;
            }
            String[] scannedWords = scannedWord.split(" ");
            for (int j = 0; j < scannedWords.length; j++) {
                words.add(new Word());
                words.get(i).setContent(scannedWords[j]);
                i++;
            }
        }
        return words;
    }

}
