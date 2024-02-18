const fs = require('fs');



const getPosts = async ( req, res) => {

  const page = parseInt(req.query.page) ||   1;
  const pageSize = parseInt(req.query.pageSize) ||   5;
  const skip = ((page -   1) * pageSize ) % 5;

  fs.readFile(process.env.postDetailsFilePath, 'utf8', (err, data) => {
    if (err) {
      return res.status(500).json({ error: err.message });
    }

    let posts;
    try {
      posts = JSON.parse(data);
    } catch (error) {
      return res.status(500).json({ error: 'Error parsing JSON file.' });
    }

    const paginatedPosts = posts.slice(skip, skip + pageSize);
    const totalPosts = posts.length;
    const totalPages = Math.ceil(totalPosts / pageSize);

    res.json({
      page,
      totalPages,
      totalPosts,
      posts: paginatedPosts
    });
  })
}



const getPostById = async (req, res) => {
  const postId = req.params.id;

  fs.readFile(process.env.postDetailsFilePath, 'utf8', (err, data) => {
    if (err) {
      console.error(err);
      return res.status(500).json({ error: 'Internal server error' });
    }

    try {
      const posts = JSON.parse(data);
      const post = posts.find(p => p.id === postId);

      if (post) {
        res.json(post);
      } else {
        res.status(404).json({ error: `Post with ID ${postId} not found` });
      }
    } catch (error) {
      console.error(error);
      res.status(500).json({ error: 'Invalid JSON data' });
    }
  });
};



module.exports = {getPosts, getPostById}
