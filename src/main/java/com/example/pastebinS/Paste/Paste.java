package com.example.pastebinS.Paste;

import javax.persistence.*;

@Entity
@Table(name = "pastes")
public class Paste {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String text;
    private String title;

    public Paste () {}
    public Paste(Integer id, String text, String title) {
        this.id = id;
        this.text = text;
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
