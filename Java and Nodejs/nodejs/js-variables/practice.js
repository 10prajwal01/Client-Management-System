function delayCallback(callback){
    setTimeout(callback,2000,1,3);
}

function mycallback(a,b){
    console.log(a+b);
}
delayCallback(mycallback);

const prompt = require('prompt-sync')();
const name = prompt("hello");
console.log(`${name}`);





setTimeout(()=>callback(1,2),2000)