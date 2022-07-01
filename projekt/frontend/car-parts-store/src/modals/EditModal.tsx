import React, { useEffect, useState } from "react";
import "styles/modal.css";

const EditModal = ({ isEditModalOpen, setIsEditModalActive }) => {
  const update = async () => {
    try {
      const response = await fetch(
        `http://localhost:8080/basket/update/${isEditModalOpen.id}`,
        {
          method: "PUT",
          headers: {
            "Content-Type": "application/json",
          },
        }
      );
      const json = await response.json();
      console.log(json);
    } catch (_err) {
      console.log(_err);
    }
    setIsEditModalActive(false);
  };
  return (
    <div className="modal">
      <h3>Edit </h3>
      <p>Are you sure you want to edit this thing?</p>
      <input type="number" placeholder="quantity" />
      <div>
        <button onClick={() => setIsEditModalActive(false)}>Close</button>
        <button onClick={update}>update</button>
      </div>
    </div>
  );
};

export default EditModal;
