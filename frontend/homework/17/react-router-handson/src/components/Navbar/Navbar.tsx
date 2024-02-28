import { ChangeEvent } from "react";
import { useStyles } from "./Navbar.styles";
import { capitalizeFirstLetter } from "../../utils/utils";
import { useDispatch, useSelector } from "react-redux";
import { RootState } from "../../redux/Store";
import {
    setCategoryFilter,
    setSearchString,
    setSortBy,
} from "../../redux/FilterParamsSlice";

interface IProductsFilter {
    enableFilter: boolean;
}

const Navbar = ({ enableFilter }: IProductsFilter) => {
    const classes = useStyles();

    const { categoryFilter, searchString, sortBy } = useSelector(
        (state: RootState) => state.filterParamsReducer
    );
    const catagoryList = useSelector(
        (state: RootState) => state.productListReducer.catagoryList
    );

    const reduxDispatch = useDispatch();

    function onSortByChangeHandler(
        event: ChangeEvent<HTMLSelectElement>
    ): void {
        reduxDispatch(setSortBy(event.target.value));
    }

    function onSearchChangeHandler(event: ChangeEvent<HTMLInputElement>): void {
        reduxDispatch(setSearchString(event.target.value));
    }

    function onCatagoryChangeHandler(
        event: ChangeEvent<HTMLSelectElement>
    ): void {
        reduxDispatch(setCategoryFilter(event.target.value));
    }

    return (
        <div className={classes.navbarContainer}>
            <div className='navbar-wrapper'>
                <div className='input-container'>
                    <input
                        type='text'
                        placeholder='Search...'
                        className='search-input'
                        onChange={(event) => onSearchChangeHandler(event)}
                        value={searchString}
                    />
                    <span className='material-symbols-outlined'>Search</span>
                </div>
                {enableFilter && (
                    <div className='filter-container'>
                        <label htmlFor='catagory'>Catagory :</label>
                        <select
                            name='catagory'
                            title='Catagory'
                            onChange={(event) => onCatagoryChangeHandler(event)}
                        >
                            <option selected={true} value=''></option>
                            {catagoryList.map((category) => {
                                return (
                                    <option
                                        selected={category === categoryFilter}
                                        key={category}
                                        value={category}
                                    >
                                        {capitalizeFirstLetter(category)}
                                    </option>
                                );
                            })}
                        </select>
                        <label htmlFor='sort'>Sort by :</label>
                        <select
                            name='sort'
                            title='Sort by'
                            onChange={(event) => onSortByChangeHandler(event)}
                        >
                            <option value=''></option>
                            <option selected={"price" === sortBy} value='price'>
                                Price
                            </option>
                            <option
                                selected={"rating" === sortBy}
                                value='rating'
                            >
                                Rating
                            </option>
                            <option selected={"name" === sortBy} value='name'>
                                Name
                            </option>
                        </select>
                    </div>
                )}
            </div>
        </div>
    );
};

export default Navbar;
