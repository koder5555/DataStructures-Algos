class Solution {
    int[] dx = new int[] { -1, 0, 1, 0 };
    int[] dy = new int[] { 0, -1, 0, 1 };

    void BFS(int[][] heights, Queue<int[]> q, boolean[][] visited) {
        int n = heights.length;
        int m = heights[0].length;
        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if ((nx >= 0 && nx < n && ny >= 0 && ny < m) && !visited[nx][ny]
                        && heights[nx][ny] >= heights[cur[0]][cur[1]]) {
                    visited[nx][ny] = true;
                    q.add(new int[] { nx, ny });
                }

            }
        }

    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        Queue<int[]> q1 = new LinkedList<>();
        Queue<int[]> q2 = new LinkedList<>();
        boolean[][] visited1 = new boolean[n][m];
        boolean[][] visited2 = new boolean[n][m];

        for (int i = 0; i < m; i++) {
            q1.add(new int[] { 0, i });
            visited1[0][i] = true;
        }

        for (int i = 0; i < n; i++) {
            q1.add(new int[] { i, 0 });
            visited1[i][0] = true;
        }

        BFS(heights, q1, visited1);

        for (int i = 0; i < m; i++) {
            q2.add(new int[] { n - 1, i });
            visited2[n - 1][i] = true;
        }

        for (int i = 0; i < n - 1; i++) {
            q2.add(new int[] { i, m - 1 });
            visited2[i][m - 1] = true;
        }

        BFS(heights, q2, visited2);

        List<List<Integer>> ret = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited1[i][j] && visited2[i][j]) {
                    List<Integer> l = new LinkedList<>();
                    l.add(i);
                    l.add(j);
                    ret.add(l);
                }
            }
        }

        return ret;

    }
}