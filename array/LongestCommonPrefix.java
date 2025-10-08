package array;

public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {
        //You can code here
        StringBuilder prefix = new StringBuilder();
        String str = strs[0];
        int j=0;
        while(j<str.length()){
            char ch=  str.charAt(j);
            for(int i=1; i<strs.length; i++){
                String temps = strs[i];
                if(j>temps.length()-1 || ch != temps.charAt(j)){
                    return prefix.toString();
                }
            }
            prefix.append(ch);
            j++;
        }
        return prefix.toString();
    }
    public static void main(String[] args) {
        String [] a = {"abcde", "abc","ab", "a"};
        System.out.println(longestCommonPrefix(a));
    }
}
