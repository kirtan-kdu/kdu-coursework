import { CategoryScale } from "chart.js/auto";
import { BarElement, Chart, LinearScale, Title, Tooltip } from "chart.js";
import { Bar } from "react-chartjs-2";
import zoomPlugin from "chartjs-plugin-zoom";

import "./BarGraph.scss";
import { socket } from "../../Socket";
import { useParams } from "react-router-dom";
import { useEffect, useRef, useState } from "react";

Chart.register(
    CategoryScale,
    LinearScale,
    BarElement,
    Title,
    Tooltip,
    zoomPlugin
);

interface IBarDataset {
    data: number[];
    backgroundColor: string[];
    borderColor: string;
    borderWidth: number;
    barThickness: number;
}

interface IGraphDataset {
    labels: string[];
    datasets: IBarDataset[];
}

const BarGraph = () => {
    const { stockName } = useParams();

    const lastPrice = useRef(0);
    const [dataset, setDataset] = useState<IGraphDataset>({
        labels: [],
        datasets: [
            {
                data: [],
                backgroundColor: [],
                borderColor: "black",
                borderWidth: 1,
                barThickness: 40,
            },
        ],
    });

    useEffect(() => {
        const handleNewStockPrice = (payload: number) => {
            console.log("recieved");
            setDataset((prevstate) => {
                const newDataset = {
                    labels: [
                        ...prevstate.labels,
                        `${prevstate.labels.length + 1}`,
                    ],
                    datasets: [
                        {
                            ...prevstate.datasets[0],
                            data: [...prevstate.datasets[0].data, payload],
                            backgroundColor: [
                                ...prevstate.datasets[0].backgroundColor,
                                lastPrice.current < payload
                                    ? "#b2f2bb"
                                    : "#ffc9c9",
                            ],
                        },
                    ],
                };
                lastPrice.current = payload;
                return newDataset;
            });
        };
        socket.on(stockName!, handleNewStockPrice);
    }, [stockName]);

    return (
        <div className='chart-container'>
            <div
                className='chart-wrapper'
                style={{
                    width: `${dataset.datasets[0].data.length * 5}rem`,
                    minWidth: "100%",
                }}
            >
                <Bar
                    data={dataset}
                    options={{
                        responsive: true,
                        maintainAspectRatio: false,
                        plugins: {
                            legend: {
                                display: false,
                            },
                        },
                    }}
                />
            </div>
        </div>
    );
};

export default BarGraph;
