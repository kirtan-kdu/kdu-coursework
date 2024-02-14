const express = require("express")
const cors = require("cors")
const socketio = require("socket.io")
const http = require("http")

const port = 5000;
const app = express();
const httpServer = http.createServer(app);

app.use(cors());

httpServer.listen(port, () => {
    console.log(`Server is connected: http://localhost:${port}`);
})


