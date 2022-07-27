package 투포인터;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj2470 {
    static int N;
    static int [] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        for(int i=0; i<N ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        twoPointer(arr,N);
    }
    public static void twoPointer(int [] arr,int N){
        Arrays.sort(arr);
        int left=0,right= N-1,minValue = Integer.MAX_VALUE;
        int ans1= 0,ans2 = Integer.MAX_VALUE;
        while(left < right){
            int sum = arr[left] + arr[right];

            if(Math.abs(sum) < minValue){
                ans1 = arr[left];
                ans2 = arr[right];
                minValue = Math.abs(sum);
            }
            if(minValue == 0) {
                System.out.printf("%d %d",ans1,ans2);
                return;
            } else if (sum < 0) {
                left += 1;
            }else {
                right -= 1;
            }
        }
        System.out.printf("%d %d",ans1,ans2);
        return;
    }
}
