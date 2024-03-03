import StockPriceGraph from "../../components/StockPriceGraph/StockPriceGraph";
import StockPriceHistory from "../../components/StockPriceHistory/StockPriceHistory";
import "./StockPage.scss";

const StockPage = () => {
    return (
        <section className='main-container'>
            <StockPriceGraph />
            <StockPriceHistory />
        </section>
    );
};

export default StockPage;
