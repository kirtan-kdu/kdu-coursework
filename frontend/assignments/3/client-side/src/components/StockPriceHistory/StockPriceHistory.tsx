import { useState } from "react";
import { socket } from "../../Socket";
import "./StockPriceHistory.scss";
import { useSelector } from "react-redux";
import { RootState } from "../../redux/StockMarketStore";

interface ITransaction {
    name: string;
    quantity: number;
    time: string;
    stockName: string;
    type: string;
}
const StockPriceHistory = () => {
    const [transactionHistory, setTransactionHistory] = useState<
        ITransaction[]
    >([]);

    const [usersTransaction, setUsersTransaction] = useState<ITransaction[]>(
        []
    );
    const usename = useSelector(
        (state: RootState) => state.stockListReducer.name
    );

    socket.on("add-transaction", (payload: ITransaction) => {
        setTransactionHistory([...transactionHistory, payload]);
        if (payload.name === usename) {
            setUsersTransaction([...usersTransaction, payload]);
        }
    });

    return (
        <section className='history-section'>
            <div className='personal-transaction'>
                <h1 className='history-tag'>History</h1>
                <div className='user-transactions'>
                    {usersTransaction.map((transaction) => {
                        return (
                            <div className='transaction' key={transaction.time}>
                                <div className='transaction-info'>
                                    <h2>{`${transaction.quantity} stocks`}</h2>
                                    <h1>
                                        {new Date(
                                            transaction.time
                                        ).toUTCString()}
                                    </h1>
                                </div>
                                <div className='transaction-type'>
                                    <h1 className={transaction.type}>
                                        {transaction.type.toUpperCase()}
                                    </h1>
                                </div>
                            </div>
                        );
                    })}
                </div>
            </div>

            <div className='all-transactions'>
                {transactionHistory.length === 0 ? (
                    <h1 className='no-transaction-tag'>No transactions!</h1>
                ) : (
                    <>
                        {transactionHistory.map((transaction) => {
                            return (
                                <div
                                    className='all-transaction'
                                    key={transaction.time}
                                >
                                    <h1 className='transaction-detail'>{`${
                                        transaction.name
                                    } has ${
                                        transaction.type === "buy"
                                            ? "bought"
                                            : "sold"
                                    } ${transaction.quantity} ${
                                        transaction.stockName
                                    }`}</h1>
                                    <h2 className='transaction-time'>
                                        {transaction.time}
                                    </h2>
                                </div>
                            );
                        })}
                    </>
                )}
            </div>
        </section>
    );
};

export default StockPriceHistory;
