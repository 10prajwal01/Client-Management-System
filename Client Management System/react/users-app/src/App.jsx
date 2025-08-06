// App.js
import React from 'react';
import { Route, Routes } from 'react-router-dom';
import UserList from './UserList';
import UserDetail from './UserDetail';
import UserCreate from './UserCreate';
import UserUpdate from './UserUpdate';
import UserDelete from './UserDelete';

import Home from './Home';
import "./index.css";
import LoginPage from './LoginPage';

function App() {
  return (
    <div className="p-4">
    <Routes>
      <Route path="/" element={<LoginPage />} />
      <Route path="/home" element={<Home />} />
      <Route path="/all" element={<UserList />} />
      <Route path="/create" element={<UserCreate />} />
      <Route path="/detail/:id" element={<UserDetail />} />
      <Route path="/update/:id" element={<UserUpdate />} />
      <Route path="/delete/:id" element={<UserDelete />} />
    </Routes>
  </div>
  );
}

export default App;
