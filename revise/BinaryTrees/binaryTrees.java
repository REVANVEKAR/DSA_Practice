package revise.BinaryTrees;

import com.sun.source.tree.Tree;

import javax.sound.midi.MidiFileFormat;
import javax.swing.event.TreeWillExpandListener;
import java.awt.image.AreaAveragingScaleFilter;
import java.util.*;

public class binaryTrees {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        traverse(root, list);

        return list;
    }

    private void traverse(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        traverse(root.left, list);
        traverse(root.right, list);
    }

    //    144. Binary Tree Preorder Traversal
    public List<Integer> preorderTraversalIterative(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            list.add(temp.val);

            if (temp.right != null) {
                stack.push(temp.right);
            }
            if (temp.left != null) {
                stack.push(temp.left);
            }
        }

        return list;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorderTraversalHelper(root, list);

        return list;
    }

    public void inorderTraversalHelper(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        list.add(root.val);
        inorderTraversalHelper(root.right, list);
        inorderTraversalHelper(root.left, list);

    }


    //    94. Binary Tree Inorder Traversal
    public List<Integer> inorderTraversalIterative(TreeNode root) {

        List<Integer> list = new ArrayList<>();

        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;
        while (true) {
            if (temp != null) {
                stack.push(temp);
                temp = temp.left;
            } else {
                if (stack.isEmpty()) {
                    break;
                }
                temp = stack.pop();
                list.add(temp.val);
                temp = temp.right;
            }
        }
        return list;
    }


    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postorderTraversalHelper(root, list);

        return list;
    }

    public void postorderTraversalHelper(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        postorderTraversalHelper(root.left, list);
        postorderTraversalHelper(root.right, list);
        list.add(root.val);

    }

    public List<Integer> postorderTraversalIterative(TreeNode root){
        List<Integer> list = new ArrayList<>();

        if(root == null){
            return list;
        }

        Stack<TreeNode> one = new Stack<>();
        Stack<TreeNode> two = new Stack<>();

        one.push(root);

        while (!one.isEmpty()){
            TreeNode temp = one.pop();
            two.push(temp);

            if (temp.left != null){
                one.push(temp.left);
            }

            if (temp.right != null){
                one.push(temp.right);
            }

        }

        while (!two.isEmpty()){
            list.add(two.pop().val);
        }

        return list;

    } // continue tom



    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if (root == null){
            return result;
        }

        queue.add(root);

        while (!queue.isEmpty()){
            int levelNum = queue.size();
            List<Integer> temp = new ArrayList<>();
            for (int i =0; i< levelNum ; i++){
                if (queue.peek().left != null){
                    queue.offer(queue.peek().left);
                }
                if (queue.peek().right != null){
                    queue.offer(queue.peek().right);
                }
                temp.add(queue.poll().val);
            }
            result.add(temp);
        }
        return result;
    }

    // using one stack
    public List<Integer> postorderTraversalOneStack(TreeNode root){
        List<Integer> list = new ArrayList<>();

        if (root == null){
            return list;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        TreeNode lastVisited = null;

        while (curr!= null || !stack.isEmpty()){
            if (curr!= null){
                stack.push(curr);
                curr = curr.left;
            }else{
                TreeNode temp = stack.peek();
                if (temp.right != null && temp.right != lastVisited){
                    curr = temp.right;
                }
                else {
                    stack.pop();
                    list.add(temp.val);
                    lastVisited = temp;
                }
            }
        }
        return list;

    }

    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }

        int a = 1 + maxDepth(root.right);
        int b = 1 + maxDepth(root.left);

        return Math.max(a,b);
    } // bheryyy good



    static int max;
    public int diameterOfBinaryTree(TreeNode root) {
        max = 0;
        height(root);
        return max;
    }

    public int height(TreeNode root){
        if (root == null){
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);

        max = Math.max(max, left + right);

        return 1+ Math.max(left , right );
    }

    public boolean isBalanced(TreeNode root) {
        return heightModified(root) != -1;
    }

    private int heightModified(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = heightModified(root.left);
        int right = heightModified(root.right);

        if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
            return -1;
        }

        return 1 + Math.max(left, right);
    } // come back and understand the zero part and move on

    public boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == null && q == null){
            return true;
        }

        if (p == null || q == null || p.val != q.val){
            return false;
        }
        return isSameTree(p.right, q.right) && isSameTree(p.left, q.left);
    }


    public boolean isSymmetric(TreeNode root) {

        if (root == null){
            return true;
        }

        return isMirror(root.right, root.left);

    }

    public boolean isMirror( TreeNode one, TreeNode two){
        if (one == null && two == null){
            return true;
        }

        if (one == null || two == null){
            return false;
        }

        return one.val == two.val && isMirror(one.right, two.left) && isMirror(one.left , two.right);
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if (root == null){
            return result;
        }

        queue.offer(root);

        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++){
                TreeNode currNode = queue.poll();
                if (i == 0){
                    result.add(currNode.val);
                }
                if (currNode.right != null){
                    queue.offer(currNode.right);
                }
                if (currNode.left != null){
                    queue.offer(currNode.left);
                }
            }
        }

        return result;
    } // almost had it but koi na:)


    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if (root == null){
            return result;
        }

        queue.offer(root);
        boolean flag = true;

        while (!queue.isEmpty()){
            int level = queue.size();
            ArrayList<Integer> sublist = new ArrayList<>();
            for (int i = 0; i<level ; i++){
                int index = i;
                if (queue.peek().left != null){
                    queue.offer(queue.peek().left);
                }
                if (queue.peek().right != null){
                    queue.offer(queue.peek().right);
                }
                if (flag){
                    sublist.add(queue.poll().val);
                }else{
                    sublist.add(0,queue.poll().val);
                }
            }
            flag = !flag;
            result.add(sublist);
        }


        return result;
    }

    public ArrayList <Integer> bottomView(Node root)
    {
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Node> q = new LinkedList<Node>();
        root.hd = 0;
        q.add(root);
        while(!q.isEmpty()) {
            Node temp = q.remove();
            int hd = temp.hd;
            map.put(hd, temp.val);
            if(temp.left != null) {
                temp.left.hd = hd - 1;
                q.add(temp.left);
            }
            if(temp.right != null) {
                temp.right.hd = hd + 1;
                q.add(temp.right);
            }
        }

        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            ans.add(entry.getValue());
        }
        return ans;

    }

    static ArrayList<Integer> topView(Node root)
    {
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(root, 0));
        while(!q.isEmpty()) {
            Pair it = q.remove();
            int hd = it.hd;
            Node temp = it.node;
            if(map.get(hd) == null) map.put(hd, temp.val);
            if(temp.left != null) {

                q.add(new Pair(temp.left, hd - 1));
            }
            if(temp.right != null) {

                q.add(new Pair(temp.right, hd + 1));
            }
        }

        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            ans.add(entry.getValue());
        }
        return ans;

    }








    public static void main(String[] args) {

    }

    public class Node{
        int val;
        Node left;
        Node right;
        int hd; // added for top and bottom problem or lets just create a new one

        Node() {
        }

        Node(int val) {
            this.val = val;
        }

        Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        Node(int val, Node left, Node right, int hd) {
            this.val = val;
            this.left = left;
            this.right = right;
            this.hd = hd;
        }


    }

    public static class Pair{
        Node node;
        int hd;

        public Pair(Node root, int i) {
            this.node  = root;
            this.hd = i;
        }
    }



    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}