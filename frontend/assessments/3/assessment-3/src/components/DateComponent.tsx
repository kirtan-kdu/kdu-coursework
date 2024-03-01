import { createUseStyles } from "react-jss";
import { useDispatch, useSelector } from "react-redux";
import { DispatchType, RootState } from "../redux/RoomTypeListStore";
import { setEndDate, setStartDate } from "../redux/Slice/CurrentRoomDetails";
import { useEffect } from "react";

const styles = {
    SelectDatesContainer: {
        marginTop: "2rem",
        width: "80vw",
    },
    SelectDatesTag: {
        backgroundColor: "#F08A5D",
        padding: "1.5rem 3rem",
        borderRadius: "1rem",
        fontSize: "1.5rem",
        color: "white",
    },
    DatesContainer: {
        display: "flex",
        marginTop: "1rem",
        "& input": {
            margin: "0 1rem",
            padding: "1rem 2rem",
            fontSize: "1.1rem",
            borderRadius: "1rem",
        },
    },
};

const useStyles = createUseStyles(styles);

const DateComponent = () => {
    const classes = useStyles();

    const reduxDispatch: DispatchType = useDispatch();

    const { startDate, endDate } = useSelector(
        (state: RootState) => state.currRoomDetailReducer
    );

    useEffect(() => {
        console.log("rendered dates: ", endDate);
    }, [endDate]);

    const onStartDateChangeHandler = (
        event: React.ChangeEvent<HTMLInputElement>
    ) => {
        reduxDispatch(setStartDate(event.target.value));
        console.log(
            new Date(event.target.value).getTime() > new Date(endDate).getTime()
        );
        if (
            endDate !== "" &&
            new Date(event.target.value).getTime() > new Date(endDate).getTime()
        ) {
            console.log("endDate is set to empty");
            reduxDispatch(setEndDate(""));
        }
    };

    const onEndDateChangeHandler = (
        event: React.ChangeEvent<HTMLInputElement>
    ) => {
        reduxDispatch(setEndDate(event.target.value));
    };

    return (
        <div className={classes.SelectDatesContainer}>
            <div className={classes.SelectDatesTag}>
                <h1>Select additional addons / preferences</h1>
            </div>
            <div className={classes.DatesContainer}>
                <input
                    value={startDate}
                    placeholder='Start date'
                    type='date'
                    onChange={(event) => onStartDateChangeHandler(event)}
                />
                <input
                    value={endDate}
                    placeholder='End date'
                    type='date'
                    disabled={startDate === ""}
                    min={startDate}
                    onChange={(event) => onEndDateChangeHandler(event)}
                />
            </div>
        </div>
    );
};

export default DateComponent;
