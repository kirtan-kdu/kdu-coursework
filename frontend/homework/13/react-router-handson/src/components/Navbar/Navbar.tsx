import { useStyles } from "./Navbar.styles";

interface IProductsFilter {
    enableFilter: boolean;
}

const Navbar = ({ enableFilter }: IProductsFilter) => {
    const classes = useStyles();

    return (
        <div className={classes.navbarContainer}>
            <div className='navbar-wrapper'>
                <div className='input-container'>
                    <input
                        type='text'
                        placeholder='Search...'
                        className='search-input'
                    />
                    <span className='material-symbols-outlined'>Search</span>
                </div>
                {enableFilter && (
                    <div className='filter-container'>
                        <label htmlFor='catagory'>Catagory :</label>
                        <select name='catagory' title='Catagory'>
                            <option value='mobile'>Mobile</option>
                            <option value='laptop'>Laptop</option>
                        </select>
                        <label htmlFor='sort'>Sort by :</label>
                        <select name='sort' title='Sort by'>
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
