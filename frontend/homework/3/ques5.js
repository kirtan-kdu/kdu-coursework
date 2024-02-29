const player = {
      "firstName": "Leo",
      "lastName": "Messi",
      "address": {
        "country": "Spain",
        "city": "Barcelona",
      },
      "careerInfo": {
        "fcBarcelona": {
          "appearances": 780,
          "goals": {
            "premierLeagueGoals": 590,
            "championsLeagueGoals": 50,
          },
        },
      },
    };


const getListOfKeysNValues = (object) => {
      let listOfKeys = [], listOfValues = [];
      for(const [key, value] of Object.entries(object)){
            if(typeof value == "object"){
                  listOfKeys.push(key)
                  const recursiveValues = getListOfKeysNValues(object[key]);
                  listOfKeys = [...listOfKeys, ...recursiveValues[0]];
                  listOfValues = [...listOfValues, ...recursiveValues[1]];
            }
            else{
                  listOfKeys.push(key);
                  listOfValues.push(value);
            } 
      }
      return [listOfKeys, listOfValues];
}



const [listOfKeys, listOfValues] = getListOfKeysNValues(player);


console.log("Keys of the object are,");
console.log(listOfKeys);

console.log("Values of the object are, ");
console.log(listOfValues);
