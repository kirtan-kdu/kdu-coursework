const styles = {
    transactionTableSection: {
        width: "55vw",
        "& .transaction-date": {
            borderBottom: "2px dotted grey",
            paddingBottom: "1rem",
            paddingTop: "2rem",
            "& .transaction-date-tag": {
                color: "grey",
            },
        },
        "& .transaction-row": {
            borderBottom: "2px solid #717171", // $black-border
            display: "flex",
            justifyContent: "space-between",
            fontSize: "1.3rem",
            padding: "1.3rem 0",
            justifySelf: "flex-end",
            "& h1": {
                fontWeight: 400,
            },
            "& .transaction-stock-name": {
                width: "25rem",
            },
            "& .transaction-stock-symbol": {
                width: "5rem",
            },
            "& .transaction-stock-price": {
                width: "8rem",
                textAlign: "end",
            },
            "& .transaction-stock-status-container": {
                width: "10rem",
                marginLeft: "5rem",
                display: "flex",
                justifyContent: "space-between",
                marginRight: "5px",
                "& h1": {
                    textAlign: "end",
                    width: "7rem",
                },
                "& .transaction-stock-status": {
                    width: "12px",
                    height: "12px",
                    borderRadius: "50%",
                    margin: "auto 0",
                },
                "& .Passed": {
                    backgroundColor: "#6bb97a",
                },
                "& .Failed": {
                    backgroundColor: "red",
                },
            },
        },
    },
};

export default styles;
