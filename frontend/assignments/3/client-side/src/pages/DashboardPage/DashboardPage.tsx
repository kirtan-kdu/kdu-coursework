import { useState } from "react";
import DashboardTable from "../../components/DashboardTable/DashboardTable.tsx";
import { createUseStyles } from "react-jss";
import styles from "./DashboardPageStyles.ts";

const DashboardPage = () => {
    const useStyles = createUseStyles(styles);
    const classes = useStyles();
    const [currentActiveTab, setCurrentActiveTab] = useState<string>("explore");

    const onTabChangeHandler = (tabName: string) =>
        setCurrentActiveTab(tabName);
    return (
        <div className={classes.dashboardContainer}>
            <section className='dashboard-tabs-container'>
                <button
                    className={`dashboard-tabs-btn ${
                        currentActiveTab === "explore" &&
                        "dashboard-tabs-active-btn"
                    }`}
                    onClick={() => onTabChangeHandler("explore")}
                >
                    Explore
                </button>
                <button
                    className={`dashboard-tabs-btn ${
                        currentActiveTab === "watchlist" &&
                        "dashboard-tabs-active-btn"
                    }`}
                    onClick={() => onTabChangeHandler("watchlist")}
                >
                    My WatchList
                </button>
            </section>
            <DashboardTable activeTab={currentActiveTab} />
        </div>
    );
};

export default DashboardPage;
