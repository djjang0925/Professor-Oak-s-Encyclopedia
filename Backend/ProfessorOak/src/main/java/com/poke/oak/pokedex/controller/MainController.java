package com.poke.oak.pokedex.controller;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.poke.oak.pokedex.model.PokedexDto;
import com.poke.oak.pokedex.model.PokemonDto;
import com.poke.oak.pokedex.model.service.PokedexServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = { "*" }, methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE} , maxAge = 6000)
@RestController
public class MainController {

    @Autowired
    PokedexServiceImpl pokedexService;

    @GetMapping("/")
    public String test() {
        return "Professor Oak Test!!";
    }

    /**
     * 포켓몬 DB에 저장
     * @param number
     */
    @GetMapping("/save-pokemon/{number}")
    public ResponseEntity<?> poke(@PathVariable("number") int number) {

        RestTemplate restTemplate;
        String url;

        // number가 0일 경우 1 ~ 151 포켓몬 저장
        if(number == 0) {
            for(int i = 1; i <= 151; i++) {
                restTemplate = new RestTemplate();
                url = "https://pokeapi.co/api/v2/pokemon-species/" + i + "/";

                // URL에 해당하는 값을 ResponseEntity로 받아오기
                ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

                // ResponseEntity의 Body에 값이 존재하면 JSON으로 받아온 값을 PokedexDto로 변환
                if(response.hasBody()) {
                    ObjectMapper mapper = new ObjectMapper();
                    mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                    try {
                        PokedexDto pokedexDto = mapper.readValue(response.getBody(), PokedexDto.class);

                        // DB에 해당 포켓몬 정보 저장
                        pokedexService.importDB(pokedexDto);

                    } catch (Exception e) {
//                        e.printStackTrace();
                        return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
                    }
                }
            }
        }
        else {
            restTemplate = new RestTemplate();
            url = "https://pokeapi.co/api/v2/pokemon-species/" + number + "/";

            // URL에 해당하는 값을 ResponseEntity로 받아오기
            ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

            // ResponseEntity의 Body에 값이 존재하면 JSON으로 받아온 값을 PokedexDto로 변환
            if(response.hasBody()) {
                ObjectMapper mapper = new ObjectMapper();
                mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                try {
                    PokedexDto pokedexDto = mapper.readValue(response.getBody(), PokedexDto.class);

                    // DB에 해당 포켓몬 정보 저장
                    pokedexService.importDB(pokedexDto);

                } catch (Exception e) {
//                    e.printStackTrace();
                    return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        }

        return new ResponseEntity<String>("Done!", HttpStatus.OK);
    }

    /**
     * 포켓몬 리스트 얻기
     * 도감번호, 색깔, 이름(한/영), 이미지 경로
     * @param param, key는 condition(검색조건), data(검색할 데이터)
     * @return List<HashMap<String, String>>형태의 포켓몬 리스트
     */
    @GetMapping("pokemon-list")
    public ResponseEntity<?> getPokemonList(@RequestParam Map<String, String> param) {
        try {
            // 서비스 호출 후 리스트 받기
            List<HashMap<String, Object>> pokeList = pokedexService.getPokemonList(param);

            return new ResponseEntity<List<HashMap<String, Object>>>(pokeList, HttpStatus.OK);
        } catch (Exception e) {
//            e.printStackTrace();
            return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * 포켓몬 도감에 해당하는 포켓몬 정보 가져오기
     * @param number 포켓몬 도감 번호
     * @return
     */
    @GetMapping("pokemon/{number}")
    public ResponseEntity<?> getPokemon(@PathVariable("number") int number) {
        try {
            PokemonDto pokemonDto = pokedexService.getPokemon(number);

            // front로 보내주기 위해 처리
            Map<String, Object> retPokemon = new HashMap<String, Object>();
            retPokemon.put("pokedexNumber", pokemonDto.getPokedexNumber());
            retPokemon.put("color", pokemonDto.getColor());
            retPokemon.put("isLegendary", pokemonDto.isLegendary());
            retPokemon.put("baseHappiness", pokemonDto.getBaseHappiness());
            retPokemon.put("captureRate", pokemonDto.getCaptureRate());
            retPokemon.put("name", new HashMap<String, String>() {{
                put("ko", pokemonDto.getNameKo());
                put("en", pokemonDto.getNameEn());
            }});
            retPokemon.put("genera", new HashMap<String, String>(){{
                put("ko", pokemonDto.getGeneraKo());
                put("en", pokemonDto.getGeneraEn());
            }});
            retPokemon.put("description", new HashMap<String, String>(){{
                put("ko", pokemonDto.getDescriptionKo());
                put("en", pokemonDto.getDescriptionEn());
            }});
            retPokemon.put("retroImg", pokemonDto.getRetroImg());

            return new ResponseEntity<Map<String, Object>>(retPokemon, HttpStatus.OK);
        } catch (Exception e) {
//            e.printStackTrace();
            return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

//    /**
//     * 이름으로 포켓몬 정보 검색하기
//     * @param name 포켓몬 이름
//     * @return
//     */
//    @GetMapping("pokemon-name/{name}")
//    public ResponseEntity<?> getPokemonByName(@PathVariable("name") String name) {
//        try {
//
//        } catch(Exception e) {
//            return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
}

