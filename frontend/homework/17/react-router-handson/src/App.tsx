import "./App.css";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import ProductsList from "./components/ProductsList/ProductsList.tsx";
import PageNotFound from "./components/PageNotFound/PageNotFound";
import Product from "./components/Product/Product.tsx";
import Navbar from "./components/Navbar/Navbar.tsx";
import { Provider } from "react-redux";
import { ProductListPersistStore, productListStore } from "./redux/Store.ts";
import { PersistGate } from "redux-persist/integration/react";

function App() {
    return (
        <Provider store={productListStore}>
            <PersistGate loading={null} persistor={ProductListPersistStore}>
                <BrowserRouter>
                    <Routes>
                        <Route
                            path='/'
                            element={
                                <>
                                    <Navbar enableFilter={true} />
                                    <ProductsList />
                                </>
                            }
                        ></Route>
                        <Route
                            path='/product/:id'
                            element={
                                <>
                                    <Navbar enableFilter={false} />
                                    <Product />
                                </>
                            }
                        ></Route>
                        <Route path='*' element={<PageNotFound />}></Route>
                    </Routes>
                </BrowserRouter>
            </PersistGate>
        </Provider>
    );
}

export default App;
