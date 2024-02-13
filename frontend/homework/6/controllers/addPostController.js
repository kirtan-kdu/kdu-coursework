const {v4 : uuidv4} = require('uuid')
const fs = require("fs").promises

const addPost = async (req, res) => {
    const {content} = req.body;
    const newPost = {
        id: uuidv4(),
        content
    };
    fs.readFile(`./models/${process.env.FILENAME}`, "utf8")
        .then((databuffer) => JSON.parse(databuffer))
        .then((posts) => {
            posts.push(newPost);
            fs.writeFile(`./models/${process.env.FILENAME}`, JSON.stringify(posts), "utf8");
            res.status(201).json(newPost);
        })
        .catch((error) => res.send({errorMsg: error}));
}

module.exports = addPost;
