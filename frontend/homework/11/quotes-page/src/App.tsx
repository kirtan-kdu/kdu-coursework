import React, { useEffect, useState } from "react";
import "./App.scss";
import { ApiQuote } from "./types/quotes.types";
import QuoteList from "./components/QuoteList/QuoteList";
import HeaderContainer from "./components/HeaderContainer/HeaderContainer";

function App() {
    const [isLoading, setIsLoading] = useState<number>(1);
    const [listOfQuotes, setListOfQuotes] = useState<ApiQuote[]>([]);
    const [listOfFilters, setListOfFilters] = useState<Set<string>>(
        new Set<string>()
    );

    const addNewQuote = async () => {
        setIsLoading(2);
        await fetch("https://api.quotable.io/quotes/random?limit=1")
            .then((response) => response.json())
            .then((response) =>
                setListOfQuotes([...response, ...listOfQuotes])
            );
        setIsLoading(3);
    };

    const fetchQuotes = async () => {
        const response = await fetch(
            "https://api.quotable.io/quotes/random?limit=3"
        );
        const data = await response.json();
        setListOfQuotes(data);
        setIsLoading(3);
    };

    useEffect(() => {
        fetchQuotes();
    }, []);

    return (
        <div className='main-container'>
            {isLoading === 1 ? (
                <div className='spinner'></div>
            ) : (
                <div className='wrapper'>
                    <HeaderContainer
                        isLoading={isLoading}
                        listOfFilters={listOfFilters}
                        setListOfFilters={setListOfFilters}
                        addNewQuote={addNewQuote}
                    ></HeaderContainer>
                    <QuoteList
                        listOfFilters={listOfFilters}
                        listOfQuotes={listOfQuotes}
                        setListOfFilters={setListOfFilters}
                    ></QuoteList>
                </div>
            )}
        </div>
    );
}

export default App;
