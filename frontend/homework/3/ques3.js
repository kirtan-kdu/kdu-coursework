var shoes = [
  {
    type: "shoe",
    color: "Black",
    size: "Medium",
    price: 1199,
  },
  {
    type: "shoe",
    color: "White",
    size: "Large",
    price: 1899,
  },
];

var shirts = [
  {
    type: "shirt",
    color: "Blue",
    size: "Small",
    price: 699,
  },
  {
    type: "shirt",
    color: "Yellow",
    size: "Medium",
    price: 1599,
  },
  {
    type: "shirt",
    color: "Red",
    size: "Large",
    price: 1049,
  },
];

var warehouse = [...shirts , ...shoes];


console.log("Warehouse at start,");
console.log(warehouse);

const calculatePrice = (warehouse) => {
  return warehouse.reduce((totalCost, currItem) => totalCost + currItem.price, 0);
}

console.log("Total price of all the items is " + calculatePrice(warehouse));

warehouse.sort((a,b) => a.price - b.price);

console.log("Warehouse items after sorting based on price,");
console.log(warehouse);




