

async function fetchWithRetry(url, delay = 1000) {
    try {
        const response = await fetch(url);
        if (!response.ok) {
            throw new Error(`HTTP error! status: ${response.status}`);
        }
        console.log("Tada! got the results.");
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

module.exports = fetchWithRetry
