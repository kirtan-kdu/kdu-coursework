const styles = {
    navbarContainer: {
        margin: "1rem",
        width: "98%",
        borderRadius: "10px",
        display: "flex",
        height: "5rem",
        justifyContent: "space-between",
        backgroundColor: "#1971c2", // $blue-color
        color: "#dbe8f5", // $white-color

        "& .left-navbar": {
            display: "flex",
            "& .stockmarket-logo": {
                borderRadius: "10px",
            },
            "& .logo-text": {
                fontSize: "2rem",
                fontWeight: 600,
                margin: "auto",
                width: "auto",
            },
        },
        "& .right-navbar": {
            display: "flex",
            fontSize: "1.75rem",
            fontWeight: 600,
            "& .fa": {
                display: "none",
            },
            "& .nav-link": {
                textDecoration: "none",
                margin: "auto",
                "& .nav-link-text": {
                    color: "#dbe8f5", // $white-color
                    fontWeight: 400,
                    marginRight: "2rem",
                },
            },
        },
    },
    "@media (max-width: 600px)": {
        rightNavbar: {
            display: "flex",
            flexDirection: "column",
        },
        logoText: {
            fontSize: "1.5rem !important",
        },
        fa: {
            alignSelf: "flex-end",
            margin: "2rem",
            display: "inline",
        },
        disableMenu: {
            display: "none",
        },
        showMenu: {
            display: "block",
            border: "1px solid grey",
            backgroundColor: "grey",
            "& div": {
                color: "black !important",
            },
        },
    },
};

export default styles;
