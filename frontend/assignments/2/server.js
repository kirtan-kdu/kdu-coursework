const session = require('express-session')
const uid = require('uid-safe').sync;
const express = require("express")
const cors = require("cors")
const socketio = require("socket.io")
const http = require("http")
const postsRoute = require("./routes/postsRoute")
const loginPageRouter = require("./routes/loginPageRoute")
const fs = require("fs");
const app = express();
const server = http.createServer(app);
require("dotenv").config();

app.use(express.static('public'))
app.use(session({
    secret: 'twitter_clone',
    resave: false,
    saveUninitialized: true,
    cookie: {
        domain: "http://localhost:5500",
        secure: false,
        maxAge:  200000
    },
    genid: function(req) {
        return uid(24);
    }
}))

app.use(cors());
app.use(express.json())
app.set('json spaces', 5);

const io = new socketio.Server(server,{
    cors:{
        origin:"http://localhost:5500"
    }
});

let onlineUsersData = [];
io.on("connection",(socket)=>{

    socket.on("new-user", (username) => {
        console.log("new connection joined");
        socket.emit("online-users", onlineUsersData)
        onlineUsersData.push(username);
        socket.broadcast.emit("online-users", [username]);
        console.log(username, " is connected");
    })


  socket.on('disconnect', (username) => {
    onlineUsersData = onlineUsersData.filter(user => user !== username);
    console.log(username, " is disconnected");
  });


    socket.on("message",(payload)=>{
        console.log("payload:",payload);
        io.except(socket.id).emit('new-message',payload);
    })
})

server.listen(process.env.PORT, () => {
    console.log(`Server is connected: http://localhost:${process.env.PORT}`);
})


app.use("/api/posts", postsRoute)
app.use("/api/users", loginPageRouter)
