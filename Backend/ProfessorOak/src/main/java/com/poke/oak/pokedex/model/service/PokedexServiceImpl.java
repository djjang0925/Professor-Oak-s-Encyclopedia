package com.poke.oak.pokedex.model.service;

import com.poke.oak.pokedex.model.PokedexDto;
import com.poke.oak.pokedex.model.PokemonDto;
import com.poke.oak.pokedex.model.mapper.PokedexMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PokedexServiceImpl implements PokedexService {

    @Autowired
    PokedexMapper pokedexMapper;

    @Override
    public void importDB(PokedexDto pokedexDto) throws Exception{
        // API에서 받아온 PokedexDto에서 DB작업을 위한 PokemonDto로 변환
        PokemonDto pokemonDto = new PokemonDto();
        pokemonDto.setPokedexNumber(pokedexDto.getPokedex_numbers());
        pokemonDto.setColor(pokedexDto.getColor());
        pokemonDto.setLegendary(pokedexDto.isIs_legendary());
        pokemonDto.setBaseHappiness(pokedexDto.getBase_happiness());
        pokemonDto.setCaptureRate(pokedexDto.getCapture_rate());
        pokemonDto.setNameKo(pokedexDto.getNames().get("ko"));
        pokemonDto.setNameEn(pokedexDto.getNames().get("en"));
        pokemonDto.setGeneraKo(pokedexDto.getGenera().get("ko"));
        pokemonDto.setGeneraEn(pokedexDto.getGenera().get("en"));
        pokemonDto.setDescriptionKo(pokedexDto.getFlavor_text_entries().get("ko"));
        pokemonDto.setDescriptionEn(pokedexDto.getFlavor_text_entries().get("en"));
        pokemonDto.setRetroImg("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/" + pokemonDto.getPokedexNumber() + ".png");

        pokedexMapper.importDB(pokemonDto);
    }

    @Override
    public List<HashMap<String, Object>> getPokemonList(Map<String, String> param) throws Exception {
        // 매퍼 호출 후 리스트 리턴 받기
        List<PokemonDto> pokeList = pokedexMapper.getPokemonList(param);
        // 리턴 받은 리스트를 HashMap List에 담아서 필요한 데이터만 보내기 위해 처리
        List<HashMap<String, Object>> retList = new ArrayList<HashMap<String, Object>>();

        if(!pokeList.isEmpty()) {
            for(PokemonDto pokemon : pokeList) {
                HashMap<String, Object> map = new HashMap<String, Object>();
                map.put("pokedexNumber", pokemon.getPokedexNumber());
                map.put("color", pokemon.getColor());
                map.put("name", new HashMap<String, String>(){{
                    put("ko", pokemon.getNameKo());
                    put("en", pokemon.getNameEn());
                }});
                map.put("retroImg", pokemon.getRetroImg());

                retList.add(map);
            }
        }

        return retList;
    }

    @Override
    public PokemonDto getPokemon(int number) throws Exception {
        return pokedexMapper.getPokemon(number);
    }
}
