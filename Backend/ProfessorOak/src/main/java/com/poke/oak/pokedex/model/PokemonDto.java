package com.poke.oak.pokedex.model;

/**
 * 포켓몬 정보
 * 포켓몬
 */
public class PokemonDto {
    private int pokedexNumber;
    private String color;
    private boolean isLegendary;
    private int baseHappiness;
    private int captureRate;
    private String nameKo;
    private String nameEn;
    private String generaKo;
    private String generaEn;
    private String descriptionKo;
    private String descriptionEn;
    private String retroImg;

    public int getPokedexNumber() {
        return pokedexNumber;
    }
    public void setPokedexNumber(int pokedexNumber) {
        this.pokedexNumber = pokedexNumber;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public boolean isLegendary() {
        return isLegendary;
    }
    public void setLegendary(boolean legendary) {
        isLegendary = legendary;
    }
    public int getBaseHappiness() {
        return baseHappiness;
    }
    public void setBaseHappiness(int baseHappiness) {
        this.baseHappiness = baseHappiness;
    }
    public int getCaptureRate() {
        return captureRate;
    }
    public void setCaptureRate(int captureRate) {
        this.captureRate = captureRate;
    }
    public String getNameKo() {
        return nameKo;
    }
    public void setNameKo(String nameKo) {
        this.nameKo = nameKo;
    }
    public String getNameEn() {
        return nameEn;
    }
    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }
    public String getGeneraKo() {
        return generaKo;
    }
    public void setGeneraKo(String generaKo) {
        this.generaKo = generaKo;
    }
    public String getGeneraEn() {
        return generaEn;
    }
    public void setGeneraEn(String generaEn) {
        this.generaEn = generaEn;
    }
    public String getDescriptionKo() {
        return descriptionKo;
    }
    public void setDescriptionKo(String descriptionKo) {
        this.descriptionKo = descriptionKo;
    }
    public String getDescriptionEn() {
        return descriptionEn;
    }
    public void setDescriptionEn(String descriptionEn) {
        this.descriptionEn = descriptionEn;
    }
    public String getRetroImg() { return retroImg; }
    public void setRetroImg(String retroImg) { this.retroImg = retroImg; }

    @Override
    public String toString() {
        return "PokemonDto{" +
                "pokedexNumber=" + pokedexNumber +
                ", color='" + color + '\'' +
                ", isLegendary=" + isLegendary +
                ", baseHappiness=" + baseHappiness +
                ", captureRate=" + captureRate +
                ", nameKo='" + nameKo + '\'' +
                ", nameEn='" + nameEn + '\'' +
                ", generaKo='" + generaKo + '\'' +
                ", generaEn='" + generaEn + '\'' +
                ", descriptionKo='" + descriptionKo + '\'' +
                ", descriptionEn='" + descriptionEn + '\'' +
                ", retroImg='" + retroImg + '\'' +
                '}';
    }
}
