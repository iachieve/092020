function factorial(num){
    if(num === 1) return 1;
    return num * factorial(num-1);
}

function factorial2(acc = 1, num = 4){
    if(num === 1) return acc;
    return factorial2(acc * num, num - 1);
}

console.log(factorial2(1, 5));