import { GroupByDateTransactionList } from "../../redux/slices/TransactionListSlice";

const LazyTransactionRows = ({
    groupByDateList,
    state,
}: GroupByDateTransactionList) => {
    console.log("inside lazy", groupByDateList);
    return (
        <div>
            {groupByDateList.map((transactionByDate) => {
                return (
                    <div key={transactionByDate.date}>
                        <div className='transaction-date'>
                            <h1 className='transaction-date-tag'>
                                {transactionByDate.date}
                            </h1>
                        </div>
                        {transactionByDate.transactions.map((transaction) => {
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
                                            {new Date(transaction.timestamp)
                                                .toLocaleTimeString(undefined, {
                                                    hour: "2-digit",
                                                    minute: "2-digit",
                                                    hour12: true,
                                                })
                                                .replace(/(pm|am)/, (match) =>
                                                    match.toUpperCase()
                                                )}
                                        </h1>
                                        <div
                                            className={`transaction-stock-status ${transaction.status} ${state}`}
                                        ></div>
                                    </div>
                                </div>
                            );
                        })}
                    </div>
                );
            })}
        </div>
    );
};

export default LazyTransactionRows;
