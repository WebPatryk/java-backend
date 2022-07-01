import React, { useEffect, useState } from "react";
import "styles/navbar.css";
import NewCarPart from "components/NewCarPart";
import List from "components/List";

interface CarPart {
    id: number;
    name: string;
    description: string;
    price: number;
    imageUrl: string;
}

const MainPage = () => {
    const [discounts, setDiscounts] = useState<CarPart[]>(null);

    useEffect(() => {
        const fetchData = async () => {
            try {
                const response = await fetch("http://localhost:8080/discounts/getAll");
                const json = await response.json();
                console.log(json);
                setDiscounts(json);
            } catch (_err) {
                console.log(_err);
            }
        };
        fetchData();
    }, []);

    return (
        <>
            <div style={{maxWidth:'30%', margin:'auto'}}>
            <div style={{textAlign:"center"}}>
                <h3>Discounts!</h3>
                <p>It's a list with 3 discount products today!</p>
                <p>Enjoy!!!</p>
            </div>
            {discounts && discounts.map(discount=>(
                <div key={discount.id} className="container-list">
                    <img src={discount.imageUrl} alt={discount.name} className="image"/>
                    <div>
                        <h3>{discount.name}</h3>
                        <p>{discount.description}</p>
                    </div>
                </div>
            ))}
            </div>
        </>
    );
};


export default MainPage;
