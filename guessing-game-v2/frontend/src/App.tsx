import Home from "./pages/Home";
import Header from "./components/Header";
import { useEffect, useState } from 'react';

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
    <div>
      <Header />
      <Home />
    </div>
    </>
  )
}

export default App
