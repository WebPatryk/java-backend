import React, { useEffect, useState } from "react";
import "styles/navbar.css";
import NewCarPart from "components/NewCarPart";
import List from "components/List";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faEdit, faTrash } from "@fortawesome/free-solid-svg-icons";
import EditModal from "modals/EditModal";
import RemoveModal from "modals/RemoveModal";

interface CarPart {
  id: number;
  name: string;
  description: string;
  price: number;
  imageUrl: string;
  quantity: number;
}

const Basket = () => {
  const [basket, setBasket] = useState<CarPart[]>(null);
  const [isEditModalOpen, setIsEditModalActive] = useState<boolean>(false);
  const [isDeleteModalOpen, setIsDeleteModalActive] = useState<boolean>(false);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await fetch("http://localhost:8080/basket/getAll");
        const json = await response.json();
        console.log(json);
        setBasket(json);
      } catch (_err) {
        console.log(_err);
      }
    };
    fetchData();
  }, []);

  const update = (data) => {
    console.log(data);
    setIsEditModalActive(data);
  };

  const remove = (data) => {
    console.log(data);
    setIsDeleteModalActive(data);
  };

  return (
    <>
      <div className="list">
        <h3>Your basket!</h3>
        <ul>
          {!basket ? (
            <p>Loading....</p>
          ) : basket.length == 0 ? (
            <p>No car parts in basket</p>
          ) : (
            basket &&
            basket.map((carPart) => (
              <div key={carPart.id} className="container-list">
                <img
                  src={carPart.imageUrl}
                  alt={carPart.name}
                  className="image"
                />
                <div>
                  <h3>{carPart.name}</h3>
                  <p style={{ marginBottom: 15 }}>{carPart.description}</p>
                  <p>Quantity: {carPart.quantity}</p>
                </div>
                <div className="actions">
                  <FontAwesomeIcon
                    icon={faEdit}
                    onClick={() => update(carPart)}
                    className="edit"
                  />
                  <FontAwesomeIcon
                    icon={faTrash}
                    onClick={() => remove(carPart)}
                    className="remove"
                  />
                </div>
              </div>
            ))
          )}
        </ul>
      </div>
      {isEditModalOpen && (
        <EditModal
          isEditModalOpen={isEditModalOpen}
          setIsEditModalActive={setIsEditModalActive}
          basket={basket}
          setBasket={setBasket}
        />
      )}
      {isDeleteModalOpen && (
        <RemoveModal
          isDeleteModalOpen={isDeleteModalOpen}
          setIsDeleteModalActive={setIsDeleteModalActive}
          basket={basket}
          setBasket={setBasket}
        />
      )}
    </>
  );
};

export default Basket;
