// Navigation.js
import React from 'react';
import { Link } from 'react-router-dom';

function Navigation() {
  return (
    <nav>
      <ul>
        <li><Link to="/">User List</Link></li>
        <li><Link to="/users/create">Create User</Link></li>
      </ul>
    </nav>
  );
}

export default Navigation;
