function reverse(num){
    return Number(String(num).split('').reverse().join(''))
}

const num = prompt("enter num");
const rev = reverse(num);
console.log(rev);






function rev1(num){
    let res = 0;
    while(num){
        let digit = num%10;
        res = (res*10) +digit;
        num = Math.floor(num/10);
    }
}
console.log(rev1(123));