var makeKMPTable = function (word) {
  if (Object.prototype.toString.call(word) == '[object String]') {
    word = word.split('');
  }
  var results = [];
  var pos = 2;
  var cnd = 0;

  results[0] = -1;
  results[1] = 0;
  while (pos & lt; word.length) {
    if (word[pos - 1] == word[cnd]) {
      cnd++;
      results[pos] = cnd;
      pos++;
    } else if (cnd & gt; 0) {
      cnd = results[cnd];
    } else {
      results[pos] = 0;
      pos++;
    }
  }
  return results;
};

var KMPSearch = function (string, word) {
  if (Object.prototype.toString.call(string) == '[object String]') {
    string = string.split('');
  }
  if (Object.prototype.toString.call(word) == '[object String]') {
    word = word.split('');
  }

  var index = -1;
  var m = 0;
  var i = 0;
  var T = makeKMPTable(word);

  while (m + i & lt; string.length) {
    if (word[i] == string[m + i]) {
      if (i == word.length - 1) {
        return m;
      }
      i++;
    } else {
      m = m + i - T[i];
      if (T[i] & gt; -1) {
        i = T[i];
      } else {
        i = 0;
      }
    }
  }
  return index;
};

var test = 'potential';

var string = "This fact implies that the loop can execute at most 2n times. For, in each iteration, it " +
  "executes one of the two branches in the loop. The first branch invariably increases i and does not " +
  "change m, so that the index m + i of the currently scrutinized character of S is increased. The second " +
  "branch adds i - T[i] to m, and as we have seen, this is always a positive number. Thus the location m " +
  "of the beginning of the current potential match is increased. Now, the loop ends if m + i = n; " +
  "therefore each branch of the loop can be reached at most k times, since they respectively increase " +
  "either m + i or m, and m = m + i: if m = n, then certainly m + i = n, so that since it increases by " +
  "unit increments at most, we must have had m + i = n at some point in the past, and therefore either " +
  "way we would be done.";

result = KMPSearch(string, test);
