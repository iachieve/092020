/**
 * Coloring problem
 * => NP-Complete problem!!! ~ exponential running time
 * => problem: coloring the vertices of a graph such that no two 
 *    adjacent vertices share the same color
 *  => the smallest number of colors needed to color a graph G
 *      is called chromatic number
 * 
 *  => there may be more than one solution: for example we can color
 *      a graph with 4 vertices in 12 ways with 3 colors
 * 
 *  ### Bipartite graphs
 *    => determining if a graph can be colored with 2 colors is equivalent 
 *      to determining whether or not the graph is bipartite, and thus
 *      computable in linear time using BFS
 *    => Bipartite graph: a graph whose vertices can be divided into
 *      two disjoint sets U and V (U and V are independent sets) such that 
 *      every edge connects a vertex in U to one in V
 * 
 *  ## Making schedules
 *    => we want to make an exam schedule for a university. we have different
 *      subjects and different students enrolled on every subject.
 *      Many subjects would have common students.
 *    => How do we schedule the exam so that no two exams with a common students
 *      are scheduled at the same time? How many minimum time slots are needed 
 *      to schedule all exams?
 *    => this problem can be represented as a graph where every vertexes is
 *      a subject and an edge between two vertices means there is a common
 *      student. So this is a graph coloring problem where minimum number of 
 *      time slots is equal to the chromatic number of the graph
 * 
 *      ## radio frequency assignment
 *      => when frequencies are assigned to towers, frequencies assigned to all
 *        towers at the same location myst be different because of the interference.
 *        => How to assign frequencies with this constraints? what is the minimum
 *          number of frequencies needed?
 *        => This problem is also an instance of graph coloring problem where 
 *          every tower represents a vertex and an edge between tow towers represents
 *          that they are in range of each other
 * 
 *      ## register allocation
 *          => in compiler -> register allocation is the process of assigning
 *            a large number of target program variables onto a small number of
 *            CPU registers
 * 
 *        ## Map coloring
 *        => we want to construct a map of countries or states where adjacent
 *          countries or states can not be assigned the same color.
 *        => four colors are sufficient to color any map (four color theorem)
 *      
 *      ### solution
 *        # Greedy approach -> finds the solution but not the most optimal one
 *          it may uses more colors than necessary !!!
 *         # Powell-Welsh algorithm -> relies on sorting the nodes according to
 *           the degrees + we start assigning colors to the nodes with the 
 *            most neighbors
 *      # Backtracking
 *        => we assign colors one by one to different vertices starting from
 *          the first vertex (optional)
 *        => Before assigning a color -> we check for safety by considering
 *            already assigned colors to the adjacent vertices
 *        => if we find a color assignment which is feasible -> we mark the color
 *            assignment as part of solution
 *        => if we do not find a color due to clashes -> we backtrack
 *        
 */
package BackTracking.ColoringProblem;

public class Algorithm {
  private int numOfVertexes;
  private int numOfColors;
  private int[] colors;
  private int[][] adjacencyMatrix;

  public Algorithm(int[][] adjacencyMatrix, int numOfColors){
    this.adjacencyMatrix = adjacencyMatrix;
    this.numOfColors = numOfColors;
    this.numOfVertexes = adjacencyMatrix.length;
    this.colors = new int[numOfVertexes];
  }

  public void solve(){
    if(solveProblem(0)){
      showResults();
    }else{
      System.out.println("no solution...");
    }
  }

  private boolean solveProblem(int nodeIdx) {
    if(nodeIdx == numOfVertexes){
      return true;
    }
    for (int colorIdx = 0; colorIdx <= numOfColors; colorIdx++) {
      if(isColorValid(nodeIdx, colorIdx)){
        colors[nodeIdx] = colorIdx;
        if(solveProblem(nodeIdx + 1)){
          return true;
        }
        // backtrack
      }
    }
    return false;
  }

  private boolean isColorValid(int nodeIdx, int colorIdx) {
    for (int i = 0; i < numOfVertexes; i++) {
      if(adjacencyMatrix[nodeIdx][i] == 1 && colorIdx == colors[i]){
        return false;
      }
    }
    return true;
  }

  private void showResults() {
    for (int i = 0; i < numOfVertexes; i++) {
      System.out.println("node " + (i+1) + " has color index: " + colors[i]);
    }
  }

}
