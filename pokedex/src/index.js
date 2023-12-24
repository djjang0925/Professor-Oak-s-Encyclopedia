import React, { StrictMode } from "react";
import ReactDOM from "react-dom/client";
import App from "./App";
import "./locales/i18n";

const root = ReactDOM.createRoot(document.getElementById("root"));
root.render(
  <StrictMode>
    <App />
  </StrictMode>,
);
