"use strict"

const dataStore = require("../repository/DataStore");
const fetchWithRetry = require("../utils/fetchWithRetry")


const getTransactionSummary = async (req,res) => {

    if(dataStore.transactionSummary.length !== 0)return res.send(dataStore.transactionSummary);

    // fetch recursively every 100ms
    fetchWithRetry("https://dev-1gyvfva3nqtb0v4.api.raw-labs.com/mock/all-stocks-transactions", 100)
        .then((response) => {
            dataStore.transactionSummary = response;
            return dataStore.transactionSummary;
        })
        .then((allTransactions) => res.send(allTransactions))
        .catch((error) => console.log("error", error))
}

module.exports = getTransactionSummary;
