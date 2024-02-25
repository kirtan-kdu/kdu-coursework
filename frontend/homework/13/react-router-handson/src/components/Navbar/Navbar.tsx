import { ChangeEvent, useContext } from "react";
import { useStyles } from "./Navbar.styles";
import { FilterParamsContext } from "../../contexts/FilterParamsProvider";
import { ProductListContext } from "../../contexts/ProductListProvider";
import { capitalizeFirstLetter } from "../../utils/utils";

interface IProductsFilter {
    enableFilter: boolean;
}

const Navbar = ({ enableFilter }: IProductsFilter) => {
    const classes = useStyles();

    const { catagoryList } = useContext(ProductListContext);
    const { setSearchString, setCategoryFilter, setSortBy } =
        useContext(FilterParamsContext);
    function onSortByChangeHandler(
        event: ChangeEvent<HTMLSelectElement>
    ): void {
        setSortBy(event.target.value);
    }

    function onSearchChangeHandler(event: ChangeEvent<HTMLInputElement>): void {
        setSearchString(event.target.value);
    }

    function onCatagoryChangeHandler(
        event: ChangeEvent<HTMLSelectElement>
    ): void {
        setCategoryFilter(event.target.value);
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
                            <option value=''></option>
                            {catagoryList.map((category) => {
                                return (
                                    <option key={category} value={category}>
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
                            <option value='price'>Price</option>
                            <option value='rating'>Rating</option>
                            <option value='name'>Name</option>
                        </select>
                    </div>
                )}
            </div>
        </div>
    );
};

export default Navbar;
