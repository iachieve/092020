var Stack = function () {
  this.count = 0;
  this.storage = {};

  // adds a value onto the end of the stack
  this.push = function (value) {
    this.storage[this.count] = value;
    this.count++;
  };

  // REMOVES & RETURNS the value at the end of the stack
  this.pop = function () {
    if (this.count === 0) {
      return undefined;
    }
    this.count--;
    var result = this.storage[this.count];
    delete this.storage[this.count];
    return result;
  };

  this.size = function () {
    return this.count;
  };

  // doesn't mutate the stack/array like pop
  this.peek = function (value) {
    return this.storage[this.count - 1];
  };
};


// testing
var myStack = new Stack();
myStack.push(1);
myStack.push('a');
myStack.push('&');
myStack.pop();
console.log(myStack.peek());