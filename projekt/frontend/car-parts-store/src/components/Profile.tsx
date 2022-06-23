import React, { useEffect, useState } from "react";
import "styles/profile.css";
import { Link } from "react-router-dom";

interface Profile {
  userID: string;
  name: number;
  surname: string;
  email: string;
}

function Profile() {
  const [profile, setProfile] = useState<Profile>(null);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await fetch("http://localhost:8080/products/profile");
        const json = await response.json();
        setProfile(json);
      } catch (_err) {
        console.log(_err);
      }
    };
    fetchData();
  }, []);

  return (
    <>
      {/*<h3>Hello {profile.name} {profile.surname}</h3>*/}

      <Link to="/">Back</Link>
      <h1>Title</h1>
      <p>Welcome in app where you can buy many of car parts!</p>
    </>
  );
}

export default Profile;
