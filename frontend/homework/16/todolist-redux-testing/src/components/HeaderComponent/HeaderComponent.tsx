import SearchComponent from "./SearchContainer/SearchComponent";
import "./HeaderComponent.scss";

const HeaderComponent = () => {
    return (
        <div className='heading-wrapper'>
            <div className='heading-container'>
                <h1 className='heading-tag'>Item Lister</h1>
                <SearchComponent />
            </div>
        </div>
    );
};

export default HeaderComponent;
