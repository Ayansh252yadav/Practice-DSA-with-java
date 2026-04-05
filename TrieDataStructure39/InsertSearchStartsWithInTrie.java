package TrieDataStructure39;

public class InsertSearchStartsWithInTrie {
    static class Node{
        Node children[]=new Node[26];
        boolean eow=false;
       Node(){
           for(int i=0;i<26;i++){
            children[i]=null;
           }
       }
    }
    public static Node root=new Node();
    public static void insert(String word){
        Node curr=root;
        for(int level=0;level<word.length();level++){
            int idx=word.charAt(level)-'a';
            if(curr.children[idx]==null){
                curr.children[idx]=new Node();
            }
            curr=curr.children[idx];
        }
        curr.eow=true;
    }
    public static boolean search(String word){
        Node curr=root;
        for(int level=0;level<word.length();level++){
            int idx=word.charAt(level)-'a';
            if(curr.children[idx]==null){
                return false;
            }
            curr=curr.children[idx];
        }
        return curr.eow==true;
    }
  public static boolean startsWith(String prefix){
        Node curr=root;
        for (int level=0;level<prefix.length();level++){
            int idx=prefix.charAt(level)-'a';
            if (curr.children[idx]==null){
                return  false;
            }
            curr=curr.children[idx];
        }
        return true;
  }

    public static void traverse(Node root, StringBuilder word) {
        if (root == null) return;
        if (root.eow) {
            System.out.println(word.toString());
        }
        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null) {
                word.append((char)(i + 'a'));   // choose
                traverse(root.children[i], word);
                word.deleteCharAt(word.length() - 1); // backtrack
            }
        }
    }

    public static void main(String[] args) {
        String []word={"the","a","there","their","any","thee"};
        for(int i=0;i<word.length;i++){
            insert(word[i]);
        }
        System.out.println(search("the"));
        traverse(root,new StringBuilder());
    }
}
