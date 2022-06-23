import React from "react";
import "styles/app.css";
import NavBar from "./NavBar";
import Profile from "components/Profile";
import { Route, BrowserRouter as Router, Routes } from "react-router-dom";
import MainPage from "components/MainPage";

function HomePage() {
  return (
    <Router>
      <div className="App">
        <NavBar />
        <Routes>
          <Route path="/" element={<MainPage />} />
          <Route path="/profile" element={<Profile />} />
        </Routes>
      </div>
    </Router>
  );
}

export default HomePage;
