import { useState } from "react";
import styles from "./Option.module.css";
import Modal from "react-modal";
import { useTranslation } from "react-i18next";
import i18n from "../locales/i18n";

const Option = () => {
  const { t } = useTranslation();
  const changeLanguage = (lang: string) => {
    i18n.changeLanguage(lang);
  };
  const [modal, setModal] = useState(false);
  return (
    <div>
      <button onClick={() => setModal(true)}>{t(`home.option`)}</button>
      <Modal
        className={styles.modal}
        isOpen={modal}
        onRequestClose={() => setModal(false)}
      >
        <div class="framed">
          <h1>{t(`home.option`)}</h1>
          <ul>
            <li className={styles.optionList}>
              {t(`option.language`)} :{" "}
              <button onClick={() => changeLanguage("en")}>
                {t(`option.english`)}
              </button>{" "}
              /{" "}
              <button onClick={() => changeLanguage("ko")}>
                {t(`option.korea`)}
              </button>
            </li>
            <li className={styles.optionList}>
              {t(`option.ui`)} : <button>{t(`option.gameboy`)}</button> /{" "}
              <button>{t(`option.latest`)}</button>
            </li>
          </ul>
          <div className={styles.close}>
            <button onClick={() => setModal(false)}>{t(`option.close`)}</button>
          </div>
        </div>
      </Modal>
    </div>
  );
};

export default Option;
