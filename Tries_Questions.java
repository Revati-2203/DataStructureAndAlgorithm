class Tries_Questions {
    static class Node{
        Node children[] = new Node[26];
        int freq=1;
        boolean isEndOfWord = false;

        public Node(){
        }
    }
    public static Node root= new Node();

    public static void insert(String word) {
        Node current = root;
        for(int i=0; i<word.length(); i++){
            int idx = word.charAt(i) - 'a';
            if(current.children[idx]==null){
                current.children[idx]= new Node();
            }else{
                current.freq++;
            }
            current=current.children[idx];
        }
        current.isEndOfWord=true;
    }

    public static void prefixFind(Node root, String ans){
        if(root==null){
            return;
        }

        if(root.freq==1){
            System.out.println("'"+ans+"'");
            return;
        }

        for(int i=0;i<root.children.length;i++){
            if(root.children[i]!=null){
                prefixFind(root.children[i], ans+(char)(i+'a'));
            }
        }
    }

    public static String ans = "";
    public static void longestWordWithAllPrefixes(Node root, StringBuilder temp){
        if(root==null){
            return;
        }
        for(int i=0;i<26;i++){ 
            if(root.children[i]!=null && root.children[i].isEndOfWord==true){
                temp.append((char)(i+'a'));
                if(temp.length()>ans.length()){
                    ans=temp.toString();
                }
                longestWordWithAllPrefixes(root.children[i], temp);
                temp.deleteCharAt(temp.length()-1);
            }
        }
        return;
    }


    public static int countUniqueSubstrings(Node root){
        if (root==null){
            return 0;            
        }
        int count=0;
        for(int i=0;i<26;i++){
            if(root.children[i]!=null){
                count+=countUniqueSubstrings(root.children[i]);
            }
        }
        return count+1;
    }
    public static void main(String[] args) {
        // insert("hello");
        // insert("awkward");
        // insert("a");
        // insert("aw");
        // insert("awk");
        // insert("awkw");
        // insert("awkwa");
        // insert("awkwar");
        // insert("helarious");
        //  root.freq=-1;
        //  prefixFind(root, "");
        // longestWordWithAllPrefixes(root, new StringBuilder());
        String str = "aba";
        for(int i=0;i<str.length();i++){
            insert(str.substring(i));
        }
         System.out.println("ans is "+countUniqueSubstrings(root));
       
    }


}
