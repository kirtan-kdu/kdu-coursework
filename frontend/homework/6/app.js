const express = require("express")
const app = express();
const getPostRoute = require("./routes/getPostRoute")
const addPostRoute = require("./routes/addPostRoute")
require("dotenv").config();
const PORT = 5000;

app.use(express.json());
app.set('json spaces', 5); // to pretify json response


app.listen(process.env.PORT, (req, res) => {
    console.log
    (
          "Server is listening on,",
          `http://localhost:${process.env.PORT}`
    );
});

app.use("/get", getPostRoute);
app.use("/add", addPostRoute);

app.all("*", (req, res) => {
    res.status(404).json({ message: "Bad Gateway" });
});
