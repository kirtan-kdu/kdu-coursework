import { createUseStyles } from "react-jss";

export const useStyles = createUseStyles({
    prodContainer: {
        width: "80%",
        margin: "auto",
        textAlign: "center",
        fontFamily: '"Poppins", sans-serif',
        "& .prod-title": {
            fontSize: "2.8rem",
            fontWeight: 500,
            color: "#2a2a72",
            marginTop: "6rem",
        },
        "& .prod-details": {
            height: "auto",
            width: "100%",
            display: "flex",
            margin: "4rem  0",
            "& .prod-image-container": {
                width: "50%",
                "& .prod-look": {
                    width: "25rem",
                },
            },
            "& .right-details": {
                width: "50%",
                textAlign: "start",
                "& .prod-name": {
                    fontSize: "2rem",
                    fontWeight: 400,
                    margin: "1rem  0",
                },
                "& .prod-price": {
                    fontSize: "1.3rem",
                    fontWeight: 600,
                    margin: "1rem  0",
                    color: "#2a2a72",
                    marginBottom: "2rem",
                },
                "& .prod-des": {
                    paddingTop: "1rem",
                    fontSize: "1.2rem",
                    fontWeight: 400,
                    color: "grey",
                    lineHeight: "1.5rem",
                },
                "& .prod-rating-container": {
                    marginTop: "2rem",
                    display: "flex",
                    justifyContent: "space-evenly",
                    fontSize: "1.5rem",
                    "& span": {
                        paddingLeft: "1rem",
                        fontWeight: 400,
                    },
                },
                "& .redirect-btn": {
                    cursor: "pointer",
                    marginTop: "3rem",
                    border: "none",
                    borderRadius: "1rem",
                    padding: "1rem",
                    backgroundColor: "#2a2a721f",
                    color: "#2a2a72",
                    fontSize: "1.4rem",
                },
            },
        },
    },
});
