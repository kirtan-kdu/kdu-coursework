import PortfolioFilter from "../../components/ProtfolioFilter/PortfolioFilter";
import TransactionTable from "../../components/TransactionTable/TransactionTable";
import { createUseStyles } from "react-jss";
import styles from "./PortfolioPageStyles";
const PortfolioPage = () => {
    const useStyles = createUseStyles(styles);
    const classes = useStyles();
    return (
        <section className={classes.portfolioSection}>
            <PortfolioFilter />
            <TransactionTable />
        </section>
    );
};

export default PortfolioPage;
