package 너비우선탐색_BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class boj2234 {
    static int n,m;
    static int [][] arr;
    static int [][] visited;

    static int [] dx = {0,-1,0,1};
    static int [] dy = {-1,0,1,0};

    static int [] bitMasking = {1,2,4,8};

    static int roomNum = 0;
    static int maxRoom = -1;
    static HashMap<Integer,Integer> roomNumAndSize = new HashMap<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m][n];
        visited = new int[m][n];
        for(int i=0; i< m ; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0; j< n ; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i <m ; i++){
            for(int j=0; j<n ; j++){
                if(visited[i][j] == 0) {
                    bfs(i,j,roomNum+1);
                    roomNum+=1;
                }
            }
        }
        int ans = 0;

        for(int i=0; i<m; i++){
            for(int j=0; j<n ; j++) {
                for(int k=0; k<4; k++) {
                    int ni = i + dx[k];
                    int nj = j + dy[k];
                    if(ni < 0 || ni >= m || nj < 0 || nj >=n) continue;
                    if(visited[ni][nj] == visited[i][j]) continue;
                    int a = visited[ni][nj];
                    int b = visited[i][j];
                    ans = Math.max(ans,roomNumAndSize.get(a) + roomNumAndSize.get(b));
                }
            }
        }

        System.out.println(roomNum);
        System.out.println(maxRoom);
        System.out.println(ans);
    }

    public static void bfs(int x,int y,int flag){

        Deque<int []> dq = new LinkedList<>();
        dq.add(new int[] {x,y});
        visited[x][y] = flag;
        int roomCnt = 0;
        while(!dq.isEmpty()){
            int cx,cy;
            int[] pos = dq.poll();
            cx = pos[0];
            cy = pos[1];
            roomCnt +=1 ;

            for(int i=0; i<4 ; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                if(visited[nx][ny] != 0 ) continue;
                if((arr[cx][cy] & bitMasking[i]) == 0) {
                    visited[nx][ny] = flag;
                    dq.add(new int[] {nx,ny});
                }
            }
        }
        maxRoom = Math.max(maxRoom,roomCnt);
        roomNumAndSize.put(flag,roomCnt);
    }
}
