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
        <li>Car part 1 </li>
        <li>Car part 2 </li>
        <li>Car part 3 </li>
        <li>Car part 4 </li>
      </ul>
    </div>
  );
};

export default List;
