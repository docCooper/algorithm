package leetCode;

/**
 * Create By 曹通
 * 2018/8/12 15:46
 */
class MyLinkedList {
    /** Initialize Node. */
    private class Node{
        private int val;
        private Node next;
        private Node(int val){
            this.val = val;
            next = null;
        }
    }
    // 头节点
    private Node head;
    // 链表长度
    private int count=0;
    /** Initialize your data structure here. */
    public MyLinkedList() {
    }
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index<0||index>=count)
            return -1;
        int i=0;
        Node curNode = head;
        while(i<index){
            curNode = curNode.next;
            i++;
        }
        return curNode.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node newHead = new Node(val);
        if(count==0){
            head = newHead;
        }else{
            newHead.next = head;
            head = newHead;
        }
        count++;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        if(count==0){
            addAtHead(val);
            return;
        }
        Node tailNode = head;
        Node node = new Node(val);
        while(tailNode.next!=null){
            tailNode = tailNode.next;
        }
        tailNode.next = node;
        count++;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index>count) return;
        if(index==count) {
            addAtTail(val);
            return;
        }
        int i=0;
        Node curNode = head;
        // 找到index之前的一个结点
        while(i<index-1){
            curNode = curNode.next;
            i++;
        }
        Node node = new Node(val);
        node.next = curNode.next;
        curNode.next = node;
        count++;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index<0||index>=count)
            return ;
        int i=0;
        Node curNode = head;
        // 找到index之前的一个结点
        while(i<index-1){
            curNode = curNode.next;
            i++;
        }
        curNode.next = curNode.next.next;
        count--;
    }
    public static void main(String[] args){
        MyLinkedList obj = new MyLinkedList();
        obj.addAtHead(5);
        obj.addAtHead(2);
        obj.deleteAtIndex(1);
        obj.addAtIndex(1,9);
        obj.addAtHead(4);
        obj.addAtHead(9);
        obj.addAtHead(8);
        int i = obj.get(3);
        obj.addAtTail(1);
        obj.addAtIndex(3,6);
        obj.addAtHead(3);
    }
}
