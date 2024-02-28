import { createUseStyles } from "react-jss";

export const useStyles = createUseStyles({
    mainContainer: {
        backgroundColor: "#ece9e9",
        fontFamily: '"Poppins", sans-serif',
        display: "flex",
        flexDirection: "column",
        alignItems: "center",
        justifyContent: "space-evenly",
        "& .main-heading h1": {
            padding: "3rem",
            fontSize: "3rem",
            fontWeight: 600,
            wordSpacing: "1rem",
            "& span": {
                color: "#2a2a72",
            },
        },
        "& .productlist-container": {
            padding: "0  6rem",
            boxSizing: "border-box",
            display: "flex",
            flexWrap: "wrap",
            flexBasis: "4",
            "& .prod-link": {
                width: "25%",
                "& .product-card": {
                    height: "24rem",
                    borderRadius: "1rem",
                    backgroundColor: "white",
                    display: "flex",
                    flexDirection: "column",
                    alignItems: "center",
                    margin: "1rem",
                    "& .prod-heading": {
                        boxSizing: "border-box",
                        padding: "0.8rem  1rem",
                        width: "100%",
                        display: "flex",
                        justifyContent: "space-between",
                        "& .prod-catagory": {
                            padding: "0.5rem",
                            fontWeight: 600,
                            backgroundColor: "#2a2a7284",
                            opacity: 0.8,
                            borderRadius: "6px",
                        },
                        "& .prod-rating": {
                            margin: "auto  0.5rem",
                        },
                    },
                    "& .prod-image-wrapper": {
                        height: "15rem",
                        display: "flex",
                        alignItems: "center",
                        "& .prod-image": {
                            width: "7rem",
                        },
                    },
                    "& .prod-footer": {
                        borderTop: "2px solid rgba(128,  128,  128,  0.234)",
                        width: "100%",
                        boxSizing: "border-box",
                        padding: "1rem",
                        display: "flex",
                        justifyContent: "space-between",
                        "& .prod-title": {
                            boxSizing: "border-box",
                            width: "76%",
                            fontSize: "1.1rem",
                            paddingRight: "0.5rem",
                            fontWeight: 500,
                        },
                        "& .prod-price": {
                            width: "4.5rem",
                            fontWeight: 600,
                            color: "goldenrod",
                        },
                    },
                },
            },
            "& .prod-link:hover": {
                boxShadow: "0  0px  8px  0 #2a2a72,  0  4px  30px  0 #2a2a72",
                transition: "box-shadow  0.6s",
                borderRadius: "2rem",
            },
        },
    },
});
