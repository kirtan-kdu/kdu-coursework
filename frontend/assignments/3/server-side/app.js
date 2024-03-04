const express = require("express")
const cors = require("cors")
const socketio = require("socket.io")
const http = require("http")

const port = 5000;
const app = express();
const server = http.createServer(app);

const GetStockDetailsRoute = require("./routes/getAllStocksRoute")

app.use(cors());
app.use(express.json())

const io = new socketio.Server(server,{
    cors:{
        origin:"http://localhost:5173"
    }
});

const liveStocks = []


io.on("connection",(socket)=>{

    console.log("New user connected");

    io.emit("new-user", "a new user joined")

    socket.on("get-price", (payload) => {
        socket.join(payload)
        if(liveStocks.includes(payload))return;
        liveStocks.push(payload);
        console.log("joined room by ", payload);

        setInterval(() => {
            const price = Math.floor((Math.random() * 500) + 1);
            io.to(payload).emit(payload, price)
            console.log("New price sent: " + price + " to " + payload);
        }, 1000);
    })


    socket.on("graph", (payload) => console.log(payload))


    socket.on("new-transaction",(payload)=>{
        console.log("payload:",payload);
        io.emit("add-transaction", payload)
    })
})

server.listen(port, () => {
    console.log(`Server is connected: http://localhost:${port}`);
})


app.use("/get", GetStockDetailsRoute);

app.all("*", (req, res) => {
    res.status(404).json({ message: "Bad Gateway" });
});
