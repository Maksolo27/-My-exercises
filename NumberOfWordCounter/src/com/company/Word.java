package com.company;

import java.util.Objects;

public class Word implements Comparable<Word> {
    private String content;
    private int frequency;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
        setFrequency(this.content.length());
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public int countFrequency(){
        return this.content.length();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Word word = (Word) o;
        return frequency == word.frequency && Objects.equals(content, word.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(content, frequency);
    }

    @Override
    public String toString() {
        return "Word{" +
                "content='" + content + '\'' +
                ", frequency=" + frequency +
                '}';
    }

    @Override
    public int compareTo(Word o) {
        return o.getFrequency() - this.getFrequency();
    }
}
