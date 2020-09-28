// fixed window technique

// Largest Sum Contiguous Subarray
// find the sum of contiguous subarray 
// within a one-dimensional array of numbers which has the largest sum.

function trace(str) {
  console.log('=====================');
  console.log(str);
  console.log('=====================');
}
function maxSumSubArray(arr, subArrayLen) {
  let maxValue = -Infinity;
  let currentRunningSum = 0;
  for (let i = 0; i < arr.length; i++) {
    currentRunningSum += arr[i];
    if (i >= subArrayLen - 1) {
      maxValue = Math.max(maxValue, currentRunningSum);
      currentRunningSum -= arr[i - (subArrayLen - 1)];
    }
  }
  return maxValue;
}

let arr = [4, 2, 1, 7, 8, 1, 2, 8, 1, 0];
console.log(maxSumSubArray(arr, 3));
//========================