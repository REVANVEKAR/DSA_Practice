package revise.BinaryTrees;

import com.sun.source.tree.Tree;

import javax.sound.midi.MidiFileFormat;
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



    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null){
            return 0;
        }

    }

//    public int height






    public static void main(String[] args) {

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