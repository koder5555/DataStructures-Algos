/**
 * Solution through traansitive clossure of graph
 * Given a directed graph, find out if a vertex v 
 * is reachable from another vertex u for all vertex 
 * pairs (u, v) in the given graph. Here reachable means 
 * that there is a path from vertex u to v. The reach-ability 
 * matrix is called transitive closure of a graph.
 */



class Solution {
    void dfsUtil(boolean[][] dep, List<List<Integer>> adj, int s,int e ){
        dep[s][e]=true;

        for(int c:adj.get(e)){
            if(!dep[s][c])
                dfsUtil(dep,adj,s, c);
        }
    }
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        boolean[][] dep = new boolean[numCourses][numCourses];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<prerequisites.length;i++){
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        
        for(int i=0;i<numCourses;i++){
            dfsUtil(dep,adj, i,i);
        }
        
        List<Boolean> res = new LinkedList<>();

        for(int i=0;i<queries.length;i++){
            res.add(dep[queries[i][0]][queries[i][1]]);
        }


        return res;
    }
}