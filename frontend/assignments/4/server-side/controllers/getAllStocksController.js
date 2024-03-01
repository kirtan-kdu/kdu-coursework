async function fetchWithRetry(url, delay = 1000) {
    try {
        const response = await fetch(url);
        if (!response.ok) {
            throw new Error(`HTTP error! status: ${response.status}`);
        }
        return await response.json();
    }
    catch (error) {
        console.error(`Fetch failed with error: ${error.message}`);
        console.log(`Retrying in ${delay / 1000} seconds...`);
        return new Promise((resolve, reject) => {
        setTimeout(() => {
            fetchWithRetry(url, delay).then(resolve).catch(reject);
        }, delay);
    });
    }
}


const getAllStocks = async(req,res) => {

    fetchWithRetry("https://dev-1gyvfva3nqtb0v4.api.raw-labs.com/mock/stocks", 100)
        .then((response) => res.json(response))
        .catch((error) => console.log("error", error))

}

module.exports = getAllStocks
