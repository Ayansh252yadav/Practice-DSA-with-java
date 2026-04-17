package TrieDataStructure39;

public class UniqueSubstringCount {
     class Node{
        Node []children=new Node[26];
        boolean eow=false;
    }
    public Node root=new Node();
    public  void insert(String word){
        Node curr=root;
        for(int i=0;i<word.length();i++){
            int idx=word.charAt(i)-'a';
            if(curr.children[idx]==null){
                curr.children[idx]=new Node();
            }
            curr=curr.children[idx];
        }
        curr.eow=true;
    }

    public int countNodes(Node root){
        if(root==null) {
            return 0;
        }
        int count=0;
        for(int i=0;i<26;i++){
            if(root.children[i]!=null){
                count+=countNodes(root.children[i]);
            }
        }
        return count+1;
    }

    public static void main(String[] args) {
        String s="jaja";
        UniqueSubstringCount uc=new UniqueSubstringCount();
        for(int i=0;i<s.length();i++){
            uc.insert(s.substring(i));
        }
        System.out.println(uc.countNodes(uc.root));
    }
}
