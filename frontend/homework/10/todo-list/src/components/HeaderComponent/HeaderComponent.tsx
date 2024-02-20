import React, { Dispatch, SetStateAction } from "react";
import SearchComponent from "./SearchContainer/SearchComponent";
import "./HeaderComponent.scss";
interface ISearchStringProp {
    setSearchString: Dispatch<SetStateAction<string>>;
}

const HeaderComponent = ({ setSearchString }: ISearchStringProp) => {
    return (
        <div className='heading-wrapper'>
            <div className='heading-container'>
                <h1 className='heading-tag'>Item Lister</h1>
                <SearchComponent
                    setSearchString={setSearchString}
                ></SearchComponent>
            </div>
        </div>
    );
};

export default HeaderComponent;
