/**
 * BFS graph coloring
 */

class Solution {

    boolean BFS(int[][] graph, int src, int[]color){
        color[src] = 1;
        Queue<Integer> q = new LinkedList<>();
        q.add(src);

        while(!q.isEmpty()){
            int node = q.poll();
            int new_color = (color[node]==1)?2:1;
            for(int c:graph[node]){
                if(color[c]==0){
                    color[c]=new_color;
                    q.add(c);
                }else if(color[c]==color[node]){
                    return false;
                }
            }
        }

        return true;
    }

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        
        for(int i=0;i<n;i++){
            if(color[i]==0){
                if(!BFS(graph,i,color))
                    return false;
            }
        }

        return true;
    }
}