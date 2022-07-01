import React, { useEffect, useState } from "react";
import "styles/newCartPart.css";
import {
  NotificationContainer,
  NotificationManager,
} from "react-notifications";

const NewCarPart = () => {
  const [values, setValues] = useState({
    name: "",
    description: "",
    price: "",
    imageUrl: "",
  });

  const onChange = (e) => {
    setValues({ ...values, [e.target.name]: e.target.value } as any);
  };

  const handleSubmit = (e) => {
    const { name, description, price, imageUrl } = values;

    e.preventDefault();
    if (!name || !description || !price || !imageUrl) return;
    const fetchData = async () => {
      try {
        const response = await fetch("http://localhost:8080/products/add", {
          method: "POST",
          headers: {
            "Content-Type": "application/json",
          },
          body: JSON.stringify(values),
        });
        const json = await response.json();
        console.log(json);
        NotificationManager.success("Success", "Car part has been added");
      } catch (_err) {
        console.log(_err);
      }
    };
    fetchData();
    console.log(values);
  };

  return (
    <div className="new-cart-container">
      <h3 className="cart-title">Add new car part</h3>
      <form className="addNewCart-form" onSubmit={handleSubmit}>
        <input type="text" placeholder="name" name="name" onChange={onChange} />
        <textarea
          placeholder="description"
          name="description"
          onChange={onChange}
        />
        <input
          type="text"
          placeholder="price"
          name="price"
          onChange={onChange}
        />
        <input
          type="text"
          placeholder="image url"
          name="imageUrl"
          onChange={onChange}
        />
        <button type="submit">Submit</button>
      </form>
      <NotificationContainer />
    </div>
  );
};

export default NewCarPart;
