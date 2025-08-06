const http = require("http");
const server = http.createServer((req,res) => {
    res.writeHead(200, {'Content-Type' : 'text/html'});
    res.end('<h2> Welcome to Node!! </h2>')
});

server.listen(5000,() =>{
    console.log("Server is up and running")
});