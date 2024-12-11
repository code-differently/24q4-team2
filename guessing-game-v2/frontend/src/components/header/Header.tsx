import './Header.scss';
//import logoImg from '/../../assets/funnyboy.jpg';
import logoImg from '../../assets/FunnyBoy.jpg';

const Header: React.FC = () => {
  return (
    <header className="header">
      <div className="header-logo">
        <a href="/">
         <img src={logoImg} alt="num me crazy game" /> 
        </a>
      </div>
      
      <div className="header-cta">
        <a className="sign-up-button" href="#">
          Sign Up
        </a>
      </div>
    </header>
  );
};

export default Header;