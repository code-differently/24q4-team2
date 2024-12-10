import React from "react";
import './Play.css';
import numMeCrazyDude from '../../assets/numMeCrazyDude.png';

export const Play: React.FC = () => {
    return (
        <body>
        <div className="background-2">
            <div className="paper-background">
            <span>
                <div className= "screen-area">
                
                    <h1 className="output">
                        **************************************************<br>
                    </br>**************&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;**************<br>
                    </br>************** Welcome to numMeCrazy! **************<br>
                    </br>**************    ************** **************<br>
                    </br>**************************************************
                    </h1>
                </div>
                <div className="buttons">
                    <input className="input-section"></input>
                    <button className="submit">
                        <a href="">Submit</a>
                    </button>
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