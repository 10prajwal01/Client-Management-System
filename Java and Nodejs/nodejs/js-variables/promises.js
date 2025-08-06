const count = true;

let countValue = new Promise(fuction(resp,err){
    if(count){
        resp("There is a count value");
    }else{
        err("There is no count value");
}
});
console.log(countValue);