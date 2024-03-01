import { createUseStyles } from "react-jss";
import { useDispatch, useSelector } from "react-redux";
import { DispatchType, RootState } from "../redux/RoomTypeListStore";
import { useEffect, useState } from "react";
import { getRoomTypeListThunk } from "../redux/thunk/GetRoomTypeListThunk";
import { setRoomId } from "../redux/Slice/CurrentRoomDetails";

const styles = {
    RoomTypeContainer: {
        marginTop: "2rem",
    },
    SelectRoomTypeTag: {
        backgroundColor: "#F08A5D",
        padding: "1.5rem 3rem",
        borderRadius: "1rem",
        fontSize: "1.5rem",
        color: "white",
        width: "80vw",
    },
    RoomTypeBtnContainer: {
        display: "flex",
        marginTop: "1rem",
        "& button": {
            margin: "0 1rem",
            padding: "1rem 2rem",
            fontSize: "1.1rem",
            borderRadius: "1rem",
        },
    },
    SelectedRoom: {
        border: "2px solid #F08A5D",
        color: "#F08A5D",
    },
};
const useStyles = createUseStyles(styles);

const RoomTypeComponent = () => {
    const [currRoomType, setCurrRoomType] = useState(0);
    const roomTypeList = useSelector(
        (state: RootState) => state.productListReducer.roomTypes
    );

    const onSelectChangeHandler = (roomTypeId: number) => {
        reduxDispatch(setRoomId(roomTypeId));
        setCurrRoomType(roomTypeId);
    };

    const reduxDispatch: DispatchType = useDispatch();
    useEffect(() => {
        reduxDispatch(getRoomTypeListThunk());
    }, []);

    console.log(roomTypeList, "roomtype");
    const classes = useStyles();
    return (
        <div className={classes.RoomTypeContainer}>
            <div className={classes.SelectRoomTypeTag}>
                <h1>Select Room Type</h1>
            </div>
            <div className={classes.RoomTypeBtnContainer}>
                {roomTypeList.roomTypeList.map((room) => {
                    return (
                        <button
                            type='button'
                            key={room.id}
                            onClick={() => onSelectChangeHandler(room.id)}
                            className={
                                currRoomType === room.id
                                    ? classes.SelectedRoom
                                    : ""
                            }
                        >
                            {room.name}
                        </button>
                    );
                })}
            </div>
        </div>
    );
};

export default RoomTypeComponent;
