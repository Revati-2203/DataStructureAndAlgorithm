package array;

public class SortColor012 {

    static void sortColor(int [] a){
        int l=0, m=0, h=a.length-1;
        while (m<=h){
            switch (a[m]){
                case 0:
                    swap(a,m,l);
                    l++;
                    m++;
                    break;
                case 1:
                    m++;
                    break;
                case 2:
                    swap(a,m,h);
                    h--;
                    break;
            }
        }
    }

    static void swap(int []a, int b, int c){
        int temp = a[b];
        a[b]= a[c];
        a[c]= temp;
    }

    public static void main(String[] args) {
        int []a ={2,1,0,1,0,0,2,0,2};
        sortColor(a);
        for (int i : a){
            System.out.print(i+" ");
        }
    }
}
