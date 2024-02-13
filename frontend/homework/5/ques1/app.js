const http = require('http');
const express = require("express")
const app = express();
const fs = require("fs")
const detaisRoute = require("./route")
const {OSDetails, writeJSONToFile} = require("./os-details.js");
const uploadTOBucket = require('./upload-s3.js');

require("dotenv").config();
const PORT = 5000;
app.use(express.json());
app.set('json spaces', 5); // to pretify json response





/* ------ Code for storing data locally as well as to s3 bucket ------ */
OSDetails()
      .then((details) => writeJSONToFile(details))
      .then(() => console.log('JSON file created successfully', process.env.AWS_ACCESS_KEY_ID, process.env.AWS_SECRET_ACCESS_KEY))
      .then(() => uploadTOBucket('os-details.json'))
      .then(() => console.log(`File uploaded to S3 bucket with name ${process.env.AWS_ACCESS_KEY_ID}`))
      .then(() => fs.unlink(process.env.FILENAME))
      .catch((error) => console.error('Error:', error));


/*
const server = http.createServer((req, res) => {
      if (req.method === 'GET' && req.url === '/get-details') {
      fs.readFile('os_details.json', 'utf8', (err, data) => {
            if (err) {
                  res.writeHead(500, { 'Content-Type': 'text/plain' });
                  res.end('Internal Server Error');
                  return;
            }
            res.writeHead(200, { 'Content-Type': 'text/plain' });
            const response = `Hello, my name is Assistant!\n\nHere is my system information:\n\n${data}`;
            res.end(response);
      });
      } else {
            res.writeHead(404, { 'Content-Type': 'text/plain' });
            res.end('Invalid request');
      }
});
*/


app.listen(process.env.PORT, (req, res) => {
      console.log
      (
            "Server is listening on,",
            `http://localhost:${process.env.PORT}`
      );
});

/* there is just one route */
// app.use("", detaisRoute);

app.all("*", (req, res) => {
      res.status(404).json({ message: "Bad Gateway" });
});







