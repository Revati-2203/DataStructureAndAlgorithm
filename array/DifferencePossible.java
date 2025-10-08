package array;

public class DifferencePossible {
//    Determine if there are any two distinct indices i and j in the sorted
//    array arr such that arr[i] - arr[j] equals a non-negative integer k.
//    Return true if possible else false. Input:
//      arr[] = [1, 1, 1, 2, 2, 6, 8, 8, 8] k = 2
//      Output:true Explanation://There exists two numbers 6 and 8 whose difference is equal to 2.

    static boolean bruteForce(int [] a, int k){
        for(int i=0; i<a.length; i++){
            for(int j=i+1; j<a.length; j++) {
                if (a[j] - a[i] == k) return true;
            }
        }
        return false;
    }

    static boolean optimised(int [] a, int k){
        int j=0;
        for(int i=0; i<a.length; i++){
            j=Math.max(j, i+1);

            while(j<a.length && a[j]-a[i]<k) j++;
            if (j<a.length && a[j]-a[i]==k) return true;
        }
        return false;
    }

    public static void main(String[] args) {
       int  arr[] = {1, 1, 1, 2, 2, 6, 8, 8, 8};
       int k = 2;
        System.out.println(optimised(arr, k));
    }

}
