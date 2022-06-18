import React from "react";
import "styles/newCartPart.css";

const NewCarPart = () => {
  return (
    <div className="new-cart-container">
      <h3 className="cart-title">Add new car part</h3>
      <form className="addNewCart-form">
        <input type="text" placeholder="name" />
        <textarea placeholder="description" />
        <input type="text" placeholder="price" />
        <input type="text" placeholder="image url" />
        <button type="submit">Submit</button>
      </form>
    </div>
  );
};

export default NewCarPart;
