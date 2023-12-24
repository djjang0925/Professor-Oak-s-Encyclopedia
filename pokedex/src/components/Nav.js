import React from "react";
import styles from "./css/Nav.module.css";
import Option from "./Option";
import { useTranslation } from "react-i18next";
import { Link } from "react-router-dom";

const Nav = () => {
  const { t } = useTranslation();
  return (
    <div className={styles.nav}>
      <div style={{ display: "flex" }}>
        <button>
          <Link to={`${process.env.PUBLIC_URL}/`}>{t(`nav.home`)}</Link>
        </button>
        <button>
          <Link to={`${process.env.PUBLIC_URL}/pokemons`}>
            {t(`nav.pokédex`)}
          </Link>
        </button>
      </div>
      <Option />
    </div>
  );
};

export default Nav;
