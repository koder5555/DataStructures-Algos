class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(color!=image[sr][sc]){
            int prevColor = image[sr][sc];
            image[sr][sc]  = color;

            Queue<int[]> q = new LinkedList<>();
            q.add(new int[]{sr,sc});
            int[] dr = new int[] {-1,0,1,0};
            int[] dc = new int[] {0,-1,0,1};

            int m = image.length;
            int n = image[0].length;

            while(!q.isEmpty()){
                int[] p = q.poll();

                for(int i=0;i<4;i++){
                    int r_t = p[0]+dr[i];
                    int c_t = p[1]+dc[i];

                    if(r_t>=0 && r_t<m && c_t>=0 && c_t<n && image[r_t][c_t]==prevColor){
                        image[r_t][c_t] = color;
                        q.add(new int[]{r_t,c_t});
                    }
                }
            }

        }
        
        return image;        
    }
}