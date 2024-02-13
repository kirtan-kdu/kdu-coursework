const AWS = require('aws-sdk');
const fs = require('fs');

const s3 = new AWS.S3({
    accessKeyId: 'your-access-key-id',
    secretAccessKey: 'your-secret-access-key'
});


const uploadTOBucket = (fileName) => {
    return new Promise((resolve, reject) => {
        const fileContent = fs.readFileSync(fileName);

        const params = {
            Bucket: process.env.S3_BUCKET,
            Key: fileName,
            Body: fileContent,
        };

        s3.upload(params, (error, data) => {
            if (error) {
                reject(error)
            }

            resolve(data);

        });
    })

};


module.exports = uploadTOBucket;

