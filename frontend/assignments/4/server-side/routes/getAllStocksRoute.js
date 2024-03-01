const express = require("express")
const router = express.Router();

const getAllStocks = require("../controllers/getAllStocksController");

router.get("/stocks", getAllStocks);

module.exports = router;
