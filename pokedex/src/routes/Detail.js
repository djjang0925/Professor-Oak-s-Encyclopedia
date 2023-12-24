import { useEffect, useState } from "react";
import { Link, useParams } from "react-router-dom";
import PokemonDetail from "../components/PokemonDetail";
import styles from "./css/Detail.module.css";

const Detail = () => {
  const { id } = useParams();

  const [loading, setLoading] = useState(true);
  const [pokemon, setPokemon] = useState([]);
  const getPokemon = async () => {
    const json = await (await fetch(`http://localhost:80/pokemon/${id}`)).json();
    setPokemon(json);
    setLoading(false);
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
            pokedexNumber={pokemon.pokedexNumber}
            retroImg={pokemon.retroImg}
            name={pokemon.name}
            genera={pokemon.genera}
            color={pokemon.color}
            description={pokemon.description}
            isLegendary={pokemon.isLegendary}
            baseHappiness={pokemon.baseHappiness}
            captureRate={pokemon.captureRate}
          />
          <div className={styles.page}>
            <Link className={styles.pageTo} to={`${process.env.PUBLIC_URL}/pokemons/${pokemon.pokedexNumber - 1}`}>{"<<"}</Link>
            <Link className={styles.pageTo} to={`${process.env.PUBLIC_URL}/pokemons/${pokemon.pokedexNumber + 1}`}>{">>"}</Link>
          </div>
        </div>
      )}
    </div>
  );
};

export default Detail;
