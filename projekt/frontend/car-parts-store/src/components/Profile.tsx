import React, { useEffect, useState } from "react";
import "styles/profile.css";
import { Link } from "react-router-dom";

interface Profile {
  name: string;
  password: string;
}

function Profile() {
  const [profile, setProfile] = useState<Profile>({ name: "", password: "" });
  const [allProfiles, setAllProfiles] = useState(null);
  const [isLoggin, setIsLoggin] = useState(false);

  useEffect(() => {
    async function fetchUsers() {
      try {
        const response = await fetch("http://localhost:8080/profile/getAll", {
          method: "GET",
          headers: {
            "Content-Type": "application/json",
          },
        });
        const json = await response.json();
        setAllProfiles(json);
        console.log(json);
      } catch (_err) {
        console.log(_err);
      }
    }
    fetchUsers();
  }, []);

  const handleSubmit = (e) => {
    e.preventDefault();

    const data = allProfiles.filter(
      (item) => item.name === profile.name && item.password === profile.password
    );
    console.log(data);
    if (data) {
      console.log("we have user");
      localStorage.setItem("isUserLogged", JSON.stringify(data));
    }
  };

  useEffect(() => {
    if (localStorage.getItem("isUserLogged")) {
      setIsLoggin(true);
    }
  }, [localStorage.getItem("isUserLogged")]);

  const onChange = (e) => {
    setProfile({ ...profile, [e.target.name]: e.target.value } as any);
  };

  const logOut = () => {
    localStorage.removeItem("isUserLogged");
  };

  return (
    <>
      <Link to="/" style={{ fontSize: 20, margin: 50 }}>
        Back
      </Link>
      {!isLoggin ? (
        <div className="new-cart-container">
          <h3 className="cart-title">Login</h3>
          <form className="addNewCart-form" onSubmit={handleSubmit}>
            <input
              type="text"
              placeholder="name"
              name="name"
              onChange={onChange}
            />
            <input
              type="password"
              placeholder="password"
              name="password"
              onChange={onChange}
            />

            <button type="submit">Submit</button>
          </form>
          <Link to="/register">Register</Link>
        </div>
      ) : (
        <div>
          <p>Profile</p>
          <p>Hello {JSON.parse(localStorage.getItem("isUserLogged")).name}</p>
          <button onClick={logOut}>Logout</button>
        </div>
      )}
    </>
  );
}

export default Profile;
