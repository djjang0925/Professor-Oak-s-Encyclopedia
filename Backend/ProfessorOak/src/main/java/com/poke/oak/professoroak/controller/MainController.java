package com.poke.oak.professoroak.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.poke.oak.professoroak.PokedexDto;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MainController {
    @GetMapping("/")
    public String test() {
//        RestTemplate restTemplate = new RestTemplate();
//        String url = "https://pokeapi.co/api/v2/pokemon-species/25/";
//
//        // URL에 해당하는 값을 ResponseEntity로 받아오기
//        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
//
//        // ResponseEntity의 Body에 값이 존재하면 JSON으로 받아온 값을 PokedexDto로 변환
//        if(response.hasBody()) {
//            ObjectMapper mapper = new ObjectMapper();
//            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//            try {
//                PokedexDto pokedexDto = mapper.readValue(response.getBody(), PokedexDto.class);
////                System.out.println(response.getBody());
//
//                // PokedexDto로 변환한 JSON을 확인하기 위해 임시로 StringBuilder에 담아 화면에 뿌림
//                StringBuilder sb = new StringBuilder();
//
//                sb.append("<ul>");
//
//                // 도감번호
//                sb.append("<li><div>");
//                sb.append("pokedexNumber: ").append(pokedexDto.getPokedex_numbers()).append("\n");
//                sb.append("</div></li><hr />");
//                // 포켓몬 이름
//                sb.append("<li><div>");
//                sb.append("name: ");
//                sb.append("</div><ul>");
//                for(String key : pokedexDto.getNames().keySet()) {
//                    sb.append("<li><div>");
//                    sb.append(key).append(": ").append(pokedexDto.getNames().get(key)).append("\n");
//                    sb.append("</div></li>");
//                }
//                sb.append("</ul></li><hr />");
//                // 포켓몬 타입
//                sb.append("<li><div>");
//                sb.append("genera: ");
//                sb.append("</div><ul>");
//                for(String key : pokedexDto.getGenera().keySet()) {
//                    sb.append("<li><div>");
//                    sb.append(key).append(": ").append(pokedexDto.getGenera().get(key)).append("\n");
//                    sb.append("</div></li>");
//                }
//                sb.append("</ul></li><hr />");
//                // 색깔
//                sb.append("<li><div>");
//                sb.append("color: ").append(pokedexDto.getColor()).append("\n");
//                sb.append("</div></li><hr />");
//                // 설명
//                sb.append("<li><div>");
//                sb.append("flavorText: ");
//                sb.append("</div><ul>");
//                for(String key : pokedexDto.getFlavor_text_entries().keySet()) {
//                    String desc = pokedexDto.getFlavor_text_entries().get(key);
//                    desc = desc.replaceAll("\n", "<br />");
//                    sb.append("<li><div>");
//                    sb.append(key).append(": ").append(desc).append("\n");
//                    sb.append("</div></li>");
//                }
//                sb.append("</ul></li><hr />");
//                // 전설 여부
//                sb.append("<li><div>");
//                sb.append("isLegendary: ").append(pokedexDto.isIs_legendary()).append("\n");
//                sb.append("</div></li><hr />");
//                // 기본 친밀도
//                sb.append("<li><div>");
//                sb.append("baseHappiness: ").append(pokedexDto.getBase_happiness()).append("\n");
//                sb.append("</div></li><hr />");
//                // 포획 확률
//                sb.append("<li><div>");
//                sb.append("captureRate: ").append(pokedexDto.getCapture_rate()).append("\n");
//                sb.append("</div></li><hr />");
//
//                sb.append("</ul>");
//
//                return sb.toString();
//            } catch (JsonProcessingException e) {
//                throw new RuntimeException(e);
//            }
//        }

        return "Professor Oak Test!!";
    }

    @GetMapping("/poke/{number}")
    public String poke(@PathVariable("number") int number) {

        RestTemplate restTemplate = new RestTemplate();
        String url = "https://pokeapi.co/api/v2/pokemon-species/" + number + "/";

        // URL에 해당하는 값을 ResponseEntity로 받아오기
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        // ResponseEntity의 Body에 값이 존재하면 JSON으로 받아온 값을 PokedexDto로 변환
        if(response.hasBody()) {
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            try {
                PokedexDto pokedexDto = mapper.readValue(response.getBody(), PokedexDto.class);
//                System.out.println(response.getBody());

                // PokedexDto로 변환한 JSON을 확인하기 위해 임시로 StringBuilder에 담아 화면에 뿌림
                StringBuilder sb = new StringBuilder();

                sb.append("<ul>");

                // 도감번호
                sb.append("<li><div>");
                sb.append("pokedexNumber: ").append(pokedexDto.getPokedex_numbers()).append("\n");
                sb.append("</div></li><hr />");
                // 포켓몬 이름
                sb.append("<li><div>");
                sb.append("name: ");
                sb.append("</div><ul>");
                for(String key : pokedexDto.getNames().keySet()) {
                    sb.append("<li><div>");
                    sb.append(key).append(": ").append(pokedexDto.getNames().get(key)).append("\n");
                    sb.append("</div></li>");
                }
                sb.append("</ul></li><hr />");
                // 포켓몬 타입
                sb.append("<li><div>");
                sb.append("genera: ");
                sb.append("</div><ul>");
                for(String key : pokedexDto.getGenera().keySet()) {
                    sb.append("<li><div>");
                    sb.append(key).append(": ").append(pokedexDto.getGenera().get(key)).append("\n");
                    sb.append("</div></li>");
                }
                sb.append("</ul></li><hr />");
                // 색깔
                sb.append("<li><div>");
                sb.append("color: ").append(pokedexDto.getColor()).append("\n");
                sb.append("</div></li><hr />");
                // 설명
                sb.append("<li><div>");
                sb.append("flavorText: ");
                sb.append("</div><ul>");
                for(String key : pokedexDto.getFlavor_text_entries().keySet()) {
                    String desc = pokedexDto.getFlavor_text_entries().get(key);
                    desc = desc.replaceAll("\n", "<br />");
                    sb.append("<li><div>");
                    sb.append(key).append(": ").append(desc).append("\n");
                    sb.append("</div></li>");
                }
                sb.append("</ul></li><hr />");
                // 전설 여부
                sb.append("<li><div>");
                sb.append("isLegendary: ").append(pokedexDto.isIs_legendary()).append("\n");
                sb.append("</div></li><hr />");
                // 기본 친밀도
                sb.append("<li><div>");
                sb.append("baseHappiness: ").append(pokedexDto.getBase_happiness()).append("\n");
                sb.append("</div></li><hr />");
                // 포획 확률
                sb.append("<li><div>");
                sb.append("captureRate: ").append(pokedexDto.getCapture_rate()).append("\n");
                sb.append("</div></li><hr />");

                sb.append("</ul>");

                return sb.toString();
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        }

        return "Professor Oak Test!!";
    }
}
