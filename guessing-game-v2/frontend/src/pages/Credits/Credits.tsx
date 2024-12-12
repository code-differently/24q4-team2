import React from "react";
import credits from '../../assets/credits.png';

export const Credits: React.FC = () => {
    return (
        <div className="background-2">
            <div className="paper-background">
                <div className="buttons">
                    <img className="credit-names" src={credits} alt="credits" width="700" />
                    <button className="title-button2">
                        <a href="/">Title Screen</a>
                    </button>
                </div>
            </div>
        </div>
    );
    }

export default Credits;