/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if (root == null){
            return res;
        }
        
        Deque<TreeNode> traversal = new LinkedList<>();
        traversal.add(root);

        while(traversal.size() != 0){
            List<TreeNode> temp = new ArrayList<>(traversal);
            List<Integer> values = new ArrayList<>();

            temp.stream()
                .map(treeNode -> treeNode.val)
                .forEach(values::add);

            res.add(values);

            for (TreeNode i : temp){
                if (i.left != null){
                    traversal.add(i.left);
                }
                if (i.right != null){
                    traversal.add(i.right);
                }

                traversal.pollFirst();
            }
        }

        return res;
    }
}
