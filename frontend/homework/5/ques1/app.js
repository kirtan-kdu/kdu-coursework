const os = require("os")
const http = require('http');
const fs = require('fs');

const PORT = 5000;


function getOSDetails() {
return new Promise((resolve, reject) => {
      const details = {
      HostName: os.hostname(),
      OperatingSystem: os.platform(),
      Architecture: os.arch(),
      OSRelease: os.release(),
      Uptime: os.uptime(),
      CPUCores: os.cpus().length,
      TotalMemory: os.totalmem(),
      FreeMemory: os.freemem(),
      CurrentWorkingDirectory: process.cwd()
      };
      resolve(details);
});
}

function writeJSONToFile(data) {
      return new Promise((resolve, reject) => {
            const json = JSON.stringify(data, null, 2);
            fs.writeFile('os_details.json', json, 'utf8', (err) => {
            if (err) {
                  reject(err);
                  return;
            }
            console.log("successfully written to file");
            resolve();
            });
      });
}

    // Writing json file on the start of the program
getOSDetails()
      .then((details) => writeJSONToFile(details))
      .then(() => console.log('JSON file created successfully'))
      .catch((error) => console.error('Error:', error));


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

server.listen(PORT, () => {
      console.log(`Server running at http://localhost:${PORT}/`);
});







