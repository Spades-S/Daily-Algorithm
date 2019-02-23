/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    public Node() {}

    public Node(boolean _val,boolean _isLeaf,Node _topLeft,Node _topRight,Node _bottomLeft,Node _bottomRight) {
        val = _val;
        isLeaf = _isLeaf;
        topLeft = _topLeft;
        topRight = _topRight;
        bottomLeft = _bottomLeft;
        bottomRight = _bottomRight;
    }
};
*/
class Solution {
    public Node construct(int[][] grid) {
        return helper(0, 0, grid.length, grid);
        
    }
    public Node helper(int x, int y, int width, int[][] grid){
        if(width == 1){
            
            return new Node(grid[x][y] == 1 ? true: false, true, null, null, null, null);
        }
        Node root = new Node(false, false, null, null, null, null);
        Node topLeft = helper(x, y, width / 2, grid);
        Node topRight = helper(x, y + width / 2, width / 2, grid);
        Node bottomLeft = helper(x + width / 2, y, width / 2, grid);
        Node bottomRight = helper(x + width / 2, y + width / 2, width /2, grid);
        if(topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf){
            if(topLeft.val && topRight.val && bottomLeft.val && bottomRight.val){
                root.isLeaf = true;
                root.val = true;
                return root;
            }
            if(!(topLeft.val || topRight.val || bottomLeft.val || bottomRight.val)){
                root.isLeaf = true;
                root.val = false;
                return root;
            }
        }
        root.topLeft = topLeft;
        root.topRight = topRight;
        root.bottomLeft = bottomLeft;
        root.bottomRight = bottomRight;
        return root;
    }
}