import React from "react";
import "styles/app.css";
import NavBar from "./NavBar";
import Profile from "components/Profile";
import { Route, BrowserRouter as Router, Routes } from "react-router-dom";
import MainPage from "components/MainPage";
import Discount from "components/Discount";
import Basket from "components/Basket";
import Register from "components/Register";

function HomePage() {
  return (
    <Router>
      <div className="App">
        <NavBar />
        <Routes>
          <Route path="/" element={<MainPage />} />
          <Route path="/profile" element={<Profile />} />
          <Route path="/discount" element={<Discount />} />
          <Route path="/basket" element={<Basket />} />
          <Route path="/register" element={<Register />} />
        </Routes>
      </div>
    </Router>
  );
}

export default HomePage;
