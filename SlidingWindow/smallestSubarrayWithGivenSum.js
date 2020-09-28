// dynamic sliding window

// Smallest subarray with sum greater than a given value
// Given an array of integers and a number x, 
// find the smallest subarray with sum greater than the given value.

function trace(str) {
  console.log('=====================');
  console.log(str);
  console.log('=====================');
}

function smallestSubArray(arr, targetSum) {
  let windowStart = 0;
  let currentWindowSum = 0;
  let minWindowSize = Infinity;
  for (let windowEnd = 0; windowEnd < arr.length; windowEnd++) {
    currentWindowSum += arr[windowEnd];
    while(currentWindowSum >= targetSum){
      minWindowSize = Math.min(minWindowSize, windowEnd - windowStart + 1);
      currentWindowSum -= arr[windowStart];
      windowStart++;
    }

  }
  return minWindowSize;
}




let arr = [4, 2, 1, 7, 8, 1, 2, 8, 1, 0];
console.log(smallestSubArray(arr, 3));