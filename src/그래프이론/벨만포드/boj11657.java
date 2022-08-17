package 그래프이론.벨만포드;
import java.util.*;
public class boj11657 {
    static Scanner sc = new Scanner(System.in);
    static int n,m,answer= 0;
    static ArrayList<pos> route = new ArrayList<>();
    static long [] dist ;
    public static void main(String[] args) throws Exception {
        input();
        solution();
    }
    static class pos {
        int s,e,d;
        public pos(int s, int e, int d) {
            this.s = s;
            this.e = e;
            this.d = d;
        }
    }
    static public void input() throws Exception{
        n = sc.nextInt();
        m = sc.nextInt();
        for(int i=0; i <m ; i++){
            route.add(new pos(sc.nextInt(), sc.nextInt(), sc.nextInt()));
        }
        dist = new long[n+1];
    }
    static public boolean bell(){
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        for(int i=0; i<n ; i++){
            for(int j=0; j<m ; j++){
                int cur = route.get(j).s,next = route.get(j).e, weight = route.get(j).d;
                if(dist[cur] != Integer.MAX_VALUE && dist[cur] + weight < dist[next]){
                    dist[next] = dist[cur] + weight;
                    if(i == n-1) return true;
                }
            }
        }
        return false;
    }
    static public void solution(){
        if(bell()) System.out.println(-1);
        else{
            for(int i=2; i<=n ; i++){
                if(dist[i] != Integer.MAX_VALUE) System.out.println(dist[i]);
                else System.out.println(-1);
            }
        }
    }
}
