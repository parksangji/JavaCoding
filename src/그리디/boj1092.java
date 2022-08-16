package 그리디;
import java.util.*;

public class boj1092 {
    static Scanner sc = new Scanner(System.in);
    static int n,m,answer= 0;
    static ArrayList<Integer> crain = new ArrayList<>();
    static ArrayList<Integer> box = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        input();
        solution();
    }

    static public void input() throws Exception{
        n = sc.nextInt();
        for(int i =0; i <n ; i++){
            crain.add(sc.nextInt());
        }
        m = sc.nextInt();
        for(int i=0; i<m ; i++){
            box.add(sc.nextInt());
        }
    }

    static public void solution(){

        Collections.sort(crain,Collections.reverseOrder());
        Collections.sort(box,Collections.reverseOrder());

        if(crain.get(0) < box.get(0)){
            System.out.print(-1);
            return;
        }
        while(!box.isEmpty()){
            answer += 1;
            int idx = 0;
            for(int i=0; i< n ;){
                if(crain.get(i) >= box.get(idx)){
                    box.remove(idx);
                    i++;
                }else {
                    idx ++;
                }
                if(idx == box.size()) break;
            }
        }
        System.out.print(answer);
    }
}
