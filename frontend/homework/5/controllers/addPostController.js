const { randomUUID } = require("crypto");


const addPost = async (req, res) => {
    const newPost = {
        id: randomUUID();
    }
}

module.exports = addPost;
