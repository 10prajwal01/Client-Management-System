const express= require("express");
const bodyParser = require("body-parser");
const app = express();

//routing
const router = express.Router();
app.use(bodyParser.json());
router.get('/', function(req,res){
    fetch('http://localhost:3000/users')
    .then(response => response.json())
    .then(response => {
        console.log(response);
        res.end(JSON.stringify(response))
    })
    
    // res.end();
});

router.get('/:email', function(req,res){
    const email= req.params.email;
    fetch('http://localhost:3000/users/'+email)
    .then(response => response.json())
    .then(response => {
        console.log(response);
        res.end(JSON.stringify(response))
    })
    
    // res.end();
});

router.post('/users', function(req,res){
    console.log(req.body);
    // fetch("http://localhost:3000/users",{

    //     method:"POST",

    //     body:JSON.stringify({
    //         name: req.body.name,
    //         email:req.body.email,
    //         password: req.body.password,
    //         phoneNumber: req.body.phoneNumber,
    //         age: req.body.age,
    //         information: req.body.information,
    //         password: req.body.password
    //     }),
    //     headers:{
    //         "Content-Type":"application/json"
    //     }
    // }).then(response => response.json())
    // .then(response => console.log(response));
    //     res.end(JSON.stringify(response));

    res.send("data pushed");
});

router.put('/users/:id', function(req,res){
    console.log(req.body);
    const id= req.params.id;
    fetch("http://localhost:3000/users/"+id,{
        method:"PUT",
        body:JSON.stringify({
            name: req.body.name,
            email: req.body.email,
            password: req.body.password,
            phoneNumber: req.body.phoneNumber,
            age: req.body.age,
            information: req.body.information,
            password: req.body.password
        }),
        headers:{
            "Content-Type":"application/json"
        }
    }).then(response => response.json())
    .then(response => console.log(response));
        res.end(JSON.stringify(response));

    res.send("data pushed");
});

router.delete('/users/:id', function(req,res){
    console.log(req.body);
    const id= req.params.id;
    fetch("http://localhost:3000/users/" + id,{
        method:"DELETE",
        headers:{
            "Content-Type":"application/json"
        }
    })
    .then(response => response.json())
    .then(response => console.log(response));
        res.end(JSON.stringify(response));
});

app.use(router);
app.listen(5000, function(err){
    if(err){
        console.log(err);
    }else{
        console.log("Server running")
    }
})