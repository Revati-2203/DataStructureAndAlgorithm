package array;
import java.util.ArrayList;

public class MaximumUnsortedSubarray {
    static ArrayList<Integer> subUnsort(ArrayList<Integer> A) {
        int n = A.size();
        int[] mins = new int[n];
        int[] maxs = new int[n];
        maxs[0] = A.get(0);
        for(int i = 1; i < n; i++) {
            maxs[i] = Math.max(A.get(i), maxs[i-1]);
        }
        mins[n-1] = A.get(n-1);
        for(int i = n - 2; i >= 0; i--) {
            mins[i] = Math.min(A.get(i), mins[i+1]);
        }
        ArrayList<Integer> result = new ArrayList<Integer>();
        int start = 0;
        while (start < n && mins[start] == A.get(start)) start++;
        int end = n - 1;
        while (end >= 0 && maxs[end] == A.get(end)) end--;
        if(start == n) result.add(new Integer(-1));
        else {
            result.add(new Integer(start));
            result.add(new Integer(end));
        }
        return result;

    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        A.add(57475); A.add(58019);        A.add(524108);        A.add(109767);        A.add(416718);        A.add(229462);        A.add(469065);        A.add(89537);        A.add(651016);        A.add(913512);        A.add(398017);        A.add(879748);
        A.add(836393);       A.add(857686);        A.add(712427);        A.add(905589);        A.add(803826);        A.add(276823);
        System.out.println(subUnsort(A));
    }
}