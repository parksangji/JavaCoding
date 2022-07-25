package 그리디;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj2122 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        int [] arr = new int [n];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        for(int i=0; i< n ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        solution(n,k,arr);
    }

    public static void solution(int n, int k, int[] arr){
        Arrays.sort(arr);
        int [] newArr = new int [n-1];

        for(int i=0; i< n-1; i++){
            newArr[i] = arr[i+1] - arr[i];
        }

        Arrays.sort(newArr);

        int ans = 0;

        for(int i=0; i<n-k; i++){
            ans += newArr[i];
        }

        System.out.println(ans);
    }
}
