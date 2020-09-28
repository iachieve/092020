// fixed window technique

// Largest Sum Contiguous Subarray
// find the sum of contiguous subarray 
// within a one-dimensional array of numbers which has the largest sum.

function trace(str) {
  console.log('=====================');
  console.log(str);
  console.log('=====================');
}



// function maxSumSubArray(arr, subArrayLen) {
//   let maxValue = -Infinity;
//   let currentRunningSum = 0;
//   for (let i = 0; i < arr.length; i++) {
//     currentRunningSum += arr[i];
//     if (i >= subArrayLen - 1) {
//       maxValue = Math.max(maxValue, currentRunningSum);
//       currentRunningSum -= arr[i - (subArrayLen - 1)];
//     }
//   }
//   return maxValue;
// }

// arr is array of integer
// k is max sub array length
function maxSumSubArray(arr, k){
  let currentRunningSum = 0;
  let maxSum = -Infinity;
  for (let i = 0; i < arr.length; i++) {
    currentRunningSum += arr[i];
    if(i >= (k -1)){
      // updated maxSum if it needs update
      maxSum = Math.max(maxSum, currentRunningSum);
      currentRunningSum -= arr[i - (k- 1)];
    }
  }
  return maxSum;
}

let arr = [4, 2, 1, 7, 8, 1, 2, 8, 1, 0];
console.log(maxSumSubArray(arr, 3));
