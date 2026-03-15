package BinaryTree32;

public class SortedArrayToBst extends TreeTraversal {
    public static Node createBST(int []arr,int st,int ei){
        if(st>ei){
            return null;
        }
        int mid=st+(ei-st)/2;
        Node root=new Node(arr[mid]);
        root.left=createBST(arr,st,mid-1);
        root.right=createBST(arr,mid+1,ei);
        return root;
    }

    public static void main(String[] args) {
        int [] arr={3,5,6,8,10,11,12};
        Node root=createBST(arr,0,arr.length-1);
        inOrder(root);
    }
}
