import { useDispatch, useSelector } from "react-redux";
import { DispatchType, RootState } from "../../redux/StockMarketStore";
import { useEffect, useState } from "react";
import { getTransactionListThunk } from "../../redux/thunks/TransactionListThunk";
import "./TransactionTable.scss";
import { getFilteredTransactions } from "../../redux/selectors/GetFilteredTransactions";

const TransactionTable = () => {
    const [isDataLoaded, setIsDataLoaded] = useState(true);
    const { searchString, startDate, endDate, status, companyFilter } =
        useSelector((state: RootState) => state.filterParamsReducer);

    const reduxDispatch: DispatchType = useDispatch();

    useEffect(() => {
        setIsDataLoaded(false);
        reduxDispatch(getTransactionListThunk()).then(() =>
            setIsDataLoaded(true)
        );
    }, [reduxDispatch]);

    const groupByDateList = useSelector((state: RootState) => {
        if (isDataLoaded) {
            console.log("am i being called");
            const temp = getFilteredTransactions(
                state,
                searchString,
                startDate,
                endDate,
                status,
                companyFilter
            );
            console.log(temp.length);
            return temp;
        }
    });

    return (
        <section className='transaction-table-section'>
            {groupByDateList == undefined ? (
                <div className='loader'></div>
            ) : (
                groupByDateList.map((transactionByDate) => {
                    return (
                        <div key={transactionByDate.date}>
                            <div>
                                <h1>{transactionByDate.date}</h1>
                            </div>
                            {transactionByDate.transactions.map(
                                (transaction) => {
                                    return (
                                        <div
                                            key={transaction.timestamp}
                                            className='transaction-row'
                                        >
                                            <h1 className='transaction-stock-name'>
                                                {transaction.stock_name}
                                            </h1>
                                            <h1 className='transaction-stock-symbol'>
                                                {transaction.stock_symbol}
                                            </h1>
                                            <h1 className='transaction-stock-price'>
                                                {transaction.transaction_price}
                                            </h1>
                                            <div className='transaction-stock-status-container'>
                                                <h1>
                                                    {new Date(
                                                        transaction.timestamp
                                                    )
                                                        .toLocaleTimeString(
                                                            undefined,
                                                            {
                                                                hour: "2-digit",
                                                                minute: "2-digit",
                                                                hour12: true,
                                                            }
                                                        )
                                                        .replace(
                                                            /(pm|am)/,
                                                            (match) =>
                                                                match.toUpperCase()
                                                        )}
                                                </h1>
                                                <div className='transaction-stock-status'></div>
                                            </div>
                                        </div>
                                    );
                                }
                            )}
                        </div>
                    );
                })
            )}
        </section>
    );
};

export default TransactionTable;
