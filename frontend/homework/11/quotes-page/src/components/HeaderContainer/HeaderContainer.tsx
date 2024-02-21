import React, { Dispatch, SetStateAction } from "react";
import { RotatingLines } from "react-loader-spinner";
import "./HeaderContainer.scss";

interface IHeaderContainerProps {
    isLoading: number;
    listOfFilters: Set<string>;
    setListOfFilters: Dispatch<SetStateAction<Set<string>>>;
    addNewQuote: () => void;
}

const HeaderContainer = ({
    isLoading,
    listOfFilters,
    setListOfFilters,
    addNewQuote,
}: IHeaderContainerProps) => {
    const onClickChangeHandler = (filter: string) => {
        setListOfFilters((prevState) => {
            const currentSet = new Set(prevState);
            currentSet.delete(filter);
            return currentSet;
        });
    };

    /**
     * Can break into another 2 components as filter component
     * and refresh button but wont make much difference as of now
     */

    return (
        <div className='header-container'>
            <button
                type='button'
                onClick={() => addNewQuote()}
                disabled={isLoading === 2}
                className='refresh-btn'
            >
                {isLoading === 2 ? (
                    <div className='loading'>
                        <p>New Quote</p>
                        <RotatingLines
                            visible={true}
                            width='27'
                            strokeColor='#0c359e'
                            strokeWidth='5'
                            animationDuration='0.75'
                            ariaLabel='rotating-lines-loading'
                        />
                    </div>
                ) : (
                    "New Quote"
                )}
            </button>
            <div className='filter-container'>
                <h1 className='filter-tag'>Filters</h1>

                {Array.from(listOfFilters).map((filter) => {
                    return (
                        <button
                            onClick={() => onClickChangeHandler(filter)}
                            key={filter}
                            className='filter-btn'
                        >
                            {filter} <span>X</span>
                        </button>
                    );
                })}
            </div>
            <hr />
        </div>
    );
};

export default HeaderContainer;
