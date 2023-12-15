package com.poke.oak.professoroak;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Common {
    private String name;
    private String url;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
}

class Name {
    private Common language;
    private String name;

    public Common getLanguage() {
        return language;
    }
    public void setLanguage(Common language) {
        this.language = language;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}

class FlavorTextEntry {
    private String flavorText;
    private Common language;
    private Common version;

    public String getFlavor_text() {
        return flavorText;
    }
    public void setFlavor_text(String flavorText) {
        this.flavorText = flavorText;
    }
    public Common getLanguage() {
        return language;
    }
    public void setLanguage(Common language) {
        this.language = language;
    }
    public Common getVersion() {
        return version;
    }
    public void setVersion(Common version) {
        this.version = version;
    }
}

class Genera {
    private String genus;
    private Common language;

    public String getGenus() {
        return genus;
    }
    public void setGenus(String genus) {
        this.genus = genus;
    }
    public Common getLanguage() {
        return language;
    }
    public void setLanguage(Common language) {
        this.language = language;
    }
}

class PokedexNumber {
    private int entryNumber;
    private Common pokedex;

    public int getEntry_number() {
        return entryNumber;
    }
    public void setEntry_number(int entryNumber) {
        this.entryNumber = entryNumber;
    }
    public Common getPokedex() {
        return pokedex;
    }
    public void setPokedex(Common pokedex) {
        this.pokedex = pokedex;
    }
}

/**
 * 포켓몬 상세 정보 DTO
 */
public class PokedexDto {
    // 포켓몬 상세 설명에서 사용할 버전 정보
    private String[] versionNames = {"x", "y", "omega-ruby", "alpha-sapphire",
                                    "lets-go-pikachu", "lets-go-eevee", "sword", "shield"};

    private PokedexNumber[] pokedexNumbers;         // 도감 번호
    private Name[] names;                           // 이름
    private Genera[] genera;                        // 타입
    private Common color;                           // 색깔
    private FlavorTextEntry[] flavorTextEntries;    // 설명
    private boolean isLegendary;                    // 전설 포켓몬 여부
    private int baseHappiness;                      // 기본 친밀도
    private int captureRate;                        // 포획 확률

    /** 도감 번호 */
    public int getPokedex_numbers() {
        int result = 0;

        for(PokedexNumber pn : pokedexNumbers) {
            if(pn.getPokedex().getName().equals("national")) {
                result = pn.getEntry_number();
            }
        }

        return result;
    }
    public void setPokedex_numbers(PokedexNumber[] pokedexNumbers) {
        this.pokedexNumbers = pokedexNumbers;
    }

    /**
     * 포켓몬 이름
     * @return Map<String, String>, key: 언어, value: 포켓몬 이름
     * ex) en을 key로 줄 경우 Bulbasaur, ko를 key로 줄 경우 이상해씨
     */
    public Map<String, String> getNames() {
        Map<String, String> result = new HashMap<String, String>();
        for(Name g : names) {
            result.put(g.getLanguage().getName(), g.getName());
        }

        return result;
    }
    public void setNames(Name[] names) {
        // [0]:En, [1]:Ko담기 위한 임시 배열
        Name[] result = new Name[2];
        int idx = 0;

        for(Name n : names) {
            String lang = n.getLanguage().getName();
            if(lang.equals("ko") || lang.equals("en")) {
                result[idx++] = n;
            }
        }

        this.names = result;
    }

    /**
     * 포켓몬 타입
     * @return Map<String, String>, key: 언어, value: 포켓몬 타입
     * ex) en을 key로 줄 경우 Seed Pokémon, ko를 key로 줄 경우 씨앗포켓몬
     */
    public Map<String, String> getGenera() {
        Map<String, String> result = new HashMap<String, String>();
        for(Genera g : genera) {
            result.put(g.getLanguage().getName(), g.getGenus());
        }

        return result;
    }
    public void setGenera(Genera[] genera) {
        // [0]:En, [1]:Ko담기 위한 임시 배열
        Genera[] result = new Genera[2];
        int idx = 0;

        for(Genera g : genera) {
            String lang = g.getLanguage().getName();
            if(lang.equals("ko") || lang.equals("en")) {
                result[idx++] = g;
            }
        }

        this.genera = result;
    }

    /** 색상 */
    public String getColor() {
        return color.getName();
    }
    public void setColor(Common color) {
        this.color = color;
    }

    /**
     * 포켓몬 상세 설명
     * @return Map<String, String>, key: 버전-언어, value: 설명
     * ex) omege-ruby-ko 하면 한국어 설명, omega-ruby-en 하면 영어 설명
     */
    public Map<String, String> getFlavor_text_entries() {
        Map<String, String> result = new HashMap<String, String>();
        for(String v : versionNames) {
            for(FlavorTextEntry fte : flavorTextEntries) {
                if(fte.getVersion().getName().equals(v)) {
                    result.put(v + "-" + fte.getLanguage().getName(), fte.getFlavor_text());
                }
            }
        }

        return result;
    }
    public void setFlavor_text_entries(FlavorTextEntry[] flavorTextEntries) {
        List<FlavorTextEntry> result = new ArrayList<FlavorTextEntry>();

        for(FlavorTextEntry fte : flavorTextEntries) {
            String ver = fte.getVersion().getName();
            for(String v : versionNames) {
                if(ver.equals(v)) {
                    String lang = fte.getLanguage().getName();
                    if(lang.equals("ko") || lang.equals("en")) {
                        result.add(fte);
                    }
                }
            }
        }

        this.flavorTextEntries = result.toArray(new FlavorTextEntry[0]);
    }

    /** 전설 여부 */
    public boolean isIs_legendary() {
        return isLegendary;
    }
    public void setIs_legendary(boolean isLegendary) {
        this.isLegendary = isLegendary;
    }

    /** 기본 친밀도 */
    public int getBase_happiness() {
        return baseHappiness;
    }
    public void setBase_happiness(int baseHappiness) {
        this.baseHappiness = baseHappiness;
    }

    /** 포획 확률 */
    public int getCapture_rate() {
        return captureRate;
    }
    public void setCapture_rate(int captureRate) {
        this.captureRate = captureRate;
    }

}
