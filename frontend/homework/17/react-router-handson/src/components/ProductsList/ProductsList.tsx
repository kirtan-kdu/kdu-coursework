import { useStyles } from "./ProductList.styles.ts";
import ProductCard from "./ProductCard/ProductCard";
import { IProduct } from "../../types/Product.type.ts";
import { useDispatch, useSelector } from "react-redux";
import { DispatchType, RootState } from "../../redux/Store.ts";
import { getProductListThunk } from "../../redux/thunk/ProductListThunk.ts";
import { Alert, Snackbar } from "@mui/material";
import React from "react";

const ProductsList = () => {
    const { productsList, state } = useSelector(
        (state: RootState) => state.productListReducer
    );

    const reduxDispatch: DispatchType = useDispatch();

    const classes = useStyles();

    const { searchString, categoryFilter, sortBy } = useSelector(
        (state: RootState) => state.filterParamsReducer
    );

    productsList.length === 0 &&
        state !== "error" &&
        reduxDispatch(getProductListThunk());

    const sortProducts = (productsList: IProduct[], sortBy: string) => {
        switch (sortBy) {
            case "price":
                return [...productsList].sort((a, b) => a.price - b.price);
            case "name":
                return [...productsList].sort((a, b) =>
                    a.title.localeCompare(b.title)
                );
            case "rating":
                return [...productsList].sort(
                    (a, b) => b.rating.rate - a.rating.rate
                );
            default:
                return productsList;
        }
    };

    const sortedProducts = sortProducts(
        productsList.filter(
            (product) =>
                product.category === categoryFilter || categoryFilter === ""
        ),
        sortBy
    );

    const filteredProducts = sortedProducts.filter((product) =>
        product.title.toLowerCase().includes(searchString.toLowerCase())
    );
    console.log(state, "state");

    const [open, setOpen] = React.useState(true);
    const handleClose = () => {
        setOpen(false);
    };

    if (state == "error") {
        return (
            <div className={classes.mainContainer}>
                <div className='main-heading'>
                    <h1>No Products available!</h1>
                </div>
                <Snackbar
                    open={open}
                    anchorOrigin={{
                        vertical: "bottom",
                        horizontal: "center",
                    }}
                    autoHideDuration={5000}
                    onClose={handleClose}
                >
                    <Alert
                        severity={"error"}
                        variant='filled'
                        sx={{ width: "200%", fontSize: "20px" }}
                    >
                        {"Error while fetching products!"}
                    </Alert>
                </Snackbar>
            </div>
        );
    }

    return (
        <div className={classes.mainContainer}>
            <Snackbar
                open={open}
                anchorOrigin={{
                    vertical: "bottom",
                    horizontal: "center",
                }}
                autoHideDuration={5000}
                onClose={handleClose}
            >
                <Alert
                    severity={"success"}
                    variant='filled'
                    sx={{ width: "200%", fontSize: "20px" }}
                >
                    {"Successfully retrieved all products!"}
                </Alert>
            </Snackbar>
            <div className='main-heading'>
                <h1>
                    KDU <span>MARKETPLACE</span>
                </h1>
            </div>
            {state === "pending" ? (
                <div className='loader-wrapper'>
                    <div className='loader'></div>
                </div>
            ) : (
                <div className='productlist-container'>
                    {filteredProducts.map((product) => (
                        <ProductCard
                            key={product.id}
                            product={product}
                        ></ProductCard>
                    ))}
                </div>
            )}
        </div>
    );
};

export default ProductsList;
