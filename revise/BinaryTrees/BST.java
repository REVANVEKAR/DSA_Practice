package revise.BinaryTrees;

import revise.BinaryTrees.binaryTrees.TreeNode;

//import javax.swing.tree.TreeNode;

public class BST {

    public static void main(String[] args) {

    }

    public TreeNode searchBST(TreeNode root, int val) {

        while (root != null && root.val != val){
             root = val < root.val ? root.left:root.right;
        }

        return root;
    }



}
