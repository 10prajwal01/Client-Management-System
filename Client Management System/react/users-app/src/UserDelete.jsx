import React, { useState } from 'react';
import { useParams } from 'react-router-dom';
import axios from 'axios';
import { Link } from 'react-router-dom';

function UserDelete() {
  const { id } = useParams();
  const [user, setUser] = useState(null);
  const [searchId, setSearchId] = useState(id);
  const [successMessage, setSuccessMessage] = useState('');

  const handleSearch = () => {
    axios.get(`http://localhost:3500/s2/users/${searchId}`)
      .then(response => {
        setUser(response.data);
      })
      .catch(error => {
        console.error('Error fetching user:', error);
      });
  };

  const handleDelete = () => {
    axios.delete(`http://localhost:3500/s2/users/${searchId}`)
      .then(() => {
        console.log('User deleted');
        setSuccessMessage('User deleted successfully!');
        // Redirect to the user list page or display a success message
      })
      .catch(error => {
        console.error('Error deleting user:', error);
        // Display an error message to the user
      });
  };

  return (
    <div className="container">
      <div className="row justify-content-center">
        <div className="col-md-6">
          <div className="card mt-5">
            <div className="card-body">
            <h1><Link to="/home" className="card-title">Home Page</Link></h1>
              <h1 className="card-title">Delete User</h1>
              {successMessage && <div className="alert alert-success">{successMessage}</div>}
              <input
                type="text"
                onChange={e => setSearchId(e.target.value)}
                className="form-control mb-3"
                placeholder='id'
              />
              <button onClick={handleSearch} className="btn btn-primary mb-3">Search</button>
              {user && (
                <div>
                  <p>Username: {user.userName}</p>
                  <p>Email: {user.useremail}</p>
                  <p>Phone Number: {user.userphonenumber}</p>
                  <p>Age: {user.userage}</p>
                  <p>Info: {user.userinfo}</p>
                  <button onClick={handleDelete} className="btn btn-danger">Delete</button>
                </div>
              )}
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}

export default UserDelete;
