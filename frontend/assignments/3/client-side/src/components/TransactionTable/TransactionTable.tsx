import { useDispatch, useSelector } from "react-redux";
import { DispatchType, RootState } from "../../redux/StockMarketStore";
import React, { Suspense, useEffect } from "react";
import { getTransactionListThunk } from "../../redux/thunks/TransactionListThunk";
import { getFilteredTransactions } from "../../redux/selectors/GetFilteredTransactions";
import { createUseStyles } from "react-jss";
import styles from "./TransactionTableStyles";
const LazyTransactionRows = React.lazy(() => import("./LazyTransactionRows"));

const TransactionTable = () => {
    const useStyles = createUseStyles(styles);
    const classes = useStyles();
    const { searchString, startDate, endDate, status, companyFilter } =
        useSelector((state: RootState) => state.filterParamsReducer);

    const loaded = useSelector(
        (state: RootState) => state.transactionListReducer.state
    );
    const reduxDispatch: DispatchType = useDispatch();

    useEffect(() => {
        if (loaded === "not loaded") reduxDispatch(getTransactionListThunk());
    }, [loaded, reduxDispatch]);

    const groupByDateList = useSelector((state: RootState) => {
        if (loaded === "loaded") {
            return getFilteredTransactions(
                state,
                searchString,
                startDate,
                endDate,
                status,
                companyFilter
            );
        }
    });

    return (
        <section className={classes.transactionTableSection}>
            {groupByDateList == undefined ? (
                <div className='loader'></div>
            ) : (
                <Suspense fallback={<div className='loader'></div>}>
                    <LazyTransactionRows
                        groupByDateList={groupByDateList}
                        state='loaded'
                    />
                </Suspense>
            )}
        </section>
    );
};

export default TransactionTable;
