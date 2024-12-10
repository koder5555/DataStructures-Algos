class Solution {
    class Edge {
        int to;
        int sign;

        Edge(int to, int sign) {
            this.to = to;
            this.sign = sign;
        }
    }

    public int minReorder(int n, int[][] connections) {
        ArrayList<HashSet<Edge>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new HashSet<>());
        }
        for (int i = 0; i < connections.length; i++) {
            adj.get(connections[i][0]).add(new Edge(connections[i][1], 1));
            adj.get(connections[i][1]).add(new Edge(connections[i][0], 0));
        }

        boolean[] vis = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        int res = 0;
        q.add(0);
        vis[0] = true;
        while (!q.isEmpty()) {
            int e = q.poll();
            for (Edge c : adj.get(e)) {
                if (!vis[c.to]) {
                    res += c.sign;
                    vis[c.to] = true;
                    q.add(c.to);
                }
            }
        }
        return res;
    }
}