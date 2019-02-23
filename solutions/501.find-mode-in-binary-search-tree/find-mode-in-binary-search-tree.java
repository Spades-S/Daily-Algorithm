/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    public int[] findMode(TreeNode root) {
        if(root == null) return new int[0];
        Stack<Integer> res = new Stack<Integer>();
        Stack<TreeNode> traversal = new Stack<TreeNode>();
        TreeNode curNode = root, lastNode = null;
        int curVal = root.val;
        int lastCnt = 0;
        int curCnt = 0;
        while(curNode != null || !traversal.isEmpty()){
            if(curNode != null){
                traversal.push(curNode);
                curNode = curNode.left;
            }else{
                lastNode = traversal.pop();
                System.out.println(lastNode.val);
                if(lastNode.val != curVal){
                    
                    if(curCnt > lastCnt){
                        res = new Stack<Integer>();
                        res.push(curVal);
                        lastCnt = curCnt;
                        
                    }else if(curCnt == lastCnt){
                        res.push(curVal);
                    }
                    curCnt = 1;
                    curVal = lastNode.val;
                    
                }else{
                    curCnt++;
                }
                curNode = lastNode.right;
            }
        }
        if(curCnt > lastCnt){
            res = new Stack<Integer>();
            res.push(lastNode.val);
        }else if(curCnt == lastCnt){
            res.push(lastNode.val);
        }
        
        int[] result = new int[res.size()];
        for(int i = 0; !res.isEmpty(); i++){
            result[i] = res.pop();
        }
        return result;
    }
}