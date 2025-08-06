function validation(age){
    
    if(age<=18){
        console.log("I am kid");
    }else{
        console.log("I am a adult");
    }
}

function Track(a){
    console.log("having many kids like")
    for(var i=0;i<=a;i++){
        console.log("Kid number " + i)
    }
}

function genderVal(l){
    switch(l){
        case 1:{
            console.log("He is male")
            break;
        }
        case 2:{
            console.log("She is female")
            break;
        }
        default:
            console.log("They are LGBTQ")
            break;
    }
}
validation(16)
Track(10)
genderVal(1)