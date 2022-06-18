import React, { useEffect, useState } from "react";
import "styles/app.css";
import NavBar from "./NavBar";
import NewCarPart from "components/NewCarPart";
import List from "components/List";

interface CarPart {
  id: number;
  name: string;
  description: string;
  price: number;
  url: string;
}

function HomePage() {
  const [carParts, setCarParts] = useState<CarPart[]>(null);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await fetch("http://localhost:8080/products/getAll", {
          mode: "no-cors",
        });
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
    <div className="App">
      <NavBar />
      <NewCarPart />
      <List carParts={carParts} />
    </div>
  );
}

export default HomePage;
