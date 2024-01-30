package com.project.multiligual.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "languages")
public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String languageName;
    private String languageShortName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLanguageName() {
        return languageName;
    }

    public void setLanguageName(String languageName) {
        this.languageName = languageName;
    }

    public String getLanguageShortName() {
        return languageShortName;
    }

    public void setLanguageShortName(String languageShortName) {
        this.languageShortName = languageShortName;
    }
}
