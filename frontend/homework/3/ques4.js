
const jsonInput = '{"firstName":"Alex","lastName":"Hunter","email":"alex@yahoo.com","age":24, "city":"london", "country":"england"}';

const person = JSON.parse(jsonInput, (key, value) => {
            return typeof value == "string" && key != "email"? value.toUpperCase():value;
      })

console.log("Converting json string to object,");
console.log(person);


const jsonString = JSON.stringify(person, (key, value) => {
      return key == "email"? undefined : value;
})

console.log("Converting Object to string,");
console.log(jsonString);