package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    //two pointer approach
    // Q. sum of three = zero
    static List<List<Integer>> threeSum(int[] a){
        // O(n^2logn)
        List<List<Integer>> ans = new ArrayList<>();

        for (int i=0; i<a.length-2; i++){
            if (i>0 && a[i]==a[i-1]) {
                continue;
            }
            List<List<Integer>> twoSumList = twoSum(a, -a[i], i+1);
            for (List<Integer> temp : twoSumList){
                temp.add(0,a[i]);
                ans.add(temp);
            }
        }
        return ans;
    }

    // O(nlogn)
    static List<List<Integer>> twoSum(int[] a, int sum, int start){
        int l= start;
        int r = a.length-1;
        List<List<Integer>> ans = new ArrayList<>();
        while (l < r){
            if (l > start && a[l] == a[l-1]) {
                l++;
                continue;
            }
            if( r<a.length-1 && a[r]==a[r+1]){
                r--;
                continue;
            }

            if(a[l]+a[r] < sum){
                l++;
            }else if(a[l]+a[r] > sum){
                r--;
            }else{
                List<Integer> temp = new ArrayList<>();
                temp.add(a[l]);
                temp.add(a[r]);
                ans.add(temp);
                l++;
                r--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] a = {1,-2, 3, 4, -1, 1};
        Arrays.sort(a); // IMP Step for solving this ques
        System.out.println(threeSum(a));
    }
}
