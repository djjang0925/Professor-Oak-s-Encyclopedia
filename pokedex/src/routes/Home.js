import styles from "./Home.module.css";
import { Link } from "react-router-dom";

const Home = () => {
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
        <span>Pokédex for 1st generation</span>
      </div>
      <ul class="framed buttons compact" style={{ width: "600px" }}>
        <li>
          <button>
            <Link
              className={styles.button}
              to={`${process.env.PUBLIC_URL}/pokedex`}
            >
              Pokédex
            </Link>
          </button>
        </li>
        <li>
          <button>Option</button>
        </li>
        {/* 조건문으로 회원정보 수정 및 로그아웃 으로 변경 */}
        <li>
          <button>Log In</button>
        </li>
        <li>
          <button>Sign In</button>
        </li>
      </ul>
    </div>
  );
};

export default Home;
