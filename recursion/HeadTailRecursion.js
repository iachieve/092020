function headRecursion(n = 4){
  if(n === 0) return;
  headRecursion(n - 1);
  console.log(n);
}
headRecursion();
// 1 2 3 4 
console.log('---------');

function tailRecursion(n = 4){
  if(n === 0) return;
  console.log(n);
  tailRecursion(n - 1);
}
// 4 3 2 1 
// tail recursion is like iteration
tailRecursion();
