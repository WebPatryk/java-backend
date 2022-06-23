import React from "react";
import "styles/navbar.css";
import {
  Link
} from "react-router-dom";

const NavBar = () => {
  return (
    <div className="App">
      <header className="navbar">
        <p>Date: <i>{new Date().toLocaleDateString()}</i></p>
        <h3 className="title">Car parts store</h3>

        <Link className="button_user" to="/profile">
          <img
            src="https://cdn-icons-png.flaticon.com/512/219/219986.png"
            alt="user_logo"
          />
        </Link>
      </header>
    </div>
  );
};

export default NavBar;
