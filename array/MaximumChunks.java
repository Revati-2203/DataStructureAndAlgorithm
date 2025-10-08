package array;

public class MaximumChunks {

    static int maxiChunks1 (int [] a){
        if (a.length==0) return 0;
        int maxi=a[0];
        int count=0;
        for(int i=0; i<a.length;i++){
            maxi = Math.max(maxi, a[i]);
            if(i==maxi) {
                count++;
            }
        }
        return count;
    }

    static int maxiChunk2 (int[] a){
        int n = a.length;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0]=a[0];
        right[n-1]=a[n-1];
        int count = 0;
        for (int i=1; i<a.length; i++){
            left[i]= Math.max(left[i-1], a[i]);
        }
        for (int j=n-2;j>=0;j--){
            right[j]=Math.min(right[j+1], a[j]);
        }
        for (int k=0; k<n-1; k++){
            if(left[k]>right[k+1]) count++;
        }
        return count+1;
    }

    public static void main(String[] args) {

        int [] a ={0,2,1,3,5,4,6};
        System.out.println(maxiChunks1(a));

        int [] b = {3,5,6,8,7,12,9};
        System.out.println(maxiChunk2(a));
    }
}

