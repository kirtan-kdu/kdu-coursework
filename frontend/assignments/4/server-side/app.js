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
        origin:"http://127.0.0.1:5173"
    }
});


io.on("connection",(socket)=>{

    // socket.join("zomato");

    console.log("New user connected");

    // setInterval(() => {

    //     // Randomly generating price
    //     const price = Math.floor((Math.random() * 500) + 1);
    //     io.to("zomato").emit("zomato", price)
    //     console.log("New price sent: " + price);
    // }, 5000);



    // socket.on("message",(payload)=>{
    //     console.log("payload:",payload);
    //     io.except(socket.id).emit('new-message',payload);
    // })
})

server.listen(port, () => {
    console.log(`Server is connected: http://localhost:${port}`);
})

// const pastData = [[145, 129, 298, 298, 232 ], [{amount: "121", time: "Fri, 2 Feb 1996 21:04:05 GMT", type: "Buy"},{amount: "28", time: "Mon, 13 Feb 1990 21:04:05 GMT", type: "Sell"}]];


// app.get('/statup/data', (req, res) => {
//     res.send(pastData);
//   });

// app.post('/transaction/add', (req,res) => {
//     pastData[1].push(req.body);
//     console.log(pastData);
//     res.send({msg: "Successfully added"})
// })

app.use("/get", GetStockDetailsRoute);

app.all("*", (req, res) => {
    res.status(404).json({ message: "Bad Gateway" });
});
