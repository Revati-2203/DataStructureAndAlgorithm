package array;

import java.util.Arrays;

public class DistributeChocolate {

    public static  int findMinDiff(int[] arr, int m)
    {
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        int i=0;
        while(i<=arr.length-m){
            min = Math.min(min, arr[i+m-1]-arr[i]);
            i++;
        }
        return min;
    }

    public static void main(String[] args) {
        int [] arr = {12, 24, 36 ,45, 49, 72, 74, 80};
        System.out.println(findMinDiff(arr, 3));
    }
}
