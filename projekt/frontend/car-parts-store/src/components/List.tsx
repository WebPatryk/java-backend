import React from "react";
import "styles/list.css";

interface Props {
  carParts: CarParts[];
}

interface CarParts {
  id: number;
  name: string;
  description: string;
  price: number;
  url: string;
}

const List = ({ carParts }: Props): JSX.Element => {
  return (
    <div className="list">
      <h3>Car Parts list</h3>
      <ul>
        {carParts &&
          carParts.map((carPart) => (
            <li key={carPart.name}>{carPart.name} </li>
          ))}
      </ul>
    </div>
  );
};

export default List;
