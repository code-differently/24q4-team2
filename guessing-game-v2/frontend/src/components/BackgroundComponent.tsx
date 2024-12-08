import React, { useEffect, useState } from 'react';
import './BackgroundComponent.scss';

const BackgroundComponent = () => {
  const [isBackgroundVisible, setIsBackgroundVisible] = useState(false);
  const [response, setResponse] = useState("");

  useEffect(() => {
    // Set a timer to show the background after 60 seconds
    const timer = setTimeout(() => {
      setIsBackgroundVisible(true);
    }, 120000); // 60,000 milliseconds = 60 seconds

    // Cleanup the timer when the component unmounts
    return () => clearTimeout(timer);
  }, []);

  const sendData = async (buttonId:string) => {
    try {
      const res = await fetch(`http://localhost:8080/${buttonId}`, {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(buttonId),
      });

      const data = await res.text();
      setResponse(data);
    } catch (error) {
      console.error("Error:", error);
    }
  };

  return (
    <>
    <div
      style={{
        width: '100vw',
        height: '50vh',
        transition: 'background-image 1s ease-in-out', // Smooth transition
        backgroundImage: isBackgroundVisible
          ? 'url("https://www.istockphoto.com/vector/christmas-background-gm118366872-10629463")' // Replace with your image URL
          : 'none',
        backgroundSize: 'cover',
        backgroundPosition: 'center',
        position: 'absolute',
        top: 0,
        left: 0,
      }}
    >
  
      <h1 style={{ fontFamily: 'sans-serif', fontSize: 50, fontWeight: 'bold',  color: 'darkgreen', textAlign: 'right', marginTop: '2%', marginRight: '6%' }}>
        Welcome to Number Guessing Game!
      </h1>
      
      <div style={{ marginLeft: '1px', fontSize : 40, fontWeight: 'bold', color: 'darkgreen', textAlign: 'end', marginRight: '6%' }}>
        Enter a name: <input type="text" name="guess" id="guess"  placeholder="Enter a player name" />
      </div>
      <div style={{ marginLeft: '1px', fontSize : 40, fontWeight: 'bold', color: 'darkgreen', textAlign: 'end',  marginRight: '6%' }}>
        Choose Difficulty Level: <input type="text" name="level" id="level"  placeholder="choose difficulty level" />
      </div>

      <div style={{ marginLeft: '2px', fontSize : 20, fontWeight: 'bold', color: 'darkgreen', textAlign: 'right', marginRight: '6%' }}>
        <button  onClick={() => sendData("easy")}>Easy</button>
        <button  onClick={() => sendData("medium")}>Medium</button>
        <button  onClick={() => sendData("hard")}>Hard</button>
      </div>

      <div style={{ margin: '6px', fontSize : 40, fontWeight: 'bold', color: 'pink', textAlign: 'right', marginTop: '2%', marginRight: '6%' }}>
        <button  style={{ margin: '6px'}} onClick={() => sendData("hard")}>submit</button>
      </div> 
    
    
    <div>
      <h2>Response:</h2>
      <p>{response}</p>
    </div>
  </div>
  </>
  );
};

export default BackgroundComponent;
