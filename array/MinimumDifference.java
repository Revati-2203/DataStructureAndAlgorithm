package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumDifference {

    // brute force O(n^2) - check all pairs
    static List<List<Integer>> minDifference (int [] a){
        //O(nlogn)
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(a);
        int min = Integer.MAX_VALUE;
        for (int i=1; i<a.length; i++){
            min = Math.min(min, a[i]-a[i-1]);
        }
        for (int j=1;j<a.length; j++){
            if(min==a[j]-a[j-1]){
                List<Integer> temp = new ArrayList<>();
                temp.add(a[j-1]);
                temp.add(a[j]);
                ans.add(temp);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] a = {12, 9, 8, 11, 5, 5};
        List<List<Integer>> ans = minDifference(a);
        System.out.println(ans);
    }
}
