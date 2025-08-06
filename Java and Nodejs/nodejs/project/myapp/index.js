const express= require("express");
const app = express();

//routing
const router = express.Router();

router.get('/', function(req,res){
    console.log("Router Working..");
    res.send("<h2>abrakdarbra</h2>")
    // res.end();
});

router.post('/', function(req,res){
    console.log("Router Working....post");
    res.send("<h2>abrakdarbra</h2>")
    // res.end();
});

app.use(router);
app.listen(5000, function(err){
    if(err){
        console.log(err);
    }else{
        console.log("Server running")
    }
})