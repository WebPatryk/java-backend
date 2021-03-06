import React from "react";
import "styles/list.css";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faPlus } from "@fortawesome/free-solid-svg-icons";
import {
  NotificationContainer,
  NotificationManager,
} from "react-notifications";

interface Props {
  carParts: CarParts[];
}

interface CarParts {
  id: number;
  name: string;
  description: string;
  price: number;
  imageUrl: string;
}

const List = ({ carParts }: Props): JSX.Element => {
  const addToBasket = async (carPart) => {
    try {
      const response = await fetch("http://localhost:8080/basket/add", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(carPart),
      });
      const json = await response.json();
      console.log(json);
    } catch (_err) {
      console.log(_err);
    }
    NotificationManager.success("Success", "Car part has been added to basket");
  };

  return (
    <div className="list">
      <h3>Car Parts list</h3>
      <ul>
        {!carParts ? (
          <p>Loading....</p>
        ) : carParts.length == 0 ? (
          <p>No car parts</p>
        ) : (
          carParts.map((carPart) => (
            <div key={carPart.id} className="container-list">
              <img
                src={carPart.imageUrl}
                alt={carPart.name}
                className="image"
              />
              <div>
                <h3>{carPart.name}</h3>
                <p>{carPart.description}</p>
              </div>
              <div className="actions">
                <FontAwesomeIcon
                  icon={faPlus}
                  onClick={() => addToBasket(carPart)}
                  className="edit"
                />
              </div>
            </div>
          ))
        )}
      </ul>
      <NotificationContainer />
    </div>
  );
};

export default List;
