const os = require("os")
const fs = require('fs');


const OSDetails = () => {
    return new Promise((resolve, reject) => {
            try{
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
            }
            catch(error){
                reject(error);
        }
    });
}


function writeJSONToFile(data) {
    return new Promise((resolve, reject) => {
        const json = JSON.stringify(data, null, 2);
        fs.writeFile(process.env.FILENAME, json, 'utf8', (err) => {
        if (err) {
                reject(err);
                return;
        }
        console.log("Successfully written to file");
        resolve();
        });
    });
}

module.exports = {OSDetails, writeJSONToFile};
