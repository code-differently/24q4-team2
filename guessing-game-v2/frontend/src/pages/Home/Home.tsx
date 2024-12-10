import React from "react";

export const Home: React.FC = () => {
        return (
        <div className="background-2">
            <div className="paper-background">
                <div className= "title-section">
                    <h1 className="Title">Welcome to<br/><em className="num">num</em><em className="Me">Me</em><em className="Crazy">Crazy</em></h1>
                </div>
                <div className="buttons">
                    <button className="start">
                        <a href="/play">Start</a>
                    </button>
                    <button className="credits">Credits</button>
                </div>
            </div>
        </div>
        );
    }


export default Home;