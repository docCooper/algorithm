package leetCode;

/**
 * Create By 曹通
 * 2018/8/18 9:25
 */
public class ReverseLinkedList {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    private static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = null;
        ListNode preNewHead = head;
        while (head.next != null) {
            newHead = head.next;
            head.next = head.next.next;
            newHead.next = preNewHead;
            preNewHead = newHead;
        }
        return newHead;
    }

    private static ListNode removeElements(ListNode head, int val) {
        /**
         迭代实现
         if(head==null) return null;
         // 如果是头节点,直接return head.next;
         while(head!=null&&head.val==val){
         head = head.next;
         }
         // 要删除的前一个节点
         ListNode preNode = head;
         // 下一个不等于val的节点
         ListNode nNode = head;
         while(preNode!=null&&nNode!=null){
         while(preNode.next!=null&&preNode.next.val!=val) preNode = preNode.next;
         nNode = preNode.next;
         while(nNode!=null&&nNode.val==val) nNode = nNode.next;
         preNode.next = nNode;
         preNode=nNode;
         }
         return head;
         */
        // 递归实现
        if (head == null) return null;
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }

    private static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        ListNode newHead = head;
        ListNode preNewHead = head;
        ListNode headCopy = new ListNode(head.val);
        ListNode tail = head.next;
        ListNode tail2 = headCopy;
        while (tail != null) {
            tail2.next = new ListNode(tail.val);
            tail2 = tail2.next;
            tail = tail.next;

        }
        // 反转链表
        while (head.next != null) {
            newHead = head.next;
            head.next = head.next.next;
            newHead.next = preNewHead;
            preNewHead = newHead;
        }

        // 判断反转后的和反转前的是否相等
        while (headCopy != null && newHead != null) {
            if (headCopy.val != newHead.val) return false;
            headCopy = headCopy.next;
            newHead = newHead.next;
        }
        return true;

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        node2.next = null;
        node1.next = node2;
        head.next = node1;
//        ListNode listNode = reverseList(head);
//        System.out.println(listNode.val);
        boolean palindrome = isPalindrome(head);
//        ListNode listNode = removeElements(head, 2);
        System.out.println(palindrome);
    }
}
