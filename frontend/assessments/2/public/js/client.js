
const socket = io("http://localhost:5000");

const priceValue = document.querySelector(".value");
const priceValueChange = document.querySelector(".value-change")
const barGraphContainer = document.querySelector(".bar-graph-container")
const buyButton = document.querySelector(".buy-btn");
const sellButton = document.querySelector(".sell-btn");
const inputquantity = document.querySelector(".quantity-input")
const transactionList = document.querySelector(".right-main")

const updateSharePrice = (newPrice) => {
    console.log(newPrice);
    let currPrice = priceValue.textContent;
    currPrice = currPrice.substring(0, currPrice.length - 2)
    console.log(currPrice);

    const newPriceChange = Math.round((newPrice - currPrice)/  currPrice * 100 * 100) / 100;
    const newBar = document.createElement("div");
    newBar.style.height = `${newPrice}px`
    newBar.classList.add("bar-graph");
    newPriceChange >= 0 ? newBar.classList.add("up"): newBar.classList.add("down");
    if (newPriceChange >=  0) {
        priceValue.classList.add("up");
        priceValue.classList.remove("down");
        priceValueChange.classList.add("up");
        priceValueChange.classList.remove("down");
    priceValue.innerHTML = newPrice +  ` &#8593;`;

    } else {
    priceValue.innerHTML = newPrice +  ` &#8595;`;

        priceValue.classList.add("down");
        priceValue.classList.remove("up");
        priceValueChange.classList.add("down");
        priceValueChange.classList.remove("up");
    }


    priceValueChange.textContent = newPriceChange + "%";
    barGraphContainer.appendChild(newBar);
}


socket.on("zomato", (price) => updateSharePrice(price));


window.onload = () => {

    fetch("http://localhost:5000/statup/data")
    .then(response => {
        if (!response.ok) {
        throw new Error(`HTTP error! status: ${response.status}`);
        }
        return response.json();
    })
    .then(data => {
        data[0].forEach(value => updateSharePrice(value));
        data[1].forEach(transaction => generateTransaction(transaction.type, transaction.amount, transaction.time, false))
    })
    .catch(error => {
        console.log('There was a problem with the fetch operation: ' + error.message);
    });

}


const generateTransaction = (transactionClass, amount, time, flag) => {

        const newTransaction = document.createElement("div");
        newTransaction.classList.add("transaction")
        const transactionInfo = document.createElement("div");
        transactionInfo.classList.add("transaction-info");
        const stockQuantity = document.createElement("h2");
        stockQuantity.textContent = `${amount} Stocks`;

        inputquantity.value = "";
        stockQuantity.classList.add("quantity");
        const buyTime = document.createElement("h3");

        buyTime.textContent = time
        transactionInfo.appendChild(stockQuantity)
        transactionInfo.appendChild(buyTime)

        const transactionType = document.createElement("div");
        transactionType.classList.add("transaction-type");
        const tradeType = document.createElement("h1");
        tradeType.textContent = transactionClass
        tradeType.classList.add(transactionClass)
        transactionType.appendChild(tradeType);

        newTransaction.appendChild(transactionInfo);
        newTransaction.appendChild(transactionType);

        transactionList.appendChild(newTransaction);
    const transactionObj = {amount: amount, time: time, type: transactionClass}
        if(flag){
    console.log("Successfully added")

            fetch("http://localhost:5000/transaction/add", {
                method: "POST",
                body: JSON.stringify(transactionObj),
                headers: {
                  "Content-type": "application/json; charset=UTF-8"
                }
              })
                .then((response) => response.json())
                .then((json) => console.log(json));
        }
}

buyButton.addEventListener("click", () => generateTransaction("Buy", inputquantity.value, (new Date(Date.now())).toUTCString(), true))
sellButton.addEventListener("click", () => generateTransaction("Sell", inputquantity.value, (new Date(Date.now())).toUTCString(), true))




