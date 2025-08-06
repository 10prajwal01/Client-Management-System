const express= require("express");
const app = express();

app.use(express.json());
//routing
const router = express.Router();

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

router.post('/users',function(req,res){//post
    fetch('http://localhost:3000/users',{
        method :"POST",
        body: JSON.stringify({
            name: req.body.name,
            email:req.body.email,
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
      .then(response => {
        console.log(response);
        res.end(JSON.stringify(response));
      })
})

router.put('/users/:id',function(req,res){
    const id = req.params.id;
    fetch('http://localhost:3000/users/'+id,{
        method :"PUT",
        body: JSON.stringify({
            name: req.body.name,
            email:req.body.email,
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
      .then(response => {
        console.log(response);
        res.end(JSON.stringify(response));
      })
})

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
        res.end("Record Deleted successfully");
});

app.use(router);
app.listen(5001, function(err){
    if(err){
        console.log(err);
    }else{
        console.log("Server running")
    }
})