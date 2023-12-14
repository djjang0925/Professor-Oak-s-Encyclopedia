import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Home from "./routes/Home";

function App() {
  return (
    <div>
      <Router>
        <Routes>
          <Route path={`${process.env.PUBLIC_URL}/`} element={<Home />} />
        </Routes>
      </Router>
    </div>
  );
}

export default App;
