package com.company;

import java.util.List;

public class Main {

    public static void main(String[] args) {
	    WordContainer wordContainer = new WordContainer();
	    List<Word> words = wordContainer.scanner();
	    words.sort(Word::compareTo);
        System.out.println(words);
    }
}
