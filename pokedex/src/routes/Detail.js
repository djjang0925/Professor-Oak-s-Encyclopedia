import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import PokemonDetail from "../components/PokemonDetail";
import styles from "./css/Detail.module.css";

const Detail = () => {
  const { id } = useParams();

  const [loading, setLoading] = useState(true);
  const [pokemon, setPokemon] = useState([]);
  const getPokemon = async () => {
    const json = await (await fetch(`http://localhost:80/poke/${id}`)).json();
    setPokemon(json);
    setLoading(false);
    console.log(json);
  };

  useEffect(() => {
    getPokemon();
  }, []);
  return (
    <div>
      {loading ? (
        <h1>Loading...</h1>
      ) : (
        <div className={styles.container}>
          <PokemonDetail
            pokedexNumbers={pokemon.pokedex_numbers}
            names={pokemon.names}
            genera={pokemon.genera}
            color={pokemon.color}
            flavorTextEntries={pokemon.flavor_text_entries}
            isLegendary={pokemon.is_legendary}
            baseHappiness={pokemon.base_happiness}
            captureRate={pokemon.capture_rate}
          />
        </div>
      )}
    </div>
  );
};

export default Detail;
