import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { Link } from 'react-router-dom';

function UserList() {
  const [users, setUsers] = useState([]);
  const [noUsers, setNoUsers] = useState(false);

  useEffect(() => {
    axios.get('http://localhost:3500/s2/users')
      .then(response => {
        setUsers(response.data);
        if (response.data.length === 0) {
          setNoUsers(true);
        }
      })
      .catch(error => {
        console.error('Error fetching users:', error);
      });
  }, []);

  return (
    <div className="container">
      <div className="row justify-content-center">
        <div className="col-md-6">
          <div className="card mt-5">
            <div className="card-body">
            <h1><Link to="/home" className="card-title">Home Page</Link></h1>
              <h1 className="card-title">User List</h1>
              {noUsers ? (
                <p>No users found.</p>
              ) : (
                <ul className="list-group">
                  {users.map(user => (
                    <li key={user.id} className="list-group-item">
                      {user.id} - {user.userName} - {user.useremail}
                    </li>
                  ))}
                </ul>
              )}
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}

export default UserList;
