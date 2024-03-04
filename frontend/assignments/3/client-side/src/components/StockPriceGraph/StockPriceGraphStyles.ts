const styles = {
    stockPriceGraphContainer: {
        width: "70%",
        boxSizing: "border-box",
        "& .company-info": {
            height: "9vh",
            padding: "0 2rem",
            boxSizing: "border-box",
            display: "flex",
            justifyContent: "space-between",
            "& .logo-container": {
                border: "1px solid black",
                display: "flex",
                padding: "6px 1rem",
                width: "16rem",
                "& .logo": {
                    width: "5rem",
                },
                "& h2": {
                    margin: "auto",
                    paddingLeft: "8px",
                    fontSize: "2rem",
                    fontWeight: 500,
                },
            },
            "& .price-container": {
                display: "flex",
                width: "20rem",
                border: "2px solid grey",
                borderRadius: "6px",
                justifyContent: "space-evenly",
                padding: "16px 0.7rem",
                "& h2": {
                    fontSize: "2rem",
                    margin: "auto",
                    fontWeight: 400,
                },
                "& h3": {
                    marginTop: "auto",
                    marginBottom: "0.3rem",
                },
                "& .up": {
                    color: "#2f9e44", // $pos-dark
                },
                "& .down": {
                    color: "#e03131", // $neg-dark
                },
            },
            "& .quantity-input": {
                fontSize: "1.5rem",
                width: "10rem",
                paddingLeft: "1.2rem",
                boxSizing: "border-box",
                borderRadius: "6px",
            },
            "& .buy-btn": {
                width: "8rem",
                backgroundColor: "#b2f2bb", // $pos-light
                display: "flex",
                justifyContent: "center",
                alignItems: "center",
                border: "1px solid #2f9e44", // $pos-dark
                borderRadius: "6px",
                cursor: "pointer",
                "& h2": {
                    fontSize: "2rem",
                    color: "#2f9e44", // $pos-dark
                },
            },
            "& .sell-btn": {
                cursor: "pointer",
                width: "8rem",
                backgroundColor: "#ffc9c9", // $neg-light
                display: "flex",
                borderRadius: "6px",
                justifyContent: "center",
                alignItems: "center",
                border: "1px solid #e03131", // $neg-dark
                "& h2": {
                    fontSize: "2rem",
                    color: "#e03131", // $neg-dark
                },
            },
            "& .stock_dropdown_button": {
                backgroundColor: "#ffffff !important",
            },
        },
        "& .bar-graph-wrapper": {
            margin: "2rem",
        },
        "& #dropdown-basic-button": {
            backgroundColor: "white",
            display: "flex",
            alignItems: "center",
            border: "2px solid grey",
            padding: "0.9rem",
            boxSizing: "border-box",
        },
        "& .stock_dropdown": {
            display: "flex",
            "& .stock_symbol": {
                padding: "0.5rem",
                border: "2px solid grey",
                borderRadius: "6px",
            },
            "& .stock_name": {
                margin: "auto",
                padding: "0 1.5rem",
                fontSize: "2rem",
            },
        },
        "& .stock-dropdown-item": {
            width: "auto",
            padding: "1rem",
            fontSize: "1rem",
            "& .stock-dropdown-item-link": {
                textDecoration: "none",
                color: "black",
            },
            "& .stock_symbol": {
                fontSize: "0.8rem",
            },
            "& .stock_name": {
                margin: "auto 0",
                fontSize: "1.5rem",
            },
            "&:hover": {
                backgroundColor: "rgba(128, 128, 128, 0.212)",
            },
        },
        "& .dropdown-items-container": {
            height: "18rem",
            overflow: "scroll",
        },
    },
};

export default styles;
