import { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import Nav from "../components/Nav";
import Seal from "../components/Seal";
import styles from "./css/Pokedex.module.css";

const Pokedex = () => {
  const [loading, setLoading] = useState(true);
  const [pokemon, setPokemon] = useState([]);
  const getPokemon = async () => {
    const json = await (await fetch(`http://localhost:80/pokemon-list`)).json();
    setPokemon(json);
    setLoading(false);
  };

  useEffect(() => {
    getPokemon();
  }, []);
  return (
    <div>
      <div className={styles.container}>
        <div className={styles.option}>
          <Nav />
        </div>
        {loading ? (
          <h1>Loading...</h1>
        ) : (
          pokemon.map((poke, index) => (
            <div key={index}>
              <Link
                to={`${process.env.PUBLIC_URL}/pokemons/${poke.pokedexNumber}`}
                style={{ textDecoration: "none" }}
              >
                <Seal
                  pokedexNumber={poke.pokedexNumber}
                  name={poke.name}
                  color={poke.color}
                  image={poke.retroImg}
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
