"use strict"

const dataStore = require("../repository/DataStore")
const fetchWithRetry = require("../utils/fetchWithRetry")


const getAllStocks = async(req,res) => {

    if(dataStore.stocks.length !== 0)return res.send(dataStore.stocks);

    // fetch recursively every 100ms
    fetchWithRetry("https://dev-1gyvfva3nqtb0v4.api.raw-labs.com/mock/stocks", 100)
        .then((response) => {
            dataStore.stocks = response;
            return dataStore.stocks;
        })
        .then((stocks) => res.json(stocks))
        .catch((error) => console.log("error", error))
}

module.exports = getAllStocks
