package 너비우선탐색_BFS;
import java.io.*;
import java.util.*;

public class boj2589 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static class pos{
        int x,y,value;
        public pos(int x,int y, int value){
            this.x = x;
            this.y = y;
            this.value = value;
        }
    }
    static int n,m,ans=0;
    static char [][] board;
    static int [] dx = {0,0,-1,1};
    static int [] dy = {-1,1,0,0};
    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new char[n][m];

        for(int i=0; i <n ; i++){
            String tmp = br.readLine();
            for(int j=0; j< m ; j++){
                board[i][j] = tmp.charAt(j);
            }
        }

        for(int i=0; i < n ; i++){
            for(int j=0; j<m ; j++){
                if(board[i][j] == 'L'){
                    bfs(i,j);
                }
            }
        }

        System.out.print(ans);
    }

    public static void bfs(int x,int y){

        Queue<pos> q = new LinkedList<>();
        boolean [][] visited = new boolean[n][m];
        q.add(new pos(x, y, 0));
        visited[x][y] = true;
        while(!q.isEmpty()){
            pos p = q.poll();
            int xx = p.x, yy= p.y, d = p.value;
            ans = Math.max(d,ans);
            for(int i=0; i<4; i++){
                int nx = xx + dx[i],ny = yy + dy[i], nd = d + 1;
                if(nx < 0 || nx >= n || ny < 0 || ny >=m) continue;
                if(visited[nx][ny] || board[nx][ny] == 'W') continue;

                visited[nx][ny] = true;
                q.add(new pos(nx, ny, nd));
            }
        }
    }
}
