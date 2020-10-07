// Euclidean Algorithm

function iterativeGCD(x = 10, y = 45 ){
  while(y !== 0){
    let t = y;  // t, y = 45 // t = 5
    y = y % x;  // y = 5    //  y = 5%
    x = t;      // x = 45
  }
  return x;
}

console.log(iterativeGCD());



function recursiveGCD(x = 10, y = 45){
  if(y === 0) return;
  return recursiveGCD(y, x % y);
}