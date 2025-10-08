package array;

public class MultipleLeftRotation {

    static void bruteForce(int[] a,int k){
        //time complexity - O(k*n)*m  (k:time left rotation, m: lenght of array containing number of rotations, n: length of array to rotate)
        for (int i=0;i<k;i++){
            int n = a.length;
            int temp = a[0];
            for (int j=0; j<n-1;j++){
                a[j] = a[j+1];
            }
            a[n-1]=temp;
        }
    }

    static void optimized(int[] a, int k){
        // space complexity - O(2*n) = O(n)

        int n =a.length;
        k = k%n; // IMP  (this is required so that if k >n , like if n=4 and k=6 then after rotating for 4 times it will be same so we have to rotate just two times more)
        int temp[] = new int[2*n];
        for(int i=0; i<n*2; i++){
            temp[i]=a[i%(n)];
        }
        for(int j=0; j<n; j++){
            a[j]= temp[j+k];
        }
        printArr(a);
    }

    static void printArr(int[] a){
        int n = a.length;
        for(int j = 0; j<n; j++){
            System.out.println(a[j]);
        }
    }
    public static void main(String[] args) {
        int[] a ={1,2,3,4,5,6};
        optimized(a,2);
    }

    //for RIGHT Rotation
//    left rotation  k = l  and right rotation k=r
//    then for right rotation in terms of r and l => rightRotation(k) = leftRotation(n-r)
}
