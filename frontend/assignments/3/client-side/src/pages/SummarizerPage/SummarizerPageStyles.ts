const styles = {
    profitSummaryContainer: {
        "& .profit-summary-company": {
            backgroundColor: "#1971c2", // $blue-color
            margin: "2rem auto",
            padding: "1.5rem 2rem",
            color: "#dbe8f5", // $white-color
            borderRadius: "2rem",
            maxWidth: "80rem",
            display: "flex",
            justifyContent: "space-between",
            fontSize: "1.2rem",
            "& .profit-summary-company-left": {
                "& h1": {
                    fontWeight: 400,
                },
                "& .profit-company-tag": {
                    fontSize: "2rem",
                    fontWeight: 600,
                },
            },
            "& .profit-summary-company-right": {
                margin: "auto 0",
                "& h1": {
                    fontWeight: 400,
                },
            },
        },
    },
    loaderWrapper: {
        height: "90vh",
        width: "100vw",
        display: "flex",
        justifyContent: "center",
        alignItems: "center",
    },
};

export default styles;
