import React, { Dispatch, SetStateAction } from "react";
import { ApiQuote } from "../../types/quotes.types";
import "./Quote.scss";

interface IQuoteProp {
    quote: ApiQuote;
    setListOfFilters: Dispatch<SetStateAction<Set<string>>>;
}
const Quote = ({ quote, setListOfFilters }: IQuoteProp) => {
    const onFilterChangeHandler = (tag: string) => {
        setListOfFilters((prevState) => new Set(prevState.add(tag)));
    };

    return (
        <div className='quote-container'>
            <h2 className='quote-content'>{quote.content}</h2>
            <p className='quote-author'>~ {quote.author}</p>
            <p className='quote-dateadded'>{quote.dateAdded}</p>
            <div className='quote-tag-container'>
                {quote.tags.map((tag) => {
                    return (
                        <button
                            className='quote-tag'
                            key={tag}
                            onClick={() => onFilterChangeHandler(tag)}
                        >
                            {tag}
                        </button>
                    );
                })}
            </div>
        </div>
    );
};

export default Quote;
