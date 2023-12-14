import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Home from "./routes/Home";
import Pokedex from "./routes/Pokedex";
import Detail from "./routes/Detail";

function App() {
  return (
    <div>
      <Router>
        <Routes>
          <Route path={`${process.env.PUBLIC_URL}/`} element={<Home />} />
          <Route path={`${process.env.PUBLIC_URL}/pokemons`} element={<Pokedex />} />
          <Route path={`${process.env.PUBLIC_URL}/pokemons/:id`} element={<Detail />} />
        </Routes>
      </Router>
    </div>
  );
}

export default App;
