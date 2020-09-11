function trace(val) {
  console.log('>>> ===========================');
  console.log(val);
  console.log('>>> ===========================');
}

/* 
  set is like array
  set contains only unique values
*/

const mySet = new Set();
mySet.add(60);
mySet.add(21);
mySet.add(56);
mySet.add(56);

mySet.add({
  name: 'mohamed',
  age: 24
});

mySet.add('decode');
mySet.add(34.44);

trace(mySet.values());

trace("mySet Size: " + mySet.size);

trace('Has 21? ' + mySet.has(21));
trace('Has 99? ' + mySet.has(99));

console.log('deleting 21');
mySet.delete(21);
trace('Has 21? ' + mySet.has(21));


console.log('>>> ========= iterating');
// loop through sets
for (const item of mySet) {
  console.log(item);
}
console.log('>>> ========= END of Iteration');

// convert to Array
const myArray = Array.from(mySet);
trace(myArray);