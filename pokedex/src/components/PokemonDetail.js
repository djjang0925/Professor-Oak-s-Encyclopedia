import { useTranslation } from "react-i18next";
import styles from "./css/PokemonDetail.module.css";
import Nav from "./Nav";

const PokemonDetail = ({
  pokedexNumber,
  retroImg,
  name,
  genera,
  color,
  description,
  isLegendary,
  baseHappiness,
  captureRate,
}) => {
  const { i18n } = useTranslation();

  return (
    <div>
      <Nav />
      <div className="framed">
        <div className={styles.responsive}>
          <img
            className={styles.pokemonImg}
            src={`${retroImg}`}
            alt={name["en"]}
          />
          <div className={styles.responsiveDescription}>
            <div className={styles.nameBox}>
              <div className={styles.index}>No.{pokedexNumber}</div>
              {i18n.language === "en" ? (
                <div className={styles.enName}>{name["en"]}</div>
              ) : (
                <div className={styles.koName}>{name["ko"]}</div>
              )}
            </div>
            <hr className={styles.division} />
            <div className={styles.description}>
              {i18n.language === "en" ? (
                <div>
                  <div className={"progress-bar-container"}>
                    <label>Base Happiness</label>
                    <div className={styles.bar}>
                      <div className={`progress-bar p${baseHappiness}`} />
                    </div>
                  </div>
                  <div className={"progress-bar-container"}>
                    <label>Capture Rate</label>
                    <div className={styles.bar}>
                      <div className={`progress-bar p${captureRate}`} />
                    </div>
                  </div>
                  <div>{genera["en"]}</div>
                  <div>{description["en"]}</div>
                </div>
              ) : (
                <div>
                  <div className={"progress-bar-container"}>
                    <label>기본 친밀도</label>
                    <div className={styles.bar}>
                      <div className={`progress-bar p${baseHappiness}`} />
                    </div>
                  </div>
                  <div className={"progress-bar-container"}>
                    <label>포획 확률</label>
                    <div className={styles.bar}>
                      <div className={`progress-bar p${captureRate}`} />
                    </div>
                  </div>
                  <div>{genera["ko"]}</div>
                  <div>{description["ko"]}</div>
                </div>
              )}
              {isLegendary ? <li>Legendary</li> : null}
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default PokemonDetail;
