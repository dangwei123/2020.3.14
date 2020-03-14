请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list=new LinkedList<>();
        Deque<TreeNode> queue=new LinkedList<>();
        if(root==null) return list;
        queue.offer(root);
        int i=0;
        while(!queue.isEmpty()){
            i++;
            int size=queue.size();
            List<Integer> row=new LinkedList<>();
            while(size--!=0){
                TreeNode cur=queue.pollFirst();
                row.add(cur.val);
                if(cur.left!=null) queue.offer(cur.left);
                if(cur.right!=null) queue.offer(cur.right);
            }
            if(i%2==0) Collections.reverse(row);
            list.add(row);
        }
        return list;
    }
}


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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list=new LinkedList<>();
        Deque<TreeNode> queue=new LinkedList<>();
        if(root==null) return list;
        queue.offer(root);
        boolean flag=true;
        while(!queue.isEmpty()){
            int size=queue.size();
            List<Integer> row=new LinkedList<>();
            while(size--!=0){
                if(flag){
                    TreeNode cur=queue.pollFirst();
                    row.add(cur.val);
                    if(cur.left!=null) queue.offerLast(cur.left);
                    if(cur.right!=null) queue.offerLast(cur.right);
                }else{
                    TreeNode cur=queue.pollLast();
                    row.add(cur.val);
                    if(cur.right!=null) queue.offerFirst(cur.right);
                    if(cur.left!=null) queue.offerFirst(cur.left);
                }
            }
            flag=!flag;
            list.add(row);
        }
        return list;
    }
}

输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
class Solution {
    public String minNumber(int[] nums) {
        List<String> list=new LinkedList<>();
        for(int num:nums){
            list.add(String.valueOf(num));
        }
        list.sort((s1,s2)->(s1+s2).compareTo(s2+s1));
        StringBuilder sb=new StringBuilder();
        while(!list.isEmpty()){
            sb.append(list.remove(0));
        }
        return new String(sb);
    }
}

输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如，序列 {1,2,3,4,5} 是某栈的压栈序列，序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。

 

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/zhan-de-ya-ru-dan-chu-xu-lie-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack=new Stack<>();
        int index=0;
        for(int i:pushed){
            stack.push(i);
            while(index<popped.length&&!stack.isEmpty()&&stack.peek()==popped[index]){
                stack.pop();
                index++;
            }
        }
        return index==pushed.length;
    }
}

