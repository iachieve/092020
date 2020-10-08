/**
 * A hamiltonian path: in an undirected graph is
 * a path that visits every node exactly once
 * 
 * Hamiltonian cycle: the first node AND the last node
 * of the path are the same vertexes
 * Start Point = End Point
 * 
 * Determining whether such paths and cycles exist in graph
 * is Hamiltonian problem
 * 
 * This is a NP-complete complete problem, NO POLYNOMIAL SOLUTION
 * 
 * Dirac-principle: a simple graph with N vertices is hamiltonian
 * if every vertex has degree N/2 or greater (degree is the number
 * of edges of a vertex)
 * 
 * Important fact: finding Hamiltonian path is NP-Complete, but
 * can decide whether such path exists in linear time complexity
 * with topological ordering 
 * 
 * solutions:
 * Naive Approach: 
 *     SOLUTION #1:
 *    - generate all possible configurations of the vertices and
 *      print a configuration that satisfies the given constraints
 *    -> problem: if the graph has N vertices, there N! configurations
 *      so the solution space is enormous
 * 
 *    SOLUTION #2
 *    - constructing a tree
 *      ->we start at the root node, and want to get to one of 
 *        the good leaves
 *      ->If we get to a bad leaf: we just backtrack and keep 
 *        moving on by revoking our most recent choice.
 *      ->The tree is an abstract model of the possible sequences
 *        of choices we could make
 *      ->Here we do depth-first search on the tree
 *      -> Problem: hard to construct a tree in N is big!!!
 * 
 *    SOLUTION #3
 *      - Backtracking
 *      -> we use recursion to solve the problem
 *      -> create an empty path array and add vertex 0
 *          to it as the starting vertex
 *      -> Add other vertices, starting from the vertex 1
 *      -> Before adding a vertex, check whether it is 
 *        adjacent to the previously added vertex + make
 *        sure it is not already added
 *       -> If we find such a vertex => we add the vertex as part
 *          of the solution
 *      -> If we do not find a vertex => we return false
 */

package BackTracking.HamiltonianCycle;

public class HamiltonianCycle {
  private int[][] adjacentMatrix;
  private int numOfVertexes;
  private int[] hamiltonianPath; // path indexes

  public HamiltonianCycle(int[][] adjacentMatrix) {
    this.adjacentMatrix = adjacentMatrix;
    // HAMILTONIAN LENGTH MUST EQUAL THE NUMBER OF VERTEXES
    this.hamiltonianPath = new int[adjacentMatrix.length];
    this.numOfVertexes = adjacentMatrix.length;
    // FIRST NODE IN HAMILTONIAN PATH IS FIXED TO AVOID PATH REPETITION
    this.hamiltonianPath[0] = 0;
  }

  public void solve(){
    // we'll start from the second vertex
    // because we already checked the first vertex in prev line
    if (findFeasibleSolution(1)) {
      showHamiltonianPath();
    } else {
      System.out.println("No Feasible Solution...");
    }
  }

  // POSITION: INDEX IN HAMILTONIAN PATH 
  private boolean findFeasibleSolution(int position) {
    // this means we have traversed all vertexes
    if (position == numOfVertexes) {
      // comparing the first vertex with the last vertex
      // in the Hamiltonian path

      // last vertex in the hamiltonian path should be connected directly
      // to the first vertex to conform a hamiltonian cycle
      if (adjacentMatrix[hamiltonianPath[position - 1]][hamiltonianPath[0]] == 1) {
        return true;
      }
    }
    // start from the second index
    for (int vertexIdx = 1; vertexIdx < numOfVertexes; vertexIdx++) {
      if(isFeasible(vertexIdx, position)){
        hamiltonianPath[position] = vertexIdx;
        if(findFeasibleSolution(position+1)){
          return true;
        }
        // backtrack
      }
    }
    return false;
  }

  private boolean isFeasible(int vertexIdx, int actualPosition) {
    // first criterion: whether two nodes are connected?
    if(adjacentMatrix[hamiltonianPath[actualPosition-1]][vertexIdx] == 0){
      return false;
    }
    // second criterion: whether we have visited it or not
    for (int i = 0; i < actualPosition; i++) {
      if(hamiltonianPath[i] == vertexIdx){
        return false;
      }
    }

    return true;
  }

  private void showHamiltonianPath() {
    System.out.println("Hamiltonian Cycle:");
    for (int i = 0; i < hamiltonianPath.length; i++)
      System.out.println(hamiltonianPath[i] + " ");

    System.out.println(hamiltonianPath[0]);
  }
}
