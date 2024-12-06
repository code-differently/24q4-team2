import Home from "./pages/Home/Home";
import Header from "./components/Header";
import { useEffect, useState } from 'react';
import {Outlet} from 'react-router-dom';

import reactLogo from './assets/numMeIcon.svg'
import viteLogo from '/vite.svg'
import './App.css'
import { Blog } from './components/Blog'


function App() {
  const [message, setMessage] = useState('');

  useEffect(() => {
    // Fetch data from the Spring Boot API
    fetch('http://localhost:8080/hello')
      .then(response => response.text())
      .then(data => setMessage(data))
      .catch(error => console.error('Error fetching data:', error));
  }, []);

  return (
    <>
      <Header />
      <div className="main">
        <div className="content">
          <Outlet />
        </div>
      </div>
    </>
  )
}

export default App
