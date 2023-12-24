package com.poke.oak.pokedex.model.service;

import com.poke.oak.pokedex.model.PokedexDto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface PokedexService {

    // DB에 포켓몬 정보 저장
    public void importDB(PokedexDto pokedexDto) throws Exception;
    // DB에서 포켓몬 리스트 가져오기
    public List<HashMap<String, Object>> getPokemonList(Map<String, String> param) throws Exception;
    // 도감 번호에 해당하는 포켓몬 상세 정보 가져오기
    public Map<String, Object> getPokemon(int number) throws Exception;

}
