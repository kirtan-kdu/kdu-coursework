import { createUseStyles } from "react-jss";
import StockPriceGraph from "../../components/StockPriceGraph/StockPriceGraph";
import StockPriceHistory from "../../components/StockPriceHistory/StockPriceHistory";
import styles from "./StockPage";

const StockPage = () => {
    const useStyles = createUseStyles(styles);
    const classes = useStyles();
    return (
        <section className={classes.mainContainer}>
            <StockPriceGraph />
            <StockPriceHistory />
        </section>
    );
};

export default StockPage;
