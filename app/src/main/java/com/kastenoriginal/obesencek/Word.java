package com.kastenoriginal.obesencek;

public class Word {

    private int wordId;
    private String wordTitle;
    private String wordLength;

    public Word(String wordTitle, String wordLength){
        this.wordTitle = wordTitle;
        this.wordLength = wordLength;
    }

    public String getWordTitle() {
        return wordTitle;
    }

    public void setWordTitle(String wordTitle) {
        this.wordTitle = wordTitle;
    }

    public String getWordLength() {
        return wordLength;
    }

    public void setWordLength(String wordLength) {
        this.wordLength = wordLength;
    }

    public int getWordId() {
        return wordId;
    }

    public void setWordId(int wordId) {
        this.wordId = wordId;
    }
}
