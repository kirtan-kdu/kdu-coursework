import React, { Dispatch, SetStateAction } from "react";
import Quote from "../Quote/Quote";
import { ApiQuote } from "../../types/quotes.types";
import "./QuoteList.scss";
interface IQuoteListProp {
    listOfQuotes: ApiQuote[];
    listOfFilters: Set<string>;
    setListOfFilters: Dispatch<SetStateAction<Set<string>>>;
}

const QuoteList = ({
    listOfQuotes,
    listOfFilters,
    setListOfFilters,
}: IQuoteListProp) => {
    return (
        <div className='quotes-list-container'>
            {listOfQuotes
                .filter(
                    (quote) =>
                        listOfFilters.size === 0 ||
                        Array.from(listOfFilters).every((filter) =>
                            quote.tags.includes(filter)
                        )
                )
                .map((quote) => {
                    return (
                        <Quote
                            key={quote._id}
                            quote={quote}
                            setListOfFilters={setListOfFilters}
                        />
                    );
                })}
        </div>
    );
};

export default QuoteList;
