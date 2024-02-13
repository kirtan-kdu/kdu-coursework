const express = require("express")
const router = express.Router();

const {getPost, getAllPosts} = require("../controllers/getPostController");

router.get("/all", getAllPosts);
router.get("/:id", getPost);

module.exports = router;
