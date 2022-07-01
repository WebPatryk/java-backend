import React from "react";
import "styles/navbar.css";
import { Link } from "react-router-dom";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faShoppingBasket } from "@fortawesome/free-solid-svg-icons";

const NavBar = () => {
  return (
    <div className="App">
      <header className="navbar">
        <img
          src="https://imagescdn.dealercarsearch.com/dealerimages/4488/26025/logo.png"
          alt="logo"
          style={{ width: 150 }}
        />
        <ul className="navbar-list">
          <li>
            <Link className="" to="/">
              Car parts store
            </Link>
          </li>
          <li>
            <Link className="" to="/discount">
              Discount
            </Link>
          </li>
          <li>
            <Link
              className="button_user"
              to="/profile"
              style={{ display: "flex", alignItems: "center" }}
            >
              User profile
            </Link>
          </li>
          <li>
            <Link className="" to="/basket">
              <FontAwesomeIcon
                icon={faShoppingBasket}
                onClick={() => console.log("clicekd")}
                className="edit"
                style={{ marginRight: 10 }}
              />
              Basket
            </Link>
          </li>
        </ul>
      </header>
    </div>
  );
};

export default NavBar;
