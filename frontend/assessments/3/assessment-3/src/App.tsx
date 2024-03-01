import { Provider } from "react-redux";
import "./App.css";
import HomePage from "./pages/HomePage";
import {
    // roomTypeListPersistStore,
    roomTypeListStore,
} from "./redux/RoomTypeListStore";
// import { PersistGate } from "redux-persist/integration/react";

function App() {
    return (
        <Provider store={roomTypeListStore}>
            {/* <PersistGate loading={null} persistor={roomTypeListPersistStore}> */}
            <HomePage />
            {/* </PersistGate> */}
        </Provider>
    );
}

export default App;
