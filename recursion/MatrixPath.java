package recursion;


//time complexity - maximum of m,n ->r  so O(2^r)
//recursive stack - space complexity - O(r)
public class MatrixPath {
    static int calculateMatrixPaths(int m, int n){
        if(m==1 || n==1) return 1;

        return calculateMatrixPaths(m-1,n)+ calculateMatrixPaths(m, n-1);
    }
    public static void main(String[] args) {
        System.out.println(calculateMatrixPaths(3,3));
    }
}
