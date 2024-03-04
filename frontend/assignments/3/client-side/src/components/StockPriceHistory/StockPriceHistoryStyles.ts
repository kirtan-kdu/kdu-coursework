const styles = {
    historySection: {
        width: "35%",
        height: "81vh",
        marginRight: "2rem",
        marginBottom: "2rem",
        "& .personal-transaction": {
            border: "1px solid black",
            height: "47%",
            marginBottom: "2rem",
            borderRadius: "1rem",
            "& .history-tag": {
                fontSize: "2rem",
                padding: "1rem 2rem",
            },
        },
        "& .transaction": {
            border: "1px solid black",
            margin: "0.5rem 1rem",
            display: "flex",
            "& .transaction-info": {
                width: "80%",
                padding: "0.5rem 1rem",
                "& h2": {
                    lineHeight: "2rem",
                    fontSize: "1.3rem",
                },
            },
            "& .transaction-type": {
                padding: 0,
                display: "flex",
                justifyContent: "center",
                alignItems: "center",
                fontSize: "1.5rem",
                "& h1": {
                    padding: "auto 0",
                },
                "& .buy": {
                    color: "#2f9e44", // $pos-dark
                },
                "& .sell": {
                    color: "#e03131", // $neg-dark
                },
            },
        },
        "& .all-transaction": {
            margin: "1rem",
        },
        "& .transaction-detail": {
            fontSize: "1.5rem",
        },
        "& .all-transactions": {
            height: "48%",
            border: "1px solid black",
            borderRadius: "1rem",
            overflow: "scroll",
            overflowX: "hidden",
        },
        "& .no-transaction-tag": {
            fontSize: "1.5rem",
            margin: "1rem",
        },
        "& .user-transactions": {
            height: "15rem",
            overflowY: "scroll",
            overflowX: "hidden",
        },
    },
};

export default styles;
