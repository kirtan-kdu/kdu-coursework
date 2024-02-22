import React, { useContext } from "react";
import "./SearchComponent.scss";
import { SearchInputContext } from "../../../contexts/SearchInputProvider";

const SearchComponent = () => {
    const { setSearchInput } = useContext(SearchInputContext);

    const handleSearch = (event: React.ChangeEvent<HTMLInputElement>) => {
        setSearchInput(event.target.value);
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
