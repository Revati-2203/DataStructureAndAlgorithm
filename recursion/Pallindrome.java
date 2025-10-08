package recursion;

public class Pallindrome {

    static boolean isPallindrome(String s){
        return isSame(s,0,s.length()-1);
    }
    static boolean isSame(String s, int l, int r){
        if(l>=r) return true;
        if(s.charAt(l)==s.charAt(r))
            return isSame(s,l+1, r-1);
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPallindrome("strtrkrtrt"));
    }
}
