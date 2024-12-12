import React, {useEffect, useState} from "react";
import './Play.css';
import numMeCrazyDude from '../../assets/numMeCrazyDude.png';

export const Play: React.FC = () => {
    const [inputText, setInputText] = useState('');
    const [response, setResponse] = useState('');
    const [gameId, setGameId] = useState('');

    useEffect(() => {
      const startGame = async () => {
        const res = await fetch(`http://localhost:8081/games`, {
          method: "POST",
          headers: {
            "Content-Type": "application.json",
          },
          body: JSON.stringify({}),
        });
      };
      startGame();
    }, []);

    const handleInputChange = (event:any) => {
        setInputText(event.target.value);
      };

      const sendGuess = async (guess:string) => {
        try {
          const res = await fetch(`http://localhost:8081/guess`, {
            method: "POST",
            headers: {
              "Content-Type": "application/json",
            },
            body: JSON.stringify(({ text: inputText, gameId })),
          });
    
          const data = await res.text();
          setResponse(response + "\n" + data);
        } catch (error) {
          console.error("Error:", error);
        }
      };
  
    return (
        <body>
        <div className="background-2">
            <div className="paper-background">
            <span>
                <div className= "screen-area">
                <h1 className="Output">{response}</h1>
                </div>
                <div>
        {/* <input
            type="text"
            value={inputText}
            onChange={handleInputChange}
            placeholder="Enter some text"
        /> */}
        {/* <button  onClick={() => sendGuess("guess")}>submitGuess</button> */}
        {/* <div>
            <p className="response">{response}</p>
        </div> */}
    </div>
      <div className="buttons">
          {/* <input className="input-section"></input> */}
          <input
          className="input-section"
            type="text"
            value={inputText}
            onChange={handleInputChange}
            placeholder="Enter Response Here"
        />

                    {/* <button className="submit">
                        <a href="">Submit</a>
                    </button> */}
                    <button  className="submit" onClick={() => sendGuess("guess")}>Submit</button>
                    <button className="title-button">
                        <a href="/">Title Screen</a>
                    </button>
                </div>
                <img className="nMCDude" src={numMeCrazyDude} alt="numMeCrazyBoy" width="500" />
                </span>
            </div>
        </div>
        </body>
    );
    }

export default Play;