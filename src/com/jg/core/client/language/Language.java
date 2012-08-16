package com.jg.core.client.language;

import java.io.*;
import java.util.*;

/**
 *
 */
public class Language implements Serializable {
    private static final long serialVersionUID = 9050866042279373824L;

    private static Map<String, Language> nameMap = new HashMap<String, Language>();
    private static Map<Integer, Language> valueMap = new HashMap<Integer, Language>();

    public static Language DANISH = new Language("Dansk", 0);
    public static Language ENGLISH = new Language("English", 1);
    public static Language GERMAN = new Language("Deutch", 2);
    public static Language FRENCH = new Language("Français", 3);
    public static Language SPANISH = new Language("Españiol", 4);

    //the actual language
    public static Language language = ENGLISH;


    private String name;
    private Integer value;


    public Language(String name, Integer value) {
        this.name = name;
        this.value = value;
        nameMap.put(name, this);
        valueMap.put(value, this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public boolean isLanguageDanish() {
        return value.intValue() == DANISH.getValue();
    }


    public static Language getLanguage(Integer languageValue) {
        return valueMap.get(languageValue);
    }

    public static Language getLanguage(String language) {
        return nameMap.get(language);
    }

    public static boolean isDanish() {
        return language.getValue().intValue() == DANISH.getValue();
    }

    public static String getNationCode() {
        if (isDanish()) {
            return "DK";
        }
        else {
            return "UK";
        }
    }



}
