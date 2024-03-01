import { createUseStyles } from "react-jss";
import { useDispatch, useSelector } from "react-redux";
import { DispatchType, RootState } from "../redux/RoomTypeListStore";
import { addAddons } from "../redux/Slice/CurrentRoomDetails";

const styles = {
    AddOnsContainer: {
        margin: "2rem",
        width: "80vw",
    },
    SelectAddOnsTag: {
        backgroundColor: "#F08A5D",
        padding: "1.5rem 3rem",
        borderRadius: "1rem",
        fontSize: "1.5rem",
        color: "white",
    },
    AddOnsBtnContainer: {
        display: "flex",
        marginTop: "1rem",
        "& button": {
            margin: "0 1rem",
            padding: "1rem 2rem",
            fontSize: "1.1rem",
            borderRadius: "1rem",
        },
    },
    SelectedAddon: {
        border: "2px solid #F08A5D",
        color: "#F08A5D",
    },
    noRoomTag: {
        fontSize: "1.5rem",
        padding: "1rem 2rem",
    },
};
const AddOnsComponent = () => {
    const useStyles = createUseStyles(styles);
    const { roomId, preferences } = useSelector(
        (state: RootState) => state.currRoomDetailReducer
    );
    const roomTypeList = useSelector(
        (state: RootState) => state.productListReducer.roomTypes
    );

    const reduxDispatch: DispatchType = useDispatch();
    const classes = useStyles();

    const onClickChangeHandler = (addOnName: string) => {
        reduxDispatch(addAddons(addOnName));
    };
    return (
        <div className={classes.AddOnsContainer}>
            <div className={classes.SelectAddOnsTag}>
                <h1>Select additional addons / preferences</h1>
            </div>
            {roomId === 0 ? (
                <h1 className={classes.noRoomTag}>Please select room type</h1>
            ) : (
                <div className={classes.AddOnsBtnContainer}>
                    {roomTypeList.roomTypeList[roomId - 1].addOns.map(
                        (addOn) => {
                            return (
                                <button
                                    onClick={() =>
                                        onClickChangeHandler(addOn.name)
                                    }
                                    key={addOn.name}
                                    className={
                                        preferences.find(
                                            (addon) => addon === addOn.name
                                        )
                                            ? classes.SelectedAddon
                                            : ""
                                    }
                                >
                                    {addOn.name}
                                </button>
                            );
                        }
                    )}
                </div>
            )}
        </div>
    );
};

export default AddOnsComponent;
