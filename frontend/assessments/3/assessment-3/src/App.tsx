import { Provider } from "react-redux";
import "./App.css";
import HomePage from "./pages/HomePage";
import { roomTypeListStore } from "./redux/RoomTypeListStore";

function App() {
    return (
        <Provider store={roomTypeListStore}>
            <HomePage />
        </Provider>
    );
}

export default App;
