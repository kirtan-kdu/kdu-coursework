const styles = {
    dashboardTableContainer: {
        marginTop: "2rem",
        "& .dashboard-table": {
            border: "4px solid #5b6065",
            borderRadius: "2rem",
            maxWidth: "60rem",
            height: "40rem",
            margin: "auto",
            display: "flex",
            flexDirection: "column",
            "& .dashboard-table-rows": {
                height: "80%",
            },
            "& .dashboard-row-link": {
                textDecoration: "none",
                color: "black",
            },
            "& .dashboard-table-row": {
                padding: 0,
                textDecoration: "none",
                display: "flex",
                margin: "0rem 3rem",
                paddingBottom: "1rem",
                paddingTop: "1.2rem",
                justifyContent: "space-between",
                fontSize: "1.1rem",
                borderBottom: "2px solid #d2d3d4",
                "& h2": {
                    fontWeight: 400,
                    margin: "auto 0",
                },
                "& .dashboard-right-table-row": {
                    fontWeight: 100,
                    display: "flex",
                    justifyContent: "center",
                    "& h2": {
                        margin: "auto 2rem",
                        fontWeight: 400,
                    },
                    "& .dashboard-wishlist-container": {
                        width: "10rem",
                        display: "flex",
                        justifyContent: "center",
                        "& img": {
                            margin: "0 auto",
                            width: "35px",
                            height: "35px",
                        },
                    },
                },
            },
            "& .dashboard-table-top-row": {
                margin: 0,
                padding: "1rem 3rem",
                borderBottom: "4px solid #5b6065",
            },
            "& .dashboard-table-pagination-component": {
                justifySelf: "end",
                alignSelf: "center",
                marginTop: "1rem",
            },
        },
    },
};

export default styles;
