import React, { useState, useEffect } from "react";
import planeImg from '../../assets/paper_plane_PNG6.png';

export const Home: React.FC = () => {
    const [isFlying, setIsFlying] = useState(false);

    useEffect(() => {
        // Function to start the animation at random intervals
        const startFlying = () => {
            setIsFlying(true);
            setTimeout(() => setIsFlying(false), 5000); // Reset after 5 seconds (animation duration)
        };

        // Random interval between 3 to 8 seconds
        const randomInterval = () => Math.random() * 5000 + 3000;

        // Set up the interval logic
        const interval = setInterval(() => {
            startFlying();
        }, randomInterval());

        // Cleanup interval on unmount
        return () => clearInterval(interval);
    }, []);

        return (
        <div className="background-2">
            <div className="paper-background">
                <img className={`plane ${isFlying ? "animate" : ""}`} src={planeImg} alt="Flying Plane" />
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