import React from "react";

export const Play: React.FC = () => {
    return (
        <body>
        <div className="background-2">
            <div className="paper-background">
                <div className= "title-section">
                    <h1 className="Title">Welcome to<br/><em className="num">num</em><em className="Me">Me</em><em className="Crazy">Crazy</em></h1>
                </div>
                <div className="buttons">
                    <button className="start">
                        <a href="/play">Start</a>
                    </button>
                    <button className="credits">
                        <a href="/">Title Screen</a>
                    </button>
                </div>
            </div>
        </div>
        </body>
    );
    }

export default Play;