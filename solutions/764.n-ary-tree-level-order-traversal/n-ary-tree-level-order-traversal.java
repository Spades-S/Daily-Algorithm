/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    public List<List<Integer>> res = new ArrayList<List<Integer>>();
    public List<List<Integer>> levelOrder(Node root) {
        helper(root, 0);
        return res;
    }
    
    public void helper(Node node, int deepth){
        if(node == null) return;
        if(res.size() > deepth){
            res.get(deepth).add(node.val);
        }else{
            List<Integer> list = new ArrayList<Integer>();
            list.add(node.val);
            res.add(list);
        }
        for(int i = 0; i < node.children.size(); i++){
            helper(node.children.get(i), deepth + 1);
        }
    }
}