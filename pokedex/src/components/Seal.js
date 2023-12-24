import styles from "./css/Seal.module.css";
import { useTranslation } from "react-i18next";

const Seal = ({ pokedexNumbers, names, color }) => {
  const { i18n } = useTranslation();

  return (
    <div className="framed" style={{backgroundColor: "white"}}>
      <div className={styles.container}>
        <span className={styles.index}>
          <div className={styles.indexNumber}>{pokedexNumbers}</div>
          {i18n.language === "en" ? (
            <div className={styles.indexEnName}>{names["en"]}</div>
          ) : (
            <div className={styles.indexKoName}>{names["ko"]}</div>
          )}
        </span>
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
  );
};

export default Seal;
