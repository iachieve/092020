/**
 * A hamiltonian path: in an undirected graph is
 * a path that visits every node exactly once
 * 
 * Hamiltonian cycle: the first node and the last node
 * of the path are the same vertexes
 * Start Point = End Point
 * 
 * Determining whether such paths and cycles exist in graph
 * is Hamiltonian problem
 * 
 * This is a NP-complete complete problem
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
  
}
