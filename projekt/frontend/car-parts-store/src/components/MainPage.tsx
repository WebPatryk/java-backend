import React, { useEffect, useState } from "react";
import "styles/navbar.css";
import NewCarPart from "components/NewCarPart";
import List from "components/List";

interface CarPart {
  id: number;
  name: string;
  description: string;
  price: number;
  url: string;
}

const MainPage = () => {
  const [carParts, setCarParts] = useState<CarPart[]>(null);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await fetch("http://localhost:8080/products/getAll");
        const json = await response.json();
        console.log(json);
        setCarParts(json);
      } catch (_err) {
        console.log(_err);
      }
    };
    fetchData();
  }, []);

  return (
    <>
      <NewCarPart />
      <List carParts={carParts} />
    </>
  );
};

export default MainPage;
