import { useTranslation } from "react-i18next";
import Option from "./Option";
import styles from "./css/PokemonDetail.module.css";

const PokemonDetail = ({
  pokedexNumbers,
  names,
  genera,
  color,
  flavorTextEntries,
  isLegendary,
  baseHappiness,
  captureRate,
}) => {
  const { i18n } = useTranslation();

  return (
    <div>
      <div style={{ textAlign: "end" }}>
        <Option />
      </div>
      <div className="framed">
        <div className={styles.responsive}>
          <img
            className={styles.pokemonImg}
            src={`${process.env.PUBLIC_URL}/img/footer.png`}
            alt={names["en"]}
          />
          <div className={styles.description}>
            <div className={styles.nameBox}>
              <div className={styles.index}>No.{pokedexNumbers}</div>
              {i18n.language === "en" ? (
                <div className={styles.enName}>{names["en"]}</div>
              ) : (
                <div className={styles.koName}>{names["ko"]}</div>
              )}
            </div>
            <hr
              className={styles.division}
              style={{ border: "dashed double" }}
            />
            <li>{genera["ko"]}</li>
            <li>{genera["en"]}</li>
            <li>{color}</li>
            <li>{flavorTextEntries["sword-ko"]}</li>
            <li>{flavorTextEntries["sword-en"]}</li>
            <li>{isLegendary}</li>
            <li>{baseHappiness}</li>
            <li>{captureRate}</li>
          </div>
        </div>
      </div>
    </div>
  );
};

export default PokemonDetail;
