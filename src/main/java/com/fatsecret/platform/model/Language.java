package com.fatsecret.platform.model;

public enum Language {

    ARABIC("ar"),
    CHINESE("zh"),
    CHINESE_TRADITIONAL("zh-TW"),
    DANISH("da"),
    DUTCH("nl"),
    ENGLISH("en"),
    ENGLISH_CANADA("en-CA"),
    ENGLISH_REGIONAL("en-UK"),
    FINNISH("fi"),
    FRENCH("fr"),
    GERMAN("de"),
    INDONESIAN("id"),
    ITALIAN("it"),
    JAPANESE("ja"),
    KOREAN("ko"),
    NORWEGIAN("nb"),
    POLISH("pl"),
    PORTUGUESE("pt"),
    PORTUGUESE_PORTUGAL("pt-PT"),
    RUSSIAN("ru"),
    SPANISH("es"),
    SWEDISH("sv"),
    TURKISH("tr");

    private final String code;

    Language(String code) {
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }

}
