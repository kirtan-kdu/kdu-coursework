import React, { useContext } from "react";
import { ThemeContext, IContext } from "./ThemeContext";
import "./Wrapper.scss";

const Wrapper = () => {
    const { theme, toggleTheme } = useContext<IContext>(ThemeContext);
    return (
        <>
            <button onClick={toggleTheme}>Change Theme</button>
            <div className={`toggle-div ${theme}`}>
                This division will be changed
            </div>
        </>
    );
};

export default Wrapper;
