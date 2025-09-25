package recursion;

public class FibonacciNumber {

    static void printFibOfN(int n){
        int i=0;
        while(i<=n) {
            System.out.print(fibonacciOfN(i++) + ", ");
        }
    }

    // O(2^n)
    static int fibonacciOfN(int n){
        if (n<=1) return n;
        return fibonacciOfN(n-1)+fibonacciOfN(n-2);
    }

    public static void main(String[] args) {
        printFibOfN(15);
    }
}
