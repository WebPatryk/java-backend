import React from "react";
import "styles/navbar.css";
const NavBar = () => {
  return (
    <div className="App">
      <header className="navbar">
        <p>{new Date().toLocaleDateString()}</p>
        <h3 className="title">Car parts store</h3>

        <button className="button_user">
          <img
            src="https://cdn-icons-png.flaticon.com/512/219/219986.png"
            alt="user_logo"
          />
        </button>
      </header>
    </div>
  );
};

export default NavBar;
