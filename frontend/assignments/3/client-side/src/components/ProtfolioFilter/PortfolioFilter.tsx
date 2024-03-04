import { useDispatch, useSelector } from "react-redux";
import React, { useEffect } from "react";
import {
    addCompanyFilter,
    addStatus,
    clearAll,
    removeCompanyFilter,
    removeStatus,
    setEndDate,
    setSearchString,
    setStartDate,
} from "../../redux/slices/FilterParamsSlice";
import { DispatchType, RootState } from "../../redux/StockMarketStore";
import { getUniqueCompaniesThunk } from "../../redux/thunks/UniqueCompaniesThunk";
import { createUseStyles } from "react-jss";
import styles from "./PortfolioFilterStyles";

const PortfolioFilter = () => {
    const useStyles = createUseStyles(styles);
    const classes = useStyles();
    const { searchString, companyFilter, status, startDate, endDate } =
        useSelector((state: RootState) => state.filterParamsReducer);

    const uniqueCompanies: string[] = useSelector(
        (state: RootState) => state.uniqueCompaniesReducer.uniqueCompanies
    );

    const reduxDispatch: DispatchType = useDispatch();

    const handleInputChange = (
        event: React.ChangeEvent<HTMLInputElement>,
        inputType: "search" | "startDate" | "endDate" | "passed" | "failed"
    ) => {
        switch (inputType) {
            case "search":
                reduxDispatch(setSearchString(event.target.value));
                break;
            case "startDate":
                reduxDispatch(setStartDate(event.target.value));
                break;
            case "endDate":
                reduxDispatch(setEndDate(event.target.value));
                break;
            case "passed":
                reduxDispatch(
                    event.target.checked
                        ? addStatus("Passed")
                        : removeStatus("Passed")
                );
                break;
            case "failed":
                reduxDispatch(
                    event.target.checked
                        ? addStatus("Failed")
                        : removeStatus("Failed")
                );
                break;
            default:
                break;
        }
    };

    const onCompanyChangeHandler = (
        event: React.ChangeEvent<HTMLInputElement>,
        companyName: string
    ) => {
        reduxDispatch(
            event.target.checked
                ? addCompanyFilter(companyName)
                : removeCompanyFilter(companyName)
        );
    };

    const clearAllFilters = () => {
        reduxDispatch(clearAll());
    };

    useEffect(() => {
        reduxDispatch(getUniqueCompaniesThunk());
    }, [reduxDispatch]);
    return (
        <section className={classes.transactionFilterSection}>
            <div className='transaction-filter-header'>
                <h1 className='transaction-filter-tag'>Filters</h1>
                <button
                    className='transaction-filter-clear'
                    onClick={clearAllFilters}
                >
                    Clear All
                </button>
            </div>
            <div className='transaction-filter-search'>
                <input
                    value={searchString}
                    onChange={(event) => handleInputChange(event, "search")}
                    className='transaction-filter-search-input'
                    placeholder='Search for a stock'
                    type='text'
                />
            </div>
            <div className='transaction-filter-date-container'>
                <label
                    className='transaction-filter-date-label'
                    htmlFor='startDate'
                >
                    Start :{" "}
                </label>
                <input
                    value={startDate}
                    onChange={(event) => handleInputChange(event, "startDate")}
                    className='transaction-filter-date-input'
                    placeholder='startDate'
                    type='date'
                    name='startDate'
                />
                <label
                    className='transaction-filter-date-label'
                    htmlFor='endDate'
                >
                    {" "}
                    End :{" "}
                </label>
                <input
                    value={endDate}
                    onChange={(event) => handleInputChange(event, "endDate")}
                    className='transaction-filter-date-input'
                    placeholder='endDate'
                    type='date'
                    name='endDate'
                />
            </div>
            <div className='transaction-filter-status-container'>
                <div>
                    {" "}
                    <input
                        checked={status === "Passed" || status === "all"}
                        onChange={(event) => handleInputChange(event, "passed")}
                        className='transaction-filter-status-checkbox'
                        aria-label='transaction-status'
                        type='checkbox'
                        name='passed'
                    />
                    <label htmlFor='passed'>Passed</label>
                </div>
                <div>
                    <input
                        checked={status === "Failed" || status === "all"}
                        onChange={(event) => handleInputChange(event, "failed")}
                        className='transaction-filter-status-checkbox'
                        aria-label='transaction-status'
                        type='checkbox'
                        name='failed'
                    />
                    <label htmlFor='failed'>Failed</label>
                </div>
            </div>
            <div className='transaction-filter-company'>
                {uniqueCompanies.map((company) => {
                    return (
                        <div key={company}>
                            <input
                                checked={companyFilter.includes(company)}
                                className='transaction-filter-company-checkbox'
                                aria-label='company-name'
                                type='checkbox'
                                name={company}
                                onChange={(event) =>
                                    onCompanyChangeHandler(event, company)
                                }
                            />
                            <label htmlFor={company}>{company}</label>
                        </div>
                    );
                })}
            </div>
        </section>
    );
};

export default PortfolioFilter;
