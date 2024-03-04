import { createSelector } from "reselect";
import { RootState } from "../StockMarketStore";
import { GroupByDateTransaction } from "../slices/TransactionListSlice";

// Input selector to extract the transactions from the state
const getTransactions = (state: RootState) =>
    state.transactionListReducer.groupByDateList;

// Input selector to extract the search text from the component's props
const getSearchText = (_: RootState, searchText: string) => searchText;

const getStartDate = (_: RootState, _searchText: string, startDate: string) =>
    startDate;

const getEndDate = (
    _: RootState,
    _searchText: string,
    _startDate: string,
    endDate: string
) => endDate;

const getStatus = (
    _: RootState,
    _searchText: string,
    _startDate: string,
    _endDate: string,
    status: string
) => status;

const getCompanyFilter = (
    _: RootState,
    _searchText: string,
    _startDate: string,
    _endDate: string,
    _status: string,
    companyFilter: string[]
) => companyFilter;

export const getFilteredTransactions = createSelector(
    [
        getTransactions,
        getSearchText,
        getStartDate,
        getEndDate,
        getStatus,
        getCompanyFilter,
    ],
    (
        transactions: GroupByDateTransaction[],
        searchText: string,
        startDate,
        endDate,
        status,
        companyFilter
    ) => {
        const start = startDate ? new Date(startDate) : null;
        const end = endDate ? new Date(endDate) : null;

        return transactions
            .filter((group) =>
                group.transactions.some((transaction) => {
                    const transactionDate = new Date(transaction.timestamp);
                    const matchesStockName = transaction.stock_name
                        .toLowerCase()
                        .includes(searchText.toLowerCase());
                    const withinDateRange =
                        (!start || transactionDate >= start) &&
                        (!end || transactionDate <= end);
                    const matchesStatus =
                        status === "all" || transaction.status === status;
                    const matchesCompanyName =
                        companyFilter.length === 0 ||
                        companyFilter.includes(transaction.stock_name);
                    return (
                        matchesStockName &&
                        withinDateRange &&
                        matchesStatus &&
                        matchesCompanyName
                    );
                })
            )
            .map((group) => ({
                ...group,
                transactions: group.transactions.filter((transaction) => {
                    const transactionDate = new Date(transaction.timestamp);
                    const matchesStockName = transaction.stock_name
                        .toLowerCase()
                        .includes(searchText.toLowerCase());
                    const withinDateRange =
                        (!start || transactionDate >= start) &&
                        (!end || transactionDate <= end);
                    const matchesStatus =
                        status === "all" || transaction.status === status;
                    const matchesCompanyName =
                        companyFilter.length === 0 ||
                        companyFilter.includes(transaction.stock_name);
                    return (
                        matchesStockName &&
                        withinDateRange &&
                        matchesStatus &&
                        matchesCompanyName
                    );
                }),
            }));
    }
);
