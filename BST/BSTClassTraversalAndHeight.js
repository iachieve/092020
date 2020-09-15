// binary search tree has two branches for every node
// ordered: each left subtree is less that or equal to the parent node
// each right subtree is greater than or equal to the parent node
/*
           50
       /        \
      17         72
     / \         / \
   12   23      54  76
  / \     \      \
 9   14    19     67

*/

class Node {
  constructor(data, left = null, right = null) {
    this.data = data;
    this.left = left;
    this.right = right;
  }
}

class BST {
  constructor() {
    this.root = null;
  }
  add(data) {
    const node = this.root; // removable?
    if (node === null) {
      this.root = new Node(data);
      return;
    } else {
      const searchTree = function (node) { // extractable?
        if (data < node.data) {
          if (node.left === null) {
            node.left = new Node(data);
            return;
          } else if (node.left !== null) {
            return searchTree(node.left);
          }
        } else if (data > node.data) {
          if (node.right === null) {
            node.right = new Node(data);
            return;
          } else if (node.right !== null) {
            return searchTree(node.right);
          }
        } else {
          return null;
        }
      };
      return searchTree(node);
    }
  }

  findMin() {
    let current = this.root;
    while (current.left !== null) {
      current = current.left;
    }
    return current.data;
  }

  findMax() {
    let current = this.root;
    while (current.right !== null) {
      current = current.right;
    }
    return current.data;
  }

  find(data) {
    let current = this.root;
    while (current.data !== data) {
      if (data < current.data) {
        current = current.left;
      } else {
        current = current.right;
      }
      if (current === null) {
        return null;
      }
    }
    return current;
  }

  isPresent(data) {
    let current = this.root;
    while (current) {
      if (data === current.data) {
        return true;
      }
      if (data < current.data) {
        current = current.left;
      } else {
        current = current.right;
      }
    }
    return false;
  }

  // delete operation has 3 possible cases:
  // 1- leaf node : deletion won't affect the rest of the tree
  // 2- 1 child : child node takes the node place
  // 3- 2 children : the next higher node takes the node place

  remove(data) {
    const removeNode = function (node, data) {
      if (node === null) {
        return null;
      }

      // if we found the node we have three options
      if (data === node.data) {
        // case 1: leaf node
        if (!node.left && !node.right) {
          return null;
        }
        // case 2: one child node
        // node has no left
        if (node.left === null) {
          return node.right;
        }
        // node has no right child
        if (node.right === null) {
          return node.left;
        }
        // case 3: node has two children
        var tempNode = node.right;
        while (tempNode.left !== null) {
          tempNode = tempNode.left;
        }
        node.data = tempNode.data;
        node.right = removeNode(node.right, tempNode.data);
        return node;
      }

      else if (data < node.data) {
        node.left = removeNode(node.left, data);
        return node;
      } else {
        node.right = removeNode(node.right, data);
        return node;
      }
    };
    this.root = removeNode(this.root, data);
  }

  // min height: the distance between the root node and
  // the first leaf node without two children
  findMinHeight(node = this.root) {
    if (node == null) {
      return -1;
    }
    let left = this.findMinHeight(node.left);
    let right = this.findMinHeight(node.right);
    if (left < right) {
      return left + 1;
    } else {
      return right + 1;
    }
  }

  // max height: the distance between the root node and the last leaf
  findMaxHeight(node = this.root) {
    if (node === null) {
      return -1;
    }
    let left = this.findMaxHeight(node.left);
    let right = this.findMaxHeight(node.right);
    if (left > right) {
      return left + 1;
    } else {
      return right + 1;
    }
  }

  // is balanced: 
  isBalanced() {
    return (this.findMinHeight() >= this.findMaxHeight() - 1)
  }
  // traversing DFS & BFS tree is O(N)
  // DFS: go as deeply as possible before going to the next subtree
  // DFS 1: inorder: Left-> Root -> Right
  inOrder() {
    if (!this.root) return null;
    let result = new Array();
    function TraverseInOrder(node) {
      node.left && TraverseInOrder(node.left);
      result.push(node.data);
      node.right && TraverseInOrder(node.right);
    }
    TraverseInOrder(this.root);
    return result;
  }
  // DFS 2: PreOrder: Root -> Left -> Right
  preOrder() {
    if (!this.root) return null;
    let result = new Array();
    function TraverseInOrder(node) {
      result.push(node.data);
      node.left && TraverseInOrder(node.left);
      node.right && TraverseInOrder(node.right);
    }
    TraverseInOrder(this.root);
    return result;
  }
  // DFS 3: PostOrder: Left -> right -> root, leaf nodes before the root
  postOrder() {
    if (!this.root) return null;
    let result = new Array();
    function TraverseInOrder(node) {
      node.left && TraverseInOrder(node.left);
      node.right && TraverseInOrder(node.right);
      result.push(node.data);
    }
    TraverseInOrder(this.root);
    return result;
  }

  // BFS: level by level
  levelOrder() {
    let result = [];
    let Q = [];
    if (this.root) {
      Q.push(this.root);
      while (Q.length > 0) {
        let node = Q.shift();
        result.push(node.data);
        if (node.left) {
          Q.push(node.left);
        };
        if (node.right) {
          Q.push(node.right);
        };
      };
      return result;
    } else {
      return null;
    }
  }

}

// const bst = new BST();

// bst.add(9);
// bst.add(4);
// bst.add(17);
// bst.add(3);
// bst.add(6);
// bst.add(22);
// bst.add(5);
// bst.add(7);
// bst.add(20);
// console.log(bst.findMin());
// console.log(bst.findMax());
// bst.remove(22);
// console.log(bst.findMin());
// console.log(bst.findMax());

const bst = new BST();

bst.add(9);
bst.add(4);
bst.add(17);
bst.add(3);
bst.add(6);
bst.add(22);
bst.add(5);
bst.add(7);
bst.add(20);

console.log(bst.findMinHeight());
console.log(bst.findMaxHeight());
console.log(bst.isBalanced());
bst.add(10);
console.log(bst.findMinHeight());
console.log(bst.findMaxHeight());
console.log(bst.isBalanced());
console.log('inOrder: ' + bst.inOrder());
console.log('preOrder: ' + bst.preOrder());
console.log('postOrder: ' + bst.postOrder());

console.log('levelOrder: ' + bst.levelOrder());