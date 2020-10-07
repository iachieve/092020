// Original Solution
function binarySearch(arr, elem) {
    var start = 0;
    var end = arr.length - 1;
    var middle = Math.floor((start + end) / 2);

    while(arr[middle] !== elem && start <= end) {
        if(elem < arr[middle]){
            end = middle - 1;
        } else {
            start = middle + 1;
        }
        middle = Math.floor((start + end) / 2);
    }
    
    if(arr[middle] === elem){
        return middle;
    }
    return -1;
}

// Refactored Version
function binarySearch(arr, elem) {
    var start = 0;
    var end = arr.length - 1;
    var middle = Math.floor((start + end) / 2);
    while(arr[middle] !== elem && start <= end) {
        if(elem < arr[middle]) end = middle - 1;
        else start = middle + 1;
        middle = Math.floor((start + end) / 2);
    }
    return arr[middle] === elem ? middle : -1;
}


function binarySearch2(arr, x, start, end){
    if(start > end) return false;
    let mid = Math.floor((start + end) / 2);
    if(arr[mid === x]) return true;
    if(arr[mid] > x) 
        return binarySearch2(arr, x, start, mid - 1);
    else
        return binarySearch2(arr, x, mid + 1, end);
}

binarySearch([2,5,6,9,13,15,28,30], 103);
