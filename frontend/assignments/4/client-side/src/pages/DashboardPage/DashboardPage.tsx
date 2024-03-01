import { useState } from "react";
import "./DashboardPage.scss";
import DashboardTable from "../../components/DashboardTable/DashboardTable";

const DashboardPage = () => {
    const [currentActiveTab, setCurrentActiveTab] = useState("explore");

    const onTabChangeHandler = (tabName: string) =>
        setCurrentActiveTab(tabName);
    return (
        <div className='dashboard-container'>
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
            <DashboardTable />
        </div>
    );
};

export default DashboardPage;
