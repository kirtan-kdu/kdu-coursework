import "./SearchComponent.scss";
import { useDispatch } from "react-redux";
import { changeInput } from "../../../redux/SearchInputSlice";

const SearchComponent = () => {
    const reduxDispatch = useDispatch();

    const handleSearch = (event: React.ChangeEvent<HTMLInputElement>) => {
        reduxDispatch(changeInput(event.target.value));
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
