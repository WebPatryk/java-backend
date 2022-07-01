import React, { useEffect, useState } from "react";
import "styles/modal.css";

const RemoveModal = ({ isDeleteModalOpen, setIsDeleteModalActive }) => {
  const remove = async () => {
    try {
      const response = await fetch(
        `http://localhost:8080/basket/delete/${isDeleteModalOpen.id}`,
        {
          method: "DELETE",
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
    setIsDeleteModalActive(false);
  };
  return (
    <div className="modal">
      <h3>Remove part </h3>
      <p>Are you sure you want to remove this thing?</p>
      <div>
        <button
          onClick={() => setIsDeleteModalActive(false)}
          className="update"
        >
          Close
        </button>
        <button onClick={remove} className="delete">
          Delete
        </button>
      </div>
    </div>
  );
};

export default RemoveModal;
