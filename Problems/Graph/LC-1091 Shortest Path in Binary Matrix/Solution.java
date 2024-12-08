class Solution {
    int[] dx = new int[] { -1, 0, 1, 0, 1, 1, -1, -1 };
    int[] dy = new int[] { 0, -1, 0, 1, 1, -1, 1, -1 };

    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] == 1)
            return -1;
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        q.add(new int[] { 0, 0, 1 });
        visited[0][0] = true;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int step = cur[2];
            if (cur[0] == (n - 1) && cur[1] == (m - 1))
                return step;

            for (int i = 0; i < 8; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if ((nx >= 0 && nx < n && ny >= 0 && ny < m) && !visited[nx][ny]
                        && grid[nx][ny] == 0) {
                    visited[nx][ny] = true;
                    q.add(new int[] { nx, ny, step + 1 });
                }

            }
        }

        return -1;
    }
}