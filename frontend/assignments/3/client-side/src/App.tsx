import { BrowserRouter, Route, Routes } from "react-router-dom";
import "./App.css";
import DashboardPage from "./pages/DashboardPage/DashboardPage";
import Navbar from "./components/Navbar/Navbar";
import { StockMarketStore } from "./redux/StockMarketStore";
import { Provider } from "react-redux";
import PortfolioPage from "./pages/PortfolioPage/PortfolioPage";
import StockPage from "./pages/StockPage/StockPage";
import SummarizerPage from "./pages/SummarizerPage/SummarizerPage";

function App() {
    return (
        <Provider store={StockMarketStore}>
            <BrowserRouter>
                <Navbar />
                <Routes>
                    <Route path='/' element={<DashboardPage />} />
                    <Route path='/portfolio' element={<PortfolioPage />} />
                    <Route path='/stock/:stockName' element={<StockPage />} />
                    <Route path='/summarizer' element={<SummarizerPage />} />
                </Routes>
            </BrowserRouter>
        </Provider>
    );
}

export default App;
