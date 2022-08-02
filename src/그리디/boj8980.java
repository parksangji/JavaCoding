package 그리디;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj8980 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int answer = 0;
    static int N,C, M;
    static class truck implements Comparable<truck>{
        int cur,next,size;
        public truck(int cur, int next, int size) {
            this.cur = cur;
            this.next = next;
            this.size = size;
        }

        @Override
        public int compareTo(truck other) {
            if(next == other.next){
                return cur - other.cur;
            }
            return next - other.next;
        }
    }

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(br.readLine());

        truck[] trucks = new truck[M];

        for(int i = 0 ; i< M ; i++){
            st = new StringTokenizer(br.readLine());
            trucks[i] = new truck(Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())
                    ,Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(trucks,0,M);

        int [] boxs = new int[N+1];

        for(int i=1; i< boxs.length; i++){
            boxs[i] = C;
        }

        for(int i=0; i < M ; i++){
            truck t = trucks[i];
            int maxC = Integer.MAX_VALUE;
            for(int j= t.cur; j < t.next; j ++){
                maxC = Math.min(maxC,boxs[j]);
            }

            if(maxC >= t.size){
                for(int j=t.cur; j< t.next; j++){
                    boxs[j] -= t.size;
                }
                answer += t.size;
            }else{
                for(int j=t.cur; j< t.next; j++){
                    boxs[j] -= maxC;
                }
                answer += maxC;
            }
        }
        System.out.println(answer);
    }
}
