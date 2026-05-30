package OnlinePlatform;

import java.util.HashSet;
import java.util.Random;

public class LinkedListComponenet817 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public int numComponents(ListNode head, int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int count = 0;
        ListNode temp = head;
        while (temp != null) {
            // component end
            if (set.contains(temp.val) &&
                    (temp.next == null || !set.contains(temp.next.val))) {
                count++;
            }
            temp = temp.next;
        }
        return count;
    }
    class Solutionwewioeuoqp {
        int size = 0;
        ListNode temp;
        Random rd = new Random();
        public Solutionwewioeuoqp(ListNode head) {
            temp=head;
            while(temp!=null){
                size++;
                temp=temp.next;
            }
            temp=head;
        }

        public int getRandom() {
            ListNode temp1=temp;
            int n= rd.nextInt(size);
            for(int i=0;i<n-1;i++){
                temp1=temp1.next;
            }
            return temp1.val;
        }
    }
}
