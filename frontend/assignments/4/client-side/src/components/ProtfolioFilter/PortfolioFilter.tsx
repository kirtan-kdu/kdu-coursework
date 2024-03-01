import React from "react";

const PortfolioFilter = () => {
    const handleFocus = (e: React.FocusEvent<HTMLInputElement>) => {
        e.target.type = "date";
    };

    const handleBlur = (e: React.FocusEvent<HTMLInputElement>) => {
        if (!e.target.value) {
            e.target.type = "text";
            e.target.placeholder = "Enter a date";
        }
    };

    return (
        <section>
            <div>
                <h1>Filter</h1>
                <h1>Clear All</h1>
            </div>
            <div>
                <input placeholder='Search for a stock' type='text' />
            </div>
            <div>
                <label htmlFor='startDate'>Start : </label>
                <input placeholder='startDate' type='date' name='startDate' />
                <label htmlFor='endDate'> End : </label>
                <input placeholder='endDate' type='date' name='endDate' />
            </div>
        </section>
    );
};

export default PortfolioFilter;
