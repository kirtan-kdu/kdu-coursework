import PortfolioFilter from "../../components/ProtfolioFilter/PortfolioFilter";
import "./PortfolioPage.scss";
import TransactionTable from "../../components/TransactionTable/TransactionTable";
const PortfolioPage = () => {
    return (
        <section className='portfolio-section'>
            <PortfolioFilter />
            <TransactionTable />
        </section>
    );
};

export default PortfolioPage;
