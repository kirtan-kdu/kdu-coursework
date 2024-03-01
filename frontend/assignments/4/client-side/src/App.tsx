import { BrowserRouter, Route, Routes } from "react-router-dom";
import "./App.css";
import DashboardPage from "./pages/DashboardPage/DashboardPage";
import Navbar from "./components/Navbar/Navbar";
import { StockMarketStore } from "./redux/StockMarketStore";
import { Provider } from "react-redux";
import PortfolioPage from "./pages/PortfolioPage/PortfolioPage";

function App() {
    return (
        <Provider store={StockMarketStore}>
            <BrowserRouter>
                <Navbar />
                <Routes>
                    <Route path='/' element={<DashboardPage />} />
                    <Route path='/portfolio' element={<PortfolioPage />} />
                </Routes>
            </BrowserRouter>
        </Provider>
    );
}

export default App;
