class Solution {
    private static final int RED = 1;
    private static final int BLUE = 2;

    class Edge {
        int to;
        int color;

        Edge(int to, int color) {
            this.to = to;
            this.color = color;
        }
    }

    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        int src = 0;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        List<List<Edge>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < redEdges.length; i++) {
            adj.get(redEdges[i][0]).add(new Edge(redEdges[i][1], RED));
        }

        for (int i = 0; i < blueEdges.length; i++) {
            adj.get(blueEdges[i][0]).add(new Edge(blueEdges[i][1], BLUE));
        }

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { src, -1, 0 });
        res[src] = 0;
        if (n == 1)
            return res;
        boolean[][] visited = new boolean[n][3];
        visited[0][1] = visited[0][2] = true;

        while (!q.isEmpty()) {
            int[] node = q.poll();
            boolean update = false;

            for (Edge e : adj.get(node[0])) {
                if (!visited[e.to][e.color] && node[1] != e.color) {
                    if (res[e.to] == -1) {
                        res[e.to] = node[2] + 1;

                    }
                    q.add(new int[] { e.to, e.color, node[2] + 1 });
                    visited[e.to][e.color] = true;

                }
            }

        }

        for (int i = 0; i < n; i++) {
            if (res[i] == Integer.MAX_VALUE)
                res[i] = -1;
        }

        return res;
    }
}