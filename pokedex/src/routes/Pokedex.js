import { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import Option from "../components/Option";
import Seal from "../components/Seal";
import styles from "./css/Pokedex.module.css";

const Pokedex = () => {
  const [loading, setLoading] = useState(true);
  const [pokemon, setPokemon] = useState([]);
  const getPokemon = async () => {
    const allPokemons = [];
    for (let i = 1; i <= 12; i++) {
      const json = await (await fetch(`http://localhost:80/poke/${i}`)).json();
      allPokemons.push(json);
      console.log(json);
    }
    setPokemon(allPokemons);
    setLoading(false);
  };

  useEffect(() => {
    getPokemon();
  }, []);
  return (
    <div>
      <div className={styles.container}>
        <div className={styles.option}>
          <Option />
        </div>
        {loading ? (
          <h1>Loading...</h1>
        ) : (
          pokemon.map((poke, index) => (
            <div key={index}>
              <Link
                to={`${process.env.PUBLIC_URL}/pokemons/${poke.pokedex_numbers}`}
                style={{ textDecoration: "none" }}
              >
                <Seal
                  pokedexNumbers={poke.pokedex_numbers}
                  names={poke.names}
                  color={poke.color}
                />
              </Link>
            </div>
          ))
        )}
      </div>
    </div>
  );
};

export default Pokedex;
