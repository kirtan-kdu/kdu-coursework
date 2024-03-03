"use strict"

const dataStore = require("../repository/DataStore")
const fetchWithRetry = require("../utils/fetchWithRetry")


const getAllTransactions = async (req, res) => {

    if(dataStore.transactions.length !== 0)return res.send(dataStore.transactions);

    // fetch recursively every 100ms
    fetchWithRetry("https://dev-1gyvfva3nqtb0v4.api.raw-labs.com/mock/portfolio-transactions", 100)
        .then((response) => {
            dataStore.transactions = response;
            dataStore.transactions.sort((transactionA, transactionB) => new Date(transactionB.timestamp) - new Date(transactionA.timestamp))
            return dataStore.transactions;
        })
        .then((sortedTransactions) => res.send(sortedTransactions))
        .catch((error) => console.log("error", error))
}


const getUniqueCompanies = async (req,res) => {

    if(dataStore.uniqueCompanies.length !== 0)return res.send(dataStore.uniqueCompanies)

    if(dataStore.transactions.length === 0 ){
        await fetchWithRetry("https://dev-1gyvfva3nqtb0v4.api.raw-labs.com/mock/portfolio-transactions", 100)
        .then((response) => {
            dataStore.transactions = response;
            dataStore.transactions.sort((transactionA, transactionB) => new Date(transactionB.timestamp) - new Date(transactionA.timestamp))
        })
    }

    dataStore.uniqueCompanies = [...new Set(dataStore.transactions.map(transaction => transaction.stock_name))];
    res.send(dataStore.uniqueCompanies);

}

module.exports = {getAllTransactions, getUniqueCompanies}

