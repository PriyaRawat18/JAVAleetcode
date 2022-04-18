/*Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.

 

Example 1:


Input: root = [3,1,4,null,2], k = 1
Output: 1
Example 2:


Input: root = [5,3,6,2,4,null,null,1], k = 3
Output: 3
 */



public int kthSmallest(TreeNode root, int k) {
	var kSmallest = new int[1];
	inorder(root, new int[]{k}, kSmallest);
	return kSmallest[0];
}

private void inorder(TreeNode root, int[] count, int[] kSmallest) {
	if (root == null || count[0] == 0)
		return;
	// recurse left
	inorder(root.left, count, kSmallest);
	// visit
	if (--count[0] == 0)
		kSmallest[0] = root.val;
	else
	// recurse right
		inorder(root.right, count, kSmallest);
}

