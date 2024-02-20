import React, { Dispatch, SetStateAction } from "react";
import "./SearchComponent.scss";
interface ISearchStringProp {
    setSearchString: Dispatch<SetStateAction<string>>;
}

const SearchComponent = ({ setSearchString }: ISearchStringProp) => {
    const handleSearch = (event: React.ChangeEvent<HTMLInputElement>) => {
        setSearchString(event.target.value);
        console.log(event.target.value);
    };

    return (
        <div className='search-container'>
            <input
                className='search-input'
                type='text'
                placeholder='Search items...'
                onChange={(event) => handleSearch(event)}
            />
        </div>
    );
};

export default SearchComponent;
