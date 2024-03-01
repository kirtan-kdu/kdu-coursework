import RoomTypeComponent from "../components/RoomTypeComponent";
import DateComponent from "../components/DateComponent";
import AddOnsComponent from "../components/AddOnsComponent";
import { createUseStyles } from "react-jss";
import { useSelector } from "react-redux";
import { RootState } from "../redux/RoomTypeListStore";

const styles = {
    hotelBookingTag: {
        color: "#F08A5D",
        fontSize: "2rem",
    },
    mainContainer: {
        marginTop: "2rem",
        display: "flex",
        flexDirection: "column",
        justifyContent: "center",
        alignItems: "center",
        width: "100vw",
    },
    submitBtn: {
        backgroundColor: "#F08A5D",
        padding: "1rem 3rem",
        border: "none",
        borderRadius: "1rem",
        alignSelf: "start",
        marginLeft: "10vw",
        fontSize: "1.2rem",
    },
    finalConstTag: {
        fontSize: "2rem",
        alignSelf: "start",
        padding: "2rem 0",
        marginLeft: "10vw",
    },
};
const useStyles = createUseStyles(styles);

const HomePage = () => {
    const classes = useStyles();
    const roomlist = useSelector(
        (state: RootState) => state.productListReducer.roomTypes.roomTypeList
    );

    const { roomId, startDate, endDate, preferences } = useSelector(
        (state: RootState) => state.currRoomDetailReducer
    );

    const calculatePrice = () => {
        const stay = Math.max(
            (new Date(endDate).getTime() - new Date(startDate).getTime()) /
                (1000 * 3600 * 24),
            0
        );
        let addOnsCost: number = 0;
        roomlist[roomId - 1].addOns.forEach((addon) => {
            if (preferences.includes(addon.name))
                addOnsCost += addon.cost * stay;
        });
        return roomlist[roomId - 1].costPerNight * stay + addOnsCost;
    };

    return (
        <div className={classes.mainContainer}>
            <h1 className={classes.hotelBookingTag}>Hotel Booking</h1>
            <RoomTypeComponent />
            <DateComponent />
            <AddOnsComponent />
            {preferences.length > 0 && startDate !== "" && endDate != "" ? (
                <h1 className={classes.finalConstTag}>
                    Cost + 18% GST = {calculatePrice()}
                </h1>
            ) : (
                <h1 className={classes.finalConstTag}>Select options</h1>
            )}
            <button className={classes.submitBtn}>Submit</button>
        </div>
    );
};

export default HomePage;
