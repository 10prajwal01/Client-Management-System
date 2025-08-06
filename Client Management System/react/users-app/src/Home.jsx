import React from 'react';
import { Link } from 'react-router-dom';

function Home() {
  return (
    <div className="container">
      <div className="row justify-content-center">
        <div className="col-md-6">
          <div className="card mt-5">
            <div className="card-body">
            <h1><Link to="/home" className="card-title">Home Page</Link></h1>
              <ul className="list-group list-group-flush">
                <li className="list-group-item">
                  <Link to="/all" className="btn btn-primary">User List</Link>
                </li>
                <li className="list-group-item">
                  <Link to="/create" className="btn btn-primary">Create User</Link>
                </li>
                <li className="list-group-item">
                  <Link to="/detail/:id" className="btn btn-primary">User Detail</Link>
                </li>
                <li className="list-group-item">
                  <Link to="/update/:id" className="btn btn-primary">User Update</Link>
                </li>
                <li className="list-group-item">
                  <Link to="/delete/:id" className="btn btn-primary">User Delete</Link>
                </li>
              </ul>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}

export default Home;
