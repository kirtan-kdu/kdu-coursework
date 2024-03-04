import { Link } from "react-router-dom";
import StockMarketLogo from "../../assets/StockMarketLogo.svg";
import { createUseStyles } from "react-jss";
import styles from "./NavbarStyles";
import { useState } from "react";

const Navbar = () => {
    const [showHampurgerMenu, setShowHampurgerMenu] = useState(false);
    const useStyles = createUseStyles(styles);
    const classes = useStyles();
    const handleHamburgerChange = () => {
        setShowHampurgerMenu(!showHampurgerMenu);
    };
    return (
        <nav className={classes.navbarContainer}>
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
                <i className='fa fa-bars' onClick={handleHamburgerChange}></i>
                <Link
                    className={`summarizer-link nav-link ${
                        showHampurgerMenu ? "show-menu" : "disable-menu"
                    }`}
                    to='/summarizer'
                >
                    <div className='summarizer-link-text nav-link-text'>
                        Summarizer
                    </div>
                </Link>
                <Link
                    className={`my-portfolio-link nav-link ${
                        showHampurgerMenu ? "show-menu" : "disable-menu"
                    }`}
                    to='/portfolio'
                >
                    <div className='mu-portfolio-link-text nav-link-text'>
                        My Portfolio
                    </div>
                </Link>
            </div>
        </nav>
    );
};

export default Navbar;
