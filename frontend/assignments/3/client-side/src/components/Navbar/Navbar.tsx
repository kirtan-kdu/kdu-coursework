import { Link } from "react-router-dom";
import StockMarketLogo from "../../assets/StockMarketLogo.svg";
import "./Navbar.scss";

const Navbar = () => {
    return (
        <nav className='navbar-container'>
            <div className='left-navbar'>
                <Link to='/'>
                    <img
                        className='stockmarket-logo'
                        src={StockMarketLogo}
                        alt='stockmarket logo'
                    />
                </Link>
                <h1 className='logo-text'>KDU Stock Market</h1>
            </div>
            <div className='right-navbar'>
                <Link className='summarizer-link nav-link' to='/summarizer'>
                    <div className='summarizer-link-text nav-link-text'>
                        Summarizer
                    </div>
                </Link>
                <Link className='my-portfolio-link nav-link' to='/portfolio'>
                    <div className='mu-portfolio-link-text nav-link-text'>
                        My Portfolio
                    </div>
                </Link>
            </div>
        </nav>
    );
};

export default Navbar;
