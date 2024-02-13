const fs = require("fs").promises;


const getPost = async (req, res) => {

    const reqId = req.params.id;
    fs.readFile(`./models/${process.env.FILENAME}`, "utf8")
        .then((posts) => JSON.parse(posts))
        .then((posts) => posts.filter((post) => post.id === reqId))
        .then((post) => {
            if(post)res.status(200).json(post);
            else res.status(404).send({message: "requested post not found"});
        })
        .catch((error) => res.send({error: error}));
}

const getAllPosts = async(req, res) => {
    fs.readFile(`./models/${process.env.FILENAME}`, "utf8")
        .then((posts) => res.status(200).send(posts))
        .catch((error) => res.send({error: error}));
}

module.exports = {getPost, getAllPosts}
