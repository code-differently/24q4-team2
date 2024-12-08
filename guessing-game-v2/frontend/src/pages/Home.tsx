import React from "react";
import '../components/header/Header.scss'

class Home extends React.Component{
    render() {
        return (
        <body>
        <div className="background-2">
            {/* <img src={`${process.env.PUBLIC_URL}/images/fb.jpg`} alt="Banner" />  */}
            {/* <div className="header-cta">
            <header className="header">    
                <a className="sign-up-button" href="#">
                Game Info
                </a>
            </header>     
            </div> */}
          
            <div className="paper-background">
              <div className="header-logo">
                  {/* <img src={logoImg} alt="num me crazy game" />  */}
              {/* </div> */}
                {/* <div className= "title-section">
                    <h1 className="Title">Welcome to<br/><em className="num">num</em><em className="Me">Me</em><em className="Crazy">Crazy</em></h1>
                </div> */}
                {/* <div className="buttons">
                    <button className="start">
                        Start
                    </button>
                    <button className="credits">Credits</button>
                </div> */}
               </div>
            </div>
        </div>
        </body>
        );
    }
}

export default Home;