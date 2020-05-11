package com.example.niesyto.morseapp;

public class Translation {
    // fields
    private int translationID;
    private String translationBefore;
    private String translationAfter;
    private String translationMode;
    // constructors
    public Translation() {}
    public Translation(String before, String after, String mode) {

        this.translationBefore = before;
        this.translationAfter=after;
        this.translationMode=mode;
    }
    // properties
    public void setTranslationID(int id) {
        this.translationID = id;
    }
    public int getTranslationID() {
        return this.translationID;
    }
    public void setTranslationBefore(String before) {
        this.translationBefore = before;
    }
    public String getTranslationBefore() {
        return this.translationBefore;
    }
    public void setTranslationAfter(String after) {
        this.translationAfter = after;
    }
    public String getTranslationAfter() {
        return this.translationAfter;
    }
    public void setTranslationMode(String mode) {
        this.translationMode = mode;
    }
    public String getTranslationMode() {
        return this.translationMode;
    }
}

