import "./App.css";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import ProductsList from "./components/ProductsList/ProductsList.tsx";
import PageNotFound from "./components/PageNotFound/PageNotFound";
import Product from "./components/Product/Product.tsx";
import Navbar from "./components/Navbar/Navbar.tsx";
import { ProductListProvider } from "./contexts/ProductListProvider";
import { FilterParamsProvider } from "./contexts/FilterParamsProvider";

function App() {
    return (
        <ProductListProvider>
            <BrowserRouter>
                <Routes>
                    <Route
                        path='/'
                        element={
                            <FilterParamsProvider>
                                <>
                                    <Navbar enableFilter={true} />
                                    <ProductsList />
                                </>
                            </FilterParamsProvider>
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
        </ProductListProvider>
    );
}

export default App;
