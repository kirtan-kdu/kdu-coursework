import { useEffect, useMemo, useState } from "react";
import { useDispatch, useSelector } from "react-redux";
import { DispatchType, RootState } from "../../redux/StockMarketStore";
import { getTransactionSummaryThunk } from "../../redux/thunks/TransactionSummaryThunk";
import { setProfitSummary } from "../../redux/slices/SummarizerSlice";
import { createUseStyles } from "react-jss";
import styles from "./SummarizerPageStyles";

const SummarizerPage = () => {
    const useStyles = createUseStyles(styles);
    const classes = useStyles();
    const [isLoading, setIsLoading] = useState(false);
    const [dataFetched, setDataFetched] = useState(false);

    const worker = useMemo(
        () => new Worker(new URL("../../ServiceWorker.ts", import.meta.url)),
        []
    );

    const { transactionSummary, profitSummary } = useSelector(
        (state: RootState) => state.transactionSummaryReducer
    );

    const reduxDispatch: DispatchType = useDispatch();

    useEffect(() => {
        reduxDispatch(getTransactionSummaryThunk()).then(() => {
            setDataFetched(true);
        });
    }, [reduxDispatch]);

    useEffect(() => {
        if (dataFetched) {
            startComputation();
        }
    }, [dataFetched, transactionSummary]);

    const startComputation = () => {
        setIsLoading(true);
        worker.postMessage(transactionSummary);
        worker.onmessage = (event) => {
            reduxDispatch(setProfitSummary(event.data));
            setIsLoading(false);
        };
    };

    return (
        <div>
            {isLoading ? (
                <div className={classes.loaderWrapper}>
                    <div className='loader'></div>
                </div>
            ) : (
                <div className={classes.profitSummaryContainer}>
                    {profitSummary.map((transactoinProfit) => {
                        return (
                            <div
                                className='profit-summary-company'
                                key={transactoinProfit.company}
                            >
                                <div className='profit-summary-company-left'>
                                    <h1 className='profit-company-tag'>
                                        {transactoinProfit.company}
                                    </h1>
                                    <h1>{`Profit margin: ${transactoinProfit.maxProfit}`}</h1>
                                </div>
                                <div className='profit-summary-company-right'>
                                    <h1>{`Buy $${transactoinProfit.buyAmount} on ${transactoinProfit.buyDay}`}</h1>
                                    <h1>{`Sell $${transactoinProfit.sellAmount} on ${transactoinProfit.sellDay}`}</h1>
                                </div>
                            </div>
                        );
                    })}
                </div>
            )}
        </div>
    );
};

export default SummarizerPage;
