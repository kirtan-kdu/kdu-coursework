import "./App.css";
import { Provider } from "react-redux";
import { persistedStore, store } from "./redux/Stores";
import HeaderComponent from "./components/HeaderComponent/HeaderComponent";
import ToDoComponent from "./components/ToDoContainer/ToDoComponent";
import { PersistGate } from "redux-persist/integration/react";

function App() {
    return (
        <Provider store={store}>
            <PersistGate loading={null} persistor={persistedStore}>
                <HeaderComponent />
                <ToDoComponent />
            </PersistGate>
        </Provider>
    );
}

export default App;
