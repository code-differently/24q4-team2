import { useEffect, useState } from 'react';

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
    <div className="App">
      <h1>{message || 'Loading...'}</h1>
    </div>
  );
}

export default App;
