const styles = {
    dashboardContainer: {
        margin: "1rem 1rem 0 1rem",
        "& .dashboard-tabs-container": {
            display: "flex",
            "& .dashboard-tabs-btn": {
                fontSize: "1.1rem",
                paddingBottom: "0.5rem",
                margin: "0 1rem",
                border: "none",
                backgroundColor: "white",
            },
            "& .dashboard-tabs-active-btn": {
                borderBottom: "4px solid #1971c2", // $blue-color
            },
        },
    },
};

export default styles;
