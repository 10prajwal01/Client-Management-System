import React, { useState } from 'react';
import { useParams } from 'react-router-dom';
import axios from 'axios';
import { Link } from 'react-router-dom';

function UserDetail() {
  const { id } = useParams();
  const [user, setUser] = useState(null);
  const [searchId, setSearchId] = useState(id);

  const handleSearch = () => {
    axios.get(`http://localhost:3500/s2/users/${searchId}`)
      .then(response => {
        setUser(response.data);
      })
      .catch(error => {
        console.error('Error fetching user:', error);
      });
  };

  return (
    <div className="container">
      <div className="row justify-content-center">
        <div className="col-md-6">
          <div className="card mt-5">
            <div className="card-body">
            <h1><Link to="/home" className="card-title">Home Page</Link></h1>
              <h1 className="card-title">User Detail</h1>
              <input
                type="text"
                onChange={e => setSearchId(e.target.value)}
                className="form-control mb-3"
                placeholder='id'
              />
              <button onClick={handleSearch} className="btn btn-primary mb-3">Search</button>
              {user && (
                <>
                  <p>Username: {user.userName}</p>
                  <p>Email: {user.useremail}</p>
                  <p>Phone Number: {user.userphonenumber}</p>
                  <p>Age: {user.userage}</p>
                  <p>Info: {user.userinfo}</p>
                </>
              )}
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}

export default UserDetail;
