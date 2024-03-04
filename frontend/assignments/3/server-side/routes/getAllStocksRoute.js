const express = require("express")
const router = express.Router();

const getAllStocks = require("../controllers/getAllStocksController");
const {getAllTransactions, getUniqueCompanies} = require("../controllers/getAllTransactoinsController");
const getTransactionSummary = require("../controllers/getTransactionSummaryController");

router.get("/stocks", getAllStocks);
router.get("/transactions", getAllTransactions)
router.get("/unique/companies", getUniqueCompanies)
router.get("/transactions/all", getTransactionSummary)

module.exports = router;
