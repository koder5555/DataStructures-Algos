class Solution {
    class Pair{
        int x,y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    int[] dx = {-1,0,1,0};
    int[] dy = {0,-1,0,1};

    boolean verify(int[][] grid, int x, int y){
        int n = grid.length;
        int m = grid[0].length;

        return x>=0 && x<n && y>=0 && y<m && grid[x][y]==1;
    }

    int BFS(int[][] grid){
        Queue<Pair>q = new LinkedList<>();
        int fresh = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    q.add(new Pair(i,j));
                }
                else if(grid[i][j]==1){
                    fresh++;
                }
            }
        }

        q.add(new Pair(-1,-1));
        int time = -1;

        while(!q.isEmpty()){
            Pair p = q.poll();
            if(p.x==-1){
                time++;
                if(!q.isEmpty()){
                    q.add(new Pair(-1,-1));
                }
            }
            else{

                for(int i=0;i<4;i++){
                    int x_t = p.x+dx[i];
                    int y_t = p.y+dy[i];
                    if(verify(grid,x_t,y_t)){
                        grid[x_t][y_t]=2;
                        fresh--;
                        q.add(new Pair(x_t, y_t));
                    }
                }
            }
        }
        
        if(fresh!=0)
            return -1;

        return time;
    }


    public int orangesRotting(int[][] grid) {
         return BFS(grid);
    }
}