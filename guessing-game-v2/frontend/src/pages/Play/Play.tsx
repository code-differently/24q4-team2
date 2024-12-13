import React, { useState, useEffect } from "react";
import './Play.css';
import numMeCrazyDude from '../../assets/numMeCrazyDude.png';

export const Play: React.FC = () => {
  const [inputText, setInputText] = useState('');
  const [response, setResponse] = useState('');
  const [gameId, setGameId] = useState('');
  const [targetNumber, setTargetNumber] = useState<number | null>(null); 

  useEffect(() => {
    const initializeGame = async () => {
      try {
        const res = await fetch('http://localhost:5137/start', {
          method: 'POST'
        });
        const data = await res.text();
        setGameId(data);
        const targetNum = parseInt(data); // Adjust this based on actual response
        if (!isNaN(targetNum)) {
          setTargetNumber(targetNum);
        }
      } catch (error) {
        console.error("Error starting game:", error);
      }
    };
      

    

    initializeGame();
  }, []); // Removed nested useEffect, corrected single useEffect

  const handleInputChange = (event: React.ChangeEvent<HTMLInputElement>) => {
    setInputText(event.target.value);
  };

  const sendGuess = async (guess: string) => {
    try {
        if(parseInt(guess) === targetNumber) {
          setResponse("You Win!!!")
        }
      const res = await fetch(`http://localhost:8081/guess`, {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify({ text: inputText, gameId: gameId }), // Corrected JSON stringify
      });
      const data = await res.text();
      setResponse(prevresponse => prevresponse + "\n" + data);
    } catch (error) {
      console.error("Error:", error);
    }
  };

  return (
    <div className="background-2"> {/* Replaced <body> with <div> */}
      <div className="paper-background">
        <span>
          <div className="screen-area">
            <h1 className="Output">{response}</h1>
          </div>
          <div className="buttons">
            <input
              className="input-section"
              type="text"
              value={inputText}
              onChange={handleInputChange}
              placeholder="Enter Response Here"
            />
            <button className="submit" onClick={() => sendGuess("guess")}>Submit</button>
            <button className="title-button">
              <a href="/">Title Screen</a>
            </button>
          </div>
          <img className="nMCDude" src={numMeCrazyDude} alt="numMeCrazyBoy" width="500" />
        </span>
      </div>
    </div>
  );
}

export default Play;