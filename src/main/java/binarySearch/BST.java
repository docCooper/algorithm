package binarySearch;

import java.util.*;

/**
 * Create By 曹通
 * 2018/8/3 11:23
 */
public class BST<Key extends Comparable<Key>, Value> {
    //    树中的节点为私有的类, 外界不需要了解二分搜索树节点的具体实现
    private class Node {
        private Key key;
        private Value value;
        private Node left, right;

        // 构造一个节点
        private Node(Key key, Value value) {
            this.key = key;
            this.value = value;
            left = null;
            right = null;
        }
    }

    // 一颗二分搜索树由一个根节点和节点数就可以表示
    private Node root;
    private int count;

    // 构造一颗空二分查找树
    public BST() {
        root = null;
        count = 0;
    }

    // 返回二分搜索树的节点个数
    public int size() {
        return count;
    }

    // 返回二分搜索树是否为空
    public boolean isEmpty() {
        return count == 0;
    }

    /**
     * 插入节点 递归实现
     *
     * @param node  要插入树的根节点
     * @param key   插入节点的key
     * @param value 插入节点的value
     * @return 插入节点后的根节点
     */
    private Node insert(Node node, Key key, Value value) {
        // 递归最终终止条件
        if (node == null) {
            // 一颗空树
            count++;
            return new Node(key, value);
        }
        if (key.compareTo(node.key) == 0)
            // 当前插入的节点和根节点的key一样，直接把value更新一下就行
            node.value = value;
            // 没有找到key相等的节点，就递归直到为空
        else if (key.compareTo(node.key) < 0)
            node.left = insert(node.left, key, value);
        else
            node.right = insert(node.right, key, value);
        return node;
    }

    public void insert(Key key, Value value) {
        root = insert(root, key, value);
    }

    public void insert2(Key key, Value value) {
        root = insert2(root, key, value);
    }

    /**
     * 插入节点非递归实现
     * Create By 曹通
     * 2018/8/4 11:09
     */
    private Node insert2(Node node, Key key, Value value) {
        if (node == null)
            return new Node(key, value);
        Node node1 = node;
        while (node != null) {
            if (node.key.compareTo(key) == 0) {
                node.value = value;
                break;
            }
            if (node.key.compareTo(key) < 0) {
                if (node.right == null) {
                    node.right = new Node(key, value);
                    count++;
                    return node1;
                } else
                    node = node.right;
            } else {
                if (node.left == null) {
                    node.left = new Node(key, value);
                    count++;
                    return node1;
                } else
                    node = node.left;
            }
        }
        return node1;
    }

    /**
     * 先序递归实现
     * Create By 曹通
     * 2018/8/4 16:33
     *
     * @param node
     * @return void
     */
    private void preOrder(Node node) {
        if (node != null) {
            System.out.println(node.key);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    /**
     * 先序，非递归实现
     * Create By 曹通
     * 2018/8/4 16:40
     *
     * @param [node]
     * @return void
     */
    private void preOrder2(Node node) {
        Stack<Node> stack = new Stack<>();
        stack.push(node);
        while (!stack.empty()) {
            Node p = stack.pop();
            if (p != null) {
                // 前中后的区别主要在这
                System.out.print(p.key + " ");
                stack.push(p.right);
                stack.push(p.left);
            }
        }
    }

    /**
     * 层次遍历,借助于队列实现
     * Create By 曹通
     * 2018/8/7 9:31
     *
     * @param []
     * @return void
     */
    private void levelOrder(Node node) {
        LinkedList<Node> list = new LinkedList<>();
        // 先将根节点入队
        list.add(node);
        while (!list.isEmpty()) {
            Node remove = list.remove();
            System.out.print(remove.key + " ");
            if (remove.left != null)
                list.add(remove.left);
            if (remove.right != null)
                list.add(remove.right);
        }
    }

    /**
     * 判断key在不在以node为根节点的二分查找树中
     * Create By 曹通
     * 2018/8/4 10:50
     *
     * @return boolean
     */
    private boolean contain(Node node, Key key) {
        if (node == null)
            return false;
        if (node.key.compareTo(key) == 0)
            return true;
        else if (key.compareTo(node.key) > 0)
            return contain(node.right, key);
        else
            return contain(node.left, key);
    }

    public boolean contain(Key key) {
        return contain(root, key);
    }

    private Value search(Node node, Key key) {
        if (node == null)
            return null;
        if (node.key.compareTo(key) == 0)
            return node.value;
        if (node.key.compareTo(key) > 0)
            return search(node.left, key);
        else
            return search(node.right, key);
    }

    private Node removeMax(Node node) {
        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            count--;
            return leftNode;
        }
        node.right = removeMax(node.right);
        return node;
    }

    private Node removeByKey(Node node, Key key) {
        // 删除某个key的节点
        assert !contain(root, key);
//        if (node.key.compareTo(key)==0)
        return null;
    }

    public Node removeMax() {
        return removeMax(root);
    }

    private Node removeMax2(Node node) {
        assert node == null;
        Node root = node;
        while (node.right.right != null) {
            node = node.right;
        }
        // 此时node为最大节点的父节点
        Node leftNode = node.right.left;
        node.right = null;
        node.right = leftNode;
        count--;
        return root;
    }

    public Node removeMax2() {
        return removeMax2(root);
    }

    public static void main(String[] args) {
        BST<Integer, String> testData = new BST<>();
        testData.insert(10, "sq");
        testData.insert(13, "sq1");
        testData.insert(11, "sq3");
        testData.insert(20, "sq4");
        testData.insert(50, "srq");
        testData.insert(1, "sq");
        testData.insert(14, "sqe");
        testData.insert(19, "sq");
        testData.insert(7, "sqd");
//        testData.removeMax2();
        testData.levelOrder(testData.root);
//        System.out.println(testData.count);
    }
}
