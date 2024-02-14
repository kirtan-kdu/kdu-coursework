const express = require("express")
const cors = require("cors")
const socketio = require("socket.io")
const http = require("http")

const port = 5000;
const app = express();
const server = http.createServer(app);

app.use(cors());
app.use(express.json())

server.listen(port, () => {
    console.log(`Server is connected: http://localhost:${port}`);
})

const io = new socketio.Server(server,{
    cors:{
        origin:"http://127.0.0.1:5500/public/index.html"
    }
});

io.on("connection",(socket)=>{

    console.log("New user connected");

    io.emit("new-message","Hey all! Someone joined KDU Chat App")

    socket.on("message",(payload)=>{
        console.log("payload:",payload);
        io.except(socket.id).emit('new-message',payload);
    })
})


