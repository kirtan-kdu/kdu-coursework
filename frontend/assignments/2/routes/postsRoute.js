const express = require("express")
const router = express.Router();

const {getPosts, getPostById} = require("../controllers/postsController");

router.get("", getPosts);

module.exports = router;
