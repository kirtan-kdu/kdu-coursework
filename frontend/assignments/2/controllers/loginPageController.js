const fs = require("fs").promises


const readJsonFile = async (filePath) => {
    try {
        const data = await fs.readFile(filePath, 'utf8');
        return JSON.parse(data);
    } catch (error) {
        console.error('Error reading file from disk:', error);
    }
};

const checkCredentials = async (filePath, username, password) => {
    const users = await readJsonFile(filePath);
    const user = users.find(u => u.user_name === username && u.password === password);
    return user !== undefined;
};


const userLogin = async (req,res) => {
    const {username, password} = req.body;
    checkCredentials(process.env.userDetailsFilePath, username, password)
    .then(isValid => {
        if (isValid) {
            res.status(200).send({message: 'User credentials are valid.'})
        } else {
            res.status(401).send('Invalid user credentials.');
        }
    })
    .catch(error => console.error('Error checking credentials:', error));
}

module.exports = userLogin;
