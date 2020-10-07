function headRecursion(num = 4){
  if(num === 0) return;
  console.log(num);
  headRecursion(num - 1);
}
headRecursion();


/*

headRecursion(1) 1
headRecursion(2) 2
headRecursion(3) 3
headRecursion(4) 4

*/