import { Pagination } from "@mui/material";
import "./DashboardTable.scss";
import { useDispatch, useSelector } from "react-redux";
import { DispatchType, RootState } from "../../redux/StockMarketStore";
import { SetStateAction, useEffect, useRef, useState } from "react";
import { getStockListThunk } from "../../redux/thunks/DashboardTableThunk";

const DashboardTable = () => {
    const { stockList, state } = useSelector(
        (state: RootState) => state.productListReducer
    );
    const itemsPerPage = useRef<number>(7);

    const [page, setPage] = useState<number>(1);

    const reduxDispatch: DispatchType = useDispatch();
    useEffect(() => {
        reduxDispatch(getStockListThunk());
    }, []);

    const onPageChangeHandler = (
        _event: React.ChangeEvent<unknown>,
        value: SetStateAction<number>
    ) => setPage(value);

    if (state === "pending") {
        return (
            <section className='dashboard-table-container'>
                <div className='dashboard-table'>
                    <div className='loader-wrapper'>
                        <div className='loader'></div>
                    </div>
                </div>
            </section>
        );
    }

    console.log(stockList, "stocklist");
    return (
        <section className='dashboard-table-container'>
            <div className='dashboard-table'>
                <div className='dashboard-table-top-row dashboard-table-row'>
                    <h2>Company</h2>
                    <div className='dashboard-right-table-row'>
                        <h2>Base price</h2>
                        <h2>Watchlist</h2>
                    </div>
                </div>
                <div className='dashboard-table-rows'>
                    {stockList
                        .slice(
                            (page - 1) * itemsPerPage.current,
                            page * itemsPerPage.current
                        )
                        .map((stock) => {
                            return (
                                <div
                                    key={stock.stock_symbol}
                                    className='dashboard-table-row'
                                >
                                    <h2>{stock.stock_name}</h2>
                                    <div className='dashboard-right-table-row'>
                                        <h2>{stock.base_price}</h2>
                                        <h2>Watchlist</h2>
                                    </div>
                                </div>
                            );
                        })}
                </div>
                <Pagination
                    count={Math.ceil(stockList.length / 7)}
                    size='large'
                    color='primary'
                    variant='outlined'
                    page={page}
                    onChange={(event, value) =>
                        onPageChangeHandler(event, value)
                    }
                    className='dashboard-table-pagination-component'
                />
            </div>
        </section>
    );
};

export default DashboardTable;
