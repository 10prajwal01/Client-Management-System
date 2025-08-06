import React, { useState } from 'react';
import axios from 'axios';
import { Link } from 'react-router-dom';

function UserCreate() {
  const [user, setUser] = useState({
    userName: '',
    useremail: '',
    userphonenumber: '',
    userage: 0,
    userinfo: '',
    password: '',
  });
  const [successMessage, setSuccessMessage] = useState('');

  const handleChange = e => {
    setUser({ ...user, [e.target.name]: e.target.value });
  };

  const handleSubmit = e => {
    e.preventDefault();

    axios.post('http://localhost:3500/s2/users', user)
      .then(response => {
        console.log('User created:', response.data);
        setSuccessMessage('User created successfully!');
        // Redirect to the user list page or display a success message
      })
      .catch(error => {
        console.error('Error creating user:', error);
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
              <h1 className="card-title">Create User</h1>
              {successMessage && <div className="alert alert-success">{successMessage}</div>}
              <form onSubmit={handleSubmit}>
                <div className="mb-3">
                  <label htmlFor="username" className="form-label">Username:</label>
                  <input
                    type="text"
                    id="username"
                    name="userName"
                    value={user.userName}
                    onChange={handleChange}
                    className="form-control"
                  />
                </div>
                <div className="mb-3">
                  <label htmlFor="email" className="form-label">Email:</label>
                  <input
                    type="email"
                    id="email"
                    name="useremail"
                    value={user.useremail}
                    onChange={handleChange}
                    className="form-control"
                  />
                </div>
                <div className="mb-3">
                  <label htmlFor="phone" className="form-label">Phone Number:</label>
                  <input
                    type="text"
                    id="phone"
                    name="userphonenumber"
                    value={user.userphonenumber}
                    onChange={handleChange}
                    className="form-control"
                  />
                </div>
                <div className="mb-3">
                  <label htmlFor="age" className="form-label">Age:</label>
                  <input
                    type="number"
                    id="age"
                    name="userage"
                    value={user.userage}
                    onChange={handleChange}
                    className="form-control"
                  />
                </div>
                <div className="mb-3">
                  <label htmlFor="info" className="form-label">Info:</label>
                  <input
                    type="text"
                    id="info"
                    name="userinfo"
                    value={user.userinfo}
                    onChange={handleChange}
                    className="form-control"
                  />
                </div>
                <div className="mb-3">
                  <label htmlFor="password" className="form-label">Password:</label>
                  <input
                    type="password"
                    id="password"
                    name="password"
                    value={user.password}
                    onChange={handleChange}
                    className="form-control"
                  />
                </div>
                <button type="submit" className="btn btn-primary">Create</button>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}

export default UserCreate;
