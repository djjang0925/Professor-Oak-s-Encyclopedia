import styles from "./css/Seal.module.css";
import { useTranslation } from "react-i18next";

const Seal = ({ pokedexNumber, name, color, image }) => {
  const { i18n } = useTranslation();

  return (
    <div className={styles.seal}>
      <div className={"framed"} style={{ backgroundColor: "white" }}>
        <div className={styles.container}>
          <span className={styles.index}>
            <div
              style={{ backgroundColor: color }}
              className={styles.indexNumber}
            >
              {pokedexNumber}
            </div>
            {i18n.language === "en" ? (
              <div className={styles.indexEnName}>{name["en"]}</div>
            ) : (
              <div className={styles.indexKoName}>{name["ko"]}</div>
            )}
          </span>
          <img className={styles.image} src={image} alt="pokemon" />
        </div>
        <div className={styles.footer}>
          <span className={styles.corporation}>
            <img
              className={styles.monsterball}
              src={`${process.env.PUBLIC_URL}/img/footer.png`}
              alt="monsterball"
            />
            <span>Pokémon</span>
          </span>
        </div>
      </div>
    </div>
  );
};

export default Seal;
