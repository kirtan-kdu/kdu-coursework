const styles = {
    transactionFilterSection: {
        width: "30vw",
        height: "min-content",
        border: "2px solid #5b6065", // $black-border
        backgroundColor: "#e9ecef", // $grey-color
        borderRadius: "2rem",
        "& .transaction-filter-header": {
            display: "flex",
            padding: "1rem 2rem 0.5rem 2rem",
            justifyContent: "space-between",
            fontSize: "1.5rem",
            borderBottom: "2px solid #5b6065", // $black-border
            "& .transaction-filter-tag": {
                fontWeight: 400,
            },
            "& .transaction-filter-clear": {
                fontSize: "1.3rem",
                padding: 0,
                border: "none",
                backgroundColor: "transparent",
                color: "#2d7dc6", // $blue-color
                cursor: "pointer",
            },
        },
        "& .transaction-filter-search": {
            padding: "1rem 2rem",
            borderBottom: "2px solid #5b6065", // $black-border
            "& .transaction-filter-search-input": {
                fontSize: "1.3rem",
                borderRadius: "8px",
                paddingLeft: "1rem",
            },
        },
        "& .transaction-filter-date-container": {
            padding: "1rem 2rem",
            fontSize: "1.3rem",
            borderBottom: "2px solid #5b6065", // $black-border
            "& .transaction-filter-date-label": {
                margin: "auto",
            },
            "& .transaction-filter-date-input": {
                fontSize: "small",
                marginRight: "1rem",
                padding: "0.3rem 0",
            },
        },
        "& .transaction-filter-status-container": {
            padding: "1rem 2rem",
            borderBottom: "2px solid #5b6065", // $black-border
            fontSize: "1.3rem",
            display: "flex",
            flexDirection: "column",
            justifyContent: "center",
            alignItems: "start",
            "& .transaction-filter-status-checkbox": {
                width: "1rem",
                height: "1rem",
                marginRight: "1rem",
            },
        },
        "& .transaction-filter-company": {
            padding: "1rem 2rem",
            fontSize: "1.3rem",
            height: "24rem",
            lineHeight: "2rem",
            paddingTop: "18rem",
            overflowY: "scroll",
            display: "flex",
            flexDirection: "column",
            justifyContent: "center",
            alignItems: "start",
            "& .transaction-filter-company-checkbox": {
                width: "1rem",
                height: "1rem",
                marginRight: "1rem",
            },
        },
    },
};

export default styles;
