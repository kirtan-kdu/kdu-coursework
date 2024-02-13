const { error } = require('console');
const path = require('path');

const filePaths = [
      'dir1/dir2/file1.txt',
      'dir1/dir3/file2.txt',
      'dir1/dir3/file3.md',
      'dir4/file4.jpg',
      'dir4/file5.pdf',
];

const extractFileInfo = (filePath) => {
      return new Promise((resolve,reject) => {
            try{
                  const fileInfo = {
                        extension: path.extname(filePath),
                        baseName: path.basename(filePath),
                        directory: path.dirname(filePath)
                  }
                  resolve(fileInfo);
            }
            catch(error){
                  reject(error)
            }
      });
}

function processFilePaths(filePaths) {
      const filePromises = filePaths.map((filePath) => {
      return extractFileInfo(filePath);
      });

      return Promise.all(filePromises);
}


processFilePaths(filePaths)
      .then((fileInfoArray) => {
            console.log(fileInfoArray);
      })
      .catch((error) => {
      console.error('Error:', error);
});

