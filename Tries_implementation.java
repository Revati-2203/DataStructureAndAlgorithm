class Classroom{
    static class Node{
        Node children[] = new Node[26];
        boolean isEndOfWord = false;

        public Node(){
            // for(int i=0; i<26; i++){
            //     children[i]=null;
            // } not needed as in Java, it initializes object references (like arrays) to null by default
        }
    }
    public static Node root = new Node();

    public static void insertWordinTries(String word){
        Node current=root;
        for(int i=0;i<word.length() ;i++){
            int idx = Character.toLowerCase(word.charAt(i))-'a';
            if(current.children[idx]==null){
                current.children[idx] = new Node();
            }
            current = current.children[idx];
        }
        current.isEndOfWord=true;
    }

    public static boolean searchWord(String word){
        Node current=root;
        for(int i=0;i<word.length();i++){
            int idx = Character.toLowerCase(word.charAt(i)) - 'a';
            if(current.children[idx]==null){
                return false;
            }
            current = current.children[idx];
        }
        return current.isEndOfWord==true;
    }
    
    public static boolean startsWith(String prefix) {
        Node current = root;
        for(int i=0; i<prefix.length(); i++){
            int idx = Character.toLowerCase(prefix.charAt(i))-'a';
            if(current.children[idx]==null){
                return false;
            }
            current=current.children[idx];
        }
        return true;
    }
    
    //Question asked in Google - word break problem 
    public static boolean wordBreak(String key){
        for(int i=1; i< key.length(); i++){
            if(searchWord(key.substring(0,i)) && wordBreak(key.substring(i))){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
       
        insertWordinTries("hello");
        insertWordinTries("hell");
        insertWordinTries("any");
        insertWordinTries("an");
        // System.out.println(startsWith("any"));
        // System.out.println(searchWord("anys"));
        System.out.println(wordBreak("anyhello"));
        
    }
}




// clean code given below with comparision
// class Trie {
//     class Node{
//         Node[] children;
//         boolean isEndOfWord;

//         public Node(){
//             children = new Node[26];
//             isEndOfWord =  false;
//         }
//     } 
//     Node root;
//     public Trie() {
//         root = new Node(); 
//     }
    
//     public void insert(String word) {
//         Node current = root;
//         for(int i=0; i<word.length(); i++){
//             int idx = word.charAt(i) - 'a';
//             if(current.children[idx]==null){
//                 current.children[idx]= new Node();
//             }
//             current=current.children[idx];
//         }
//         current.isEndOfWord=true;
//     }
    
//     public boolean search(String word) {
//         Node current = root;
//         for(int i=0; i<word.length(); i++){
//             int idx =word.charAt(i)-'a';
//             if(current.children[idx]==null){
//                 return false;
//             }
//             current=current.children[idx];
//         }
//         return current.isEndOfWord==true;
//     }
    
//     public boolean startsWith(String prefix) {
//         Node current = root;
//         for(int i=0; i<prefix.length(); i++){
//             int idx = prefix.charAt(i)-'a';
//             if(current.children[idx]==null){
//                 return false;
//             }
//             current=current.children[idx];
//         }
//         return true;
//     }
// }
// | Operation    | Time Complexity |
// | ------------ | --------------- |
// | `insert`     | O(L)            |
// | `search`     | O(L)            |
// | `startsWith` | O(L)            |
// 
// | Aspect                           | **Code 1**                                                    | **Code 2**                                                   |
// | -------------------------------- | ------------------------------------------------------------- | ------------------------------------------------------------ |
// | **Inner Class Declaration**      | `TrieNode` is a non-static inner class                        | `Node` is a `static` nested class                            |
// | **Character Handling**           | Direct use of `c - 'a'` (assumes lowercase input only)        | Uses `Character.toLowerCase()` (handles uppercase input too) |
// | **Initialization of `children`** | Children array is allocated, but not explicitly set to `null` | Children are explicitly initialized to `null` in constructor |
// | **`root` Field**                 | `root` is an instance variable                                | `root` is declared as `static`, shared by all instances      |

// Code 2 adds robustness (handles case-insensitivity),
// while Code 1 is cleaner and follows better object-oriented design
// (non-static root and inner class).




