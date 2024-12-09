import React from "react";
import './Play.css';

export const Play: React.FC = () => {
    return (
        <body>
        <div className="background-2">
            <div className="paper-background">
            <span>
                <div className= "screen-area">
                
                    <h1 className="Output">**************************************************<br>
                    </br>**************                      **************<br>
                    </br>              Welcome to numMeCrazy!<br>
                    </br>**************    ***********************************************                  **************
                    </h1>
                    <input className="input-section"></input>
                </div>
                <div className="buttons">
                    <button className="submit">
                        <a href="/play">Submit</a>
                    </button>
                    <button className="title-button">
                        <a href="/">Title Screen</a>
                    </button>
                </div>
                </span>
            </div>
        </div>
        </body>
    );
    }

export default Play;