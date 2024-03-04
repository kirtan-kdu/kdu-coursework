import { Pagination } from "@mui/material";
import AddWatchListSVG from "../../assets/AddWatchList.svg";
import RemoveWatchListSVG from "../../assets/RemoveWatchList.svg";
import PlusWatchListSVG from "../../assets/PlusWatchList.svg";

import { useDispatch, useSelector } from "react-redux";
import { DispatchType, RootState } from "../../redux/StockMarketStore";
import { SetStateAction, useEffect, useRef, useState } from "react";
import { getStockListThunk } from "../../redux/thunks/DashboardListThunk";
import { Link } from "react-router-dom";
import { createUseStyles } from "react-jss";
import styles from "./DashboardTable.ts";
import { IStock } from "../../redux/slices/DashboardListSlice.ts";

interface IDashboardProps {
    activeTab: string;
}

const DashboardTable = ({ activeTab }: IDashboardProps) => {
    const useStyles = createUseStyles(styles);
    const classes = useStyles();
    const { stockList, state } = useSelector(
        (state: RootState) => state.stockListReducer
    );
    const [wishList, setWishList] = useState<IStock[]>([]);
    const itemsPerPage = useRef<number>(7);

    const [page, setPage] = useState<number>(1);

    const reduxDispatch: DispatchType = useDispatch();
    useEffect(() => {
        reduxDispatch(getStockListThunk());
    }, [reduxDispatch]);

    const onPageChangeHandler = (
        _event: React.ChangeEvent<unknown>,
        value: SetStateAction<number>
    ) => setPage(value);

    if (state === "pending") {
        return (
            <section className={classes.dashboardTableContainer}>
                <div className='dashboard-table'>
                    <div className='loader-wrapper'>
                        <div className='loader'></div>
                    </div>
                </div>
            </section>
        );
    }

    const onMouseEnterHandler = (
        event: React.MouseEvent<HTMLImageElement>,
        stock: IStock
    ) => {
        if (wishList.includes(stock)) {
            event.currentTarget.src = RemoveWatchListSVG;
        }
    };

    const onMouseLeaveHandler = (
        event: React.MouseEvent<HTMLImageElement>,
        stock: IStock
    ) => {
        if (wishList.includes(stock)) {
            event.currentTarget.src = AddWatchListSVG;
        } else {
            event.currentTarget.src = PlusWatchListSVG;
        }
    };

    const onClickWishlistHandler = (
        event: React.MouseEvent<HTMLImageElement>,
        stock: IStock
    ) => {
        if (wishList.includes(stock)) {
            event.currentTarget.src = AddWatchListSVG;
            setWishList((prevstate) =>
                prevstate.filter(
                    (currStock) => stock.stock_name != currStock.stock_name
                )
            );
        } else {
            event.currentTarget.src = PlusWatchListSVG;
            setWishList([...wishList, stock]);
        }
    };

    return (
        <section className={classes.dashboardTableContainer}>
            <div className='dashboard-table'>
                <div className='dashboard-table-top-row dashboard-table-row'>
                    <h2>Company</h2>
                    <div className='dashboard-right-table-row'>
                        <h2>Base price</h2>
                        <h2>Watchlist</h2>
                    </div>
                </div>

                <div className='dashboard-table-rows'>
                    {(activeTab === "explore" ? stockList : wishList)
                        .slice(
                            (page - 1) * itemsPerPage.current,
                            page * itemsPerPage.current
                        )
                        .map((stock) => {
                            return (
                                <div
                                    className='dashboard-table-row'
                                    key={stock.stock_name}
                                >
                                    <Link
                                        className='dashboard-row-link'
                                        to={`/stock/${stock.stock_name}`}
                                        key={stock.stock_symbol}
                                    >
                                        <h2>{stock.stock_name}</h2>
                                    </Link>
                                    <div className='dashboard-right-table-row'>
                                        <h2>{stock.base_price}</h2>
                                        <div className='dashboard-wishlist-container'>
                                            <img
                                                src={PlusWatchListSVG}
                                                alt='add-remove symbol'
                                                onMouseOver={(event) =>
                                                    onMouseEnterHandler(
                                                        event,
                                                        stock
                                                    )
                                                }
                                                onMouseOut={(event) =>
                                                    onMouseLeaveHandler(
                                                        event,
                                                        stock
                                                    )
                                                }
                                                onClick={(event) =>
                                                    onClickWishlistHandler(
                                                        event,
                                                        stock
                                                    )
                                                }
                                            />
                                        </div>
                                    </div>
                                </div>
                            );
                        })}
                </div>
                <Pagination
                    count={Math.ceil(
                        (activeTab === "explore" ? stockList : wishList)
                            .length / 7
                    )}
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
