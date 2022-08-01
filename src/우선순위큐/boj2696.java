package 우선순위큐;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class boj2696 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int i=0; i< t ; i++){
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = null;
            int [] arr = new int[n];

            for(int j=0; j< n ; j++){
                if(j % 10 == 0){
                    st = new StringTokenizer(br.readLine());
                }
                arr[j] = Integer.parseInt(st.nextToken());
            }

            solution(arr,n);
        }
    }
    public static void solution(int [] arr, int n){

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int middle_value = arr[0],minSize = 0, maxSize = 0;
        List<Integer> result = new LinkedList<>();
        result.add(middle_value);
        for(int i=1; i< n ; i++){
            if(arr[i] < middle_value){
                maxHeap.add(arr[i]);
                maxSize ++ ;
            }else{
                minHeap.add(arr[i]);
                minSize ++;
            }

            if(i % 2 == 0 ){
                if(minSize < maxSize){
                    minHeap.add(middle_value);
                    middle_value = maxHeap.poll();
                    minSize++;
                    maxSize--;
                }else if(minSize > maxSize){
                    maxHeap.add(middle_value);
                    middle_value = minHeap.poll();
                    maxSize++;
                    minSize--;
                }
                result.add(middle_value);
            }
        }
        System.out.println(result.size());
        for(int i=0; i < result.size(); i++){
            if(i % 10 == 0 && i != 0) System.out.println();
            System.out.printf("%d ",result.get(i));
        }
        System.out.println();
    }
}
