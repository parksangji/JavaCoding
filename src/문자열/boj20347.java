package 문자열;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class boj20347 {
    static int ansMin;
    static int ansMax;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bf.readLine());

        for(int i=0; i < t; i ++){

            String st = bf.readLine();
            int num = Integer.parseInt(bf.readLine());
            ansMax = 1;
            ansMin = st.length();
            if(solution(num,st)) System.out.printf("%d %d\n",ansMin,ansMax);
            else System.out.println(-1);

        }
    }

    public static boolean solution(int num,String st){

        List<Integer>[] list = new ArrayList[26];

        for(int i=0; i<26; i++){
            list[i] = new ArrayList<>();
        }
        for(int i=0; i<st.length(); i++) {
            int index = st.charAt(i) - 'a';
            list[index].add(i);
        }
        boolean flag = false;
        for(List<Integer> l : list){
            if(l.isEmpty() || l.size() < num) continue;
            flag = true;
            for(int i=0; i<= l.size() - num ; i++){
                int len = l.get(i+num-1) - l.get(i) + 1;
                ansMax = Math.max(ansMax,len);
                ansMin = Math.min(ansMin,len);
            }
        }

        return flag;
    }
}
