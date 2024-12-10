class Solution {
    void DFS(List<List<Integer>> res, int[][] graph, boolean[] visited, List<Integer> path, int cur, int des) {
        path.add(cur);
        visited[cur] = true;
        if (cur == des) {
            res.add(new LinkedList<>(path));
        } else {
            for (int c : graph[cur]) {
                if (!visited[c]) {
                    DFS(res, graph, visited, path, c, des);
                }
            }
        }
        path.removeLast();
        visited[cur] = false;
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> res = new LinkedList<>();
        DFS(res, graph, new boolean[n], new LinkedList<>(), 0, n - 1);
        return res;

    }
}