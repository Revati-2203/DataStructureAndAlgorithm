package recursion;

public class CountOccurence {

    static void countOccurence(String str, String subStr){
        System.out.println(helper(str,subStr,0));
    }

    // iterate over string using pointer i , till i>str.length -substr.length
    // check if str.substring(i,i+substr.lenght()).equals(substr) then return ans+1

    static int helper(String str, String t, int i){
        if(i>str.length()-t.length()){ return 0;}
        int subAns = helper(str,t,i+1);
        if(str.substring(i,i+t.length()).equals(t)) return subAns+1;
        else return subAns;
    }
    public static void main(String[] args) {
        countOccurence("abcjdkabcjkdeabccabc","abc");
    }
}
