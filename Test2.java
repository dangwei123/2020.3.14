输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
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
    List<List<Integer>> res;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        res=new LinkedList<>();
        List<Integer> tmp=new LinkedList<>();
        pathSum(root,sum,tmp);
        return res;
    }
    private void pathSum(TreeNode root,int target,List<Integer> row){
        if(root==null) return ;
        row.add(root.val);
        target-=root.val;
        if(target==0&&root.left==null&&root.right==null){
            res.add(new LinkedList(row));
            row.remove(row.size()-1);
            return;
        }
        pathSum(root.left,target,row);
        pathSum(root.right,target,row);
        row.remove(row.size()-1);
    }
}

给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m] 。请问 k[0]*k[1]*...*k[m] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/jian-sheng-zi-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    public int cuttingRope(int n) {
        if(n<=3) return n-1;
        int a=n/3;
        int b=n%3;
        if(b==0) return (int)Math.pow(3,a);
        if(b==1) return (int)Math.pow(3,a-1)*4;
        if(b==2) return (int)Math.pow(3,a)*2;
        return 0;
    }
}

