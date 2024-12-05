import React from "react";

class Home extends React.Component{
    render() {
        return (
        <body>
        <div className="background-2">
            <div className="paper-background">
                <div className= "title-section">
                    <h1 className="Title">Welcome to<br/><em className="num">num</em><em className="Me">Me</em><em className="Crazy">Crazy</em></h1>
                </div>
                <div className="buttons">
                    <button className="start">
                        Start
                    </button>
                    <button className="credits">Credits</button>
                </div>
            </div>
        </div>
        </body>
        );
    }
}

export default Home;