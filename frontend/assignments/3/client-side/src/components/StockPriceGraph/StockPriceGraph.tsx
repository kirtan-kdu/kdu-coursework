import BarGraph from "./BarGraph";
import "bootstrap/dist/css/bootstrap.min.css";

import "./StockPriceGraph.scss";
import { Dropdown, DropdownButton } from "react-bootstrap";
import { socket } from "../../Socket";
import React, { useEffect, useState } from "react";
import { useDispatch, useSelector } from "react-redux";
import { DispatchType, RootState } from "../../redux/StockMarketStore";
import { Link, useParams } from "react-router-dom";
import { getUniqueCompaniesThunk } from "../../redux/thunks/UniqueCompaniesThunk";

const StockPriceGraph = () => {
    const [quantity, setQuantity] = useState("");

    const { stockName } = useParams();

    const uniqueCompanylist = useSelector(
        (state: RootState) => state.uniqueCompaniesReducer.uniqueCompanies
    );

    const name = useSelector((state: RootState) => state.stockListReducer.name);
    const onQuantityChangeHandler = (
        event: React.ChangeEvent<HTMLInputElement>
    ) => {
        setQuantity(event.target.value);
    };
    const handleTransaction = (transactionType: string) => {
        if (quantity === "") return;

        socket.emit("new-transaction", {
            type: transactionType,
            quantity: quantity,
            name: name,
            stockName: stockName,
            time: new Date(Date.now()),
        });

        setQuantity("");
    };

    const reduxDispatch: DispatchType = useDispatch();

    useEffect(() => {
        socket.emit("get-price", stockName);
        reduxDispatch(getUniqueCompaniesThunk());
    }, [reduxDispatch, stockName]);

    return (
        <section className='stock-price-graph-container'>
            <div className='company-info'>
                <DropdownButton
                    id='dropdown-basic-button'
                    className='stock_dropdown_button'
                    variant='info'
                    title={
                        <div className='stock_dropdown'>
                            <div className='stock_symbol'>
                                {stockName?.substring(0, 3).toUpperCase()}
                            </div>
                            <h1 className='stock_name'>{stockName}</h1>
                        </div>
                    }
                >
                    <div className='dropdown-items-container'>
                        {uniqueCompanylist.map((company) => {
                            return (
                                <Dropdown.Item
                                    key={company}
                                    className='stock-dropdown-item'
                                    eventKey='2'
                                >
                                    <Link
                                        to={`/stock/${company}`}
                                        className='stock-dropdown-item-link'
                                    >
                                        <div className='stock_dropdown'>
                                            <div className='stock_symbol'>
                                                {company
                                                    .substring(0, 3)
                                                    .toUpperCase()}
                                            </div>
                                            <h1 className='stock_name'>
                                                {company}
                                            </h1>
                                        </div>
                                    </Link>
                                </Dropdown.Item>
                            );
                        })}
                    </div>
                </DropdownButton>
                <div className='price-container'>
                    <h2 className='price-tag'>Price:</h2>
                    <h2 className='value up'>142.32</h2>
                    <h3 className='value-change up'>3.00%</h3>
                </div>
                <input
                    value={quantity}
                    onChange={(event) => onQuantityChangeHandler(event)}
                    type='number'
                    placeholder='Enter QTY'
                    className='quantity-input'
                />
                <button
                    onClick={() => handleTransaction("buy")}
                    className='buy-btn'
                >
                    <h2>Buy</h2>
                </button>
                <button
                    onClick={() => handleTransaction("sell")}
                    className='sell-btn'
                >
                    <h2>Sell</h2>
                </button>
            </div>
            <div className='bar-graph-wrapper'>
                <BarGraph />
            </div>
        </section>
    );
};

export default StockPriceGraph;
