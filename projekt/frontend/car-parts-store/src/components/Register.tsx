import React, { useEffect, useState } from "react";
import "styles/profile.css";
import { Link } from "react-router-dom";

interface Profile {
  name: string;
  password: string;
  email: string;
}

function Register() {
  const [profile, setProfile] = useState<Profile>({
    name: "",
    password: "",
    email: "",
  });

  // useEffect(() => {
  //   const fetchData = async () => {
  //     try {
  //       const response = await fetch("http://localhost:8080/products/profile");
  //       const json = await response.json();
  //       setProfile(json);
  //     } catch (_err) {
  //       console.log(_err);
  //     }
  //   };
  //   fetchData();
  // }, [])
  // ;

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const response = await fetch("http://localhost:8080/profile/add", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(profile),
      });
      const json = await response.json();
      console.log(json);
    } catch (_err) {
      console.log(_err);
    }
    console.log(profile);
  };

  const onChange = (e) => {
    setProfile({ ...profile, [e.target.name]: e.target.value } as any);
  };

  return (
    <>
      {/*<h3>Hello {profile.name} {profile.surname}</h3>*/}

      <Link to="/">Back</Link>
      <h1>Register</h1>

      <div className="new-cart-container">
        <h3 className="cart-title">Register</h3>
        <form className="addNewCart-form" onSubmit={handleSubmit}>
          <input
            type="text"
            placeholder="name"
            name="name"
            onChange={onChange}
          />
          <input
            type="text"
            placeholder="email"
            name="email"
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
      </div>
    </>
  );
}

export default Register;
