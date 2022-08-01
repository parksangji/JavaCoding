package 유니온파인드;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj10775 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int [] parent;
    static int answer = 0;
    public static int find(int x) {
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    public static void main(String[] args) throws Exception {
        int gate = Integer.parseInt(br.readLine()), plane = Integer.parseInt(br.readLine());
        parent = new int[gate + 1];
        int [] planes = new int[plane];
        for(int i=1; i<= gate; i++) parent[i] = i;

        for(int i=0; i< plane; i++){
            int findDoking = find(Integer.parseInt(br.readLine()));
            if(findDoking == 0) break;
            answer ++;
            parent[findDoking] = parent[findDoking-1];
        }
        System.out.print(answer);
    }
}
