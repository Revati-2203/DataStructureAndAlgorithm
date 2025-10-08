package array;

import java.util.Arrays;

public class WaveArray {

    static void waveArray(int []a){
        //O(nlogn)
        Arrays.sort(a);
        int n = a.length;
        for (int i=1; i<n; i+=2) {
            if (a[i - 1] < a[i]) swap(a, i - 1, i);
        }
        printArr(a);
    }
    //without lexographically sorted smallest  (order doesn't matter)
    static void waveArrayWithoutLexographical(int[] a){
        //O(n)

        int n=a.length;
        for(int i=1; i<n; i+=2){
            if (a[i - 1] < a[i]) swap(a, i - 1, i);
            if(i<n-1 && a[i]>a[i+1]) swap(a, i, i+1);
        }
        printArr(a);
    }
    static void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i]=a[j];
        a[j]=temp;
    }

    static void printArr(int[] a){
        int n = a.length;
        for(int j = 0; j<n; j++){
            System.out.print(a[j]+" ");
        }
    }

    public static void main(String[] args) {
        int[] a = {1,9,5,2,0,7,4,8,3,6};
        waveArrayWithoutLexographical(a);
    }
}
