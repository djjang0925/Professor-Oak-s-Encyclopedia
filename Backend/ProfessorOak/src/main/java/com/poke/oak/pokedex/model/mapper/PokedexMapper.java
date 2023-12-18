package com.poke.oak.pokedex.model.mapper;

import com.poke.oak.pokedex.model.PokemonDto;
import org.apache.ibatis.annotations.Mapper;

import java.sql.SQLException;
import java.util.List;

@Mapper
public interface PokedexMapper {

    void importDB(PokemonDto pokemonDto) throws SQLException;
    List<PokemonDto> getPokemonList() throws SQLException;
    PokemonDto getPokemon(int number) throws SQLException;
}
