const express = require("express")
const router = express.Router();

const addPost = require("../controllers/addPostController");

router.post("/", addPost);

module.exports = router;
