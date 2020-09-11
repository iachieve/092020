// https://www.youtube.com/watch?v=t2CEgPsws3U

var lettersStack = [];
var word = "racecar";
var rword = "";

// putting lettersStack of word into stack
for (let i = 0; i < word.length; i++) {
  lettersStack.push(word[i]);
}

// pop off the stack in  reverse order
for (let i = 0; i < word.length; i++) {
  rword += lettersStack.pop();
}

console.log(word);
console.log(rword);
if(rword === word){
  console.log(word + " is a palindrome.");
}else{
  console.log(word + " is not a palindrome");
}