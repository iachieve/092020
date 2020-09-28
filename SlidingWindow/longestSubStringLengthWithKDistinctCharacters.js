//Given a string s, find the length of the longest substring without repeating characters.
// Input: s = "abcabcbb"
// Output: 3
// Explanation: The answer is "abc", with the length of 3.

function trace(str) {
  console.log('=====================');
  console.log(str);
  console.log('=====================');
}

function findLength(str, k){
  let windowStart = 0;
  let maxLength = 0;
  let charFrequencyMap = {};
  for (let windowEnd = 0; windowEnd < str.length; windowEnd++) {
    const char = str[windowEnd];
    if(char in charFrequencyMap){
      charFrequencyMap[char]++;
    }else{
      charFrequencyMap[char] = 1;
    }
    while (charFrequencyMap.kyes.length > k) {
      
    }
  }
}



let arr =