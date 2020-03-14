输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head=new ListNode(-1);
        ListNode cur=head;
        while(l1!=null&&l2!=null){
            if(l1.val<l2.val){
                cur.next=l1;
                l1=l1.next;
                cur=cur.next;
            }else{
                cur.next=l2;
                l2=l2.next;
                cur=cur.next;
            }
        }
        if(l1!=null){
            cur.next=l1;
        }
        if(l2!=null){
            cur.next=l2;
        }
        return head.next;
    }
}

给定一个无序的整数数组，找到其中最长上升子序列的长度。
class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] res=new int[nums.length];
        int j=0;
        for(int i=0;i<nums.length;i++){
            int left=0;
            int right=j;
            while(left<right){
                int mid=(left+right)>>>1;
                if(res[mid]<nums[i]){
                    left=mid+1;
                }else{
                    right=mid;
                }
            }
            res[left]=nums[i];
            if(left==j){
                j++;
            }
        }
        return j;
    }
}

