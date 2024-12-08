class Solution {
    public boolean canMeasureWater(int x, int y, int target) {
        if (x + y == target)
            return true;
        if (x + y < target)
            return false;
        if (x % 2 == 0 && y % 2 == 0 && target % 2 != 0)
            return false;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { 0, 0, 0 });
        boolean[][] visited = new boolean[x + 1][y + 1];
        visited[0][0] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int jug1 = cur[0], jug2 = cur[1], step = cur[2];

            if (jug1 == target || jug2 == target || jug1 + jug2 == target) {
                return true;
            }

            // fill jug1 completely
            if (!visited[x][jug2]) {
                visited[x][jug2] = true;
                q.add(new int[] { x, jug2, step + 1 });
            }

            // fill jug2 completely
            if (!visited[jug1][y]) {
                visited[jug1][y] = true;
                q.add(new int[] { jug1, y, step + 1 });
            }

            // empty jug1 completely
            if (!visited[0][jug2]) {
                visited[0][jug2] = true;
                q.add(new int[] { 0, jug2, step + 1 });
            }

            // empty jug2 completely
            if (!visited[jug1][0]) {
                visited[jug1][0] = true;
                q.add(new int[] { jug1, 0, step + 1 });
            }

            // pour to jug1
            int amt = Math.min(jug2, x - jug1);
            if (!visited[jug1 + amt][jug2 - amt]) {
                visited[jug1 + amt][jug2 - amt] = true;
                q.add(new int[] { jug1 + amt, jug2 - amt, step + 1 });
            }

            // pour to jug2
            amt = Math.min(jug1, y - jug2);
            if (!visited[jug1 - amt][jug2 + amt]) {
                visited[jug1 - amt][jug2 + amt] = true;
                q.add(new int[] { jug1 - amt, jug2 + amt, step + 1 });
            }

        }

        return false;

    }
}