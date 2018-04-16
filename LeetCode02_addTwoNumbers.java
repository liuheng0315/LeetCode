package leetcode;

public class LeetCode02_addTwoNumbers {
    //两个节点的值相加
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode(0);
        int num = 0;
        ListNode current=listNode;
        while (l1 != null || l2 != null) {
            int value1 = l1 != null ? l1.val : 0;
            int value2 = l2 != null ? l2.val : 0;
            int sum = value1 + value2 + num;
            num = sum / 10;
            current.next = new ListNode(sum % 10);
            current=current.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2!=null) {
                l2 = l2.next;
            }
        }
        if (num != 0) {
            current.next=new ListNode(num);
        }
        return listNode.next;
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
