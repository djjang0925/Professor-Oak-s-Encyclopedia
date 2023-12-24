import styles from "./css/Home.module.css";
import Option from "../components/Option.js";
import { Link } from "react-router-dom";
import { useTranslation } from "react-i18next";

const Home = () => {
  const { t } = useTranslation();

  return (
    <div className={styles.container}>
      <img
        className={styles.pokemon}
        src={`${process.env.PUBLIC_URL}/img/main.png`}
        alt="mainLogo"
      />
      <img
        className={styles.oak}
        src={`${process.env.PUBLIC_URL}/img/main2.png`}
        alt="mainLogo"
      />
      <div>
        <span>{t(`home.description`)}</span>
      </div>
      <ul className="framed buttons compact" style={{ width: "600px" }}>
        <li>
          <button>
            <Link
              className={styles.button}
              to={`${process.env.PUBLIC_URL}/pokemons`}
            >
              {t(`home.pokédex`)}
            </Link>
          </button>
        </li>
        <li>
          <Option />
        </li>
        {/* 조건문으로 회원정보 수정 및 로그아웃 으로 변경 */}
        <li>
          <button>{t(`home.login`)}</button>
        </li>
        <li>
          <button>{t(`home.signin`)}</button>
        </li>
      </ul>
    </div>
  );
};

export default Home;
