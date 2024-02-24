import { createUseStyles } from "react-jss";

export const useStyles = createUseStyles({
    navbarContainer: {
        backgroundColor: "#2a2a72",
        padding: "0  1rem",
        "& .navbar-wrapper": {
            width: "80%",
            margin: "auto",
            height: "4rem",
            display: "flex",
            justifyContent: "space-between",
            alignItems: "center",
            "& .input-container": {
                position: "relative",
                "& .search-input": {
                    height: "2rem",
                    width: "20rem",
                    fontSize: "1.2rem",
                    border: "none",
                    borderRadius: "1rem",
                    paddingLeft: "1rem",
                },
                "& .material-symbols-outlined": {
                    position: "absolute",
                    top: "15%",
                    right: "5%",
                },
            },
            "& .filter-container": {
                fontWeight: 600,
                color: "white",
                fontSize: "1.5rem",
                "& label": {
                    marginLeft: "2rem",
                    marginRight: "1rem",
                },
                "& select": {
                    fontSize: "1.2rem",
                    borderRadius: "0.7rem",
                    padding: "0.2rem  1rem",
                    marginRight: "1.5rem",
                    cursor: "pointer",
                },
            },
        },
    },
});
