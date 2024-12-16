package vn.techzen.academy_pnv_24.entity;

public class Dictionary {
    private int id;
    private String english_word;
    private String translation;


    public Dictionary() {}
    public Dictionary(int id, String english_word,String translation) {
        this.id = id;
        this.translation = translation;
        this.english_word = english_word;
    }

    public String getEnglish_word() {
        return english_word;
    }

    public void setEnglish_word(String english_word) {
        this.english_word = english_word;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
