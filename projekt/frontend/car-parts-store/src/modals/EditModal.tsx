import React, { useEffect, useState } from "react";
import "styles/modal.css";

const EditModal = ({ isEditModalOpen, setIsEditModalActive,basket,setBasket }) => {
  const [data, setData] = useState(isEditModalOpen);

  const handleSubmit = async (e) => {
    e.preventDefault()
    console.log(data)
    try {
      const response = await fetch(
        `http://localhost:8080/basket/update/${isEditModalOpen.id}`,
        {
          method: "PUT",
          headers: {
            "Content-Type": "application/json",
          },
          body: JSON.stringify(data),
        }
      );
      const json = await response.json();
      const index = basket.findIndex((item) => item.id === json.id);
      const newBasket = [...basket];
      newBasket[index] = json;
      setBasket(newBasket);
    } catch (_err) {
      console.log(_err);
    }
    setIsEditModalActive(false);
  };

  return (
    <div className="capture-body">
      <div className="modal">
        <h3>Edit </h3>
        <p>Are you sure you want to edit this thing?</p>
        <form onSubmit={handleSubmit}>
          <input
            type="number"
            placeholder="Quantity"
            onChange={(e) => setData({ ...data, quantity: e.target.valueAsNumber })}
          />
          <div>
            <button
              onClick={() => setIsEditModalActive(false)}
              className="update"
            >
              Close
            </button>
            <button type="submit" className="save">
              Update
            </button>
          </div>
        </form>
      </div>
    </div>
  );
};

export default EditModal;
