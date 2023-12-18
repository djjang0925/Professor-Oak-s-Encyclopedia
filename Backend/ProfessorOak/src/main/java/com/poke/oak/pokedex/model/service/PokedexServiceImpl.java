package com.poke.oak.pokedex.model.service;

import com.poke.oak.pokedex.model.PokedexDto;
import com.poke.oak.pokedex.model.PokemonDto;
import com.poke.oak.pokedex.model.mapper.PokedexMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<PokemonDto> getPokemonList() throws Exception {
        return pokedexMapper.getPokemonList();
    }

    @Override
    public PokemonDto getPokemon(int number) throws Exception {
        return pokedexMapper.getPokemon(number);
    }
}
