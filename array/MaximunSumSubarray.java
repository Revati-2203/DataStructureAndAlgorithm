package array;

import java.util.ArrayList;

public class MaximunSumSubarray {

    static int bruteForce(int [] a){
        //O(n^2)
        int maxSum = Integer.MIN_VALUE;
        int n = a.length;
        for(int i=0; i< n; i++){
            int sum = 0;
            for (int j=i;j<n;j++){
                sum+=a[j];
                maxSum=Math.max(maxSum,sum);
            }
        }
        return maxSum;
    }

    static int kadanesAlgoMaxSum(int [] a){
        int max_Sum = 0;
        int sum=0;
        for (int i=0; i<a.length; i++){
            if(sum<0) sum=0;
            sum+=a[i];
            max_Sum=Math.max(max_Sum, sum);
        }
        return max_Sum;
    }

    static int[] maxSumSubArray(int[] a){
        int max_sum=0, start =0, ansStart =-1, ansEnd = -1, sum=0;
        for (int i=0; i<a.length; i++){
            if(sum==0) start=i;
            sum+=a[i];
            if(sum>max_sum){
                ansStart=start;
                ansEnd=i;
                max_sum=sum;
            }
            if(sum<0) sum=0;
        }
        int[] ans = new int[2];
        ans[0]=ansStart;
        ans[1]=ansEnd;
        return ans;
    }
    public static void main(String[] args) {
        int[] a = {-5, 4, 6, -3, 5, -1};
        int[] anss = maxSumSubArray(a);
        System.out.println(anss[0]+","+anss[1]);
    }
}
