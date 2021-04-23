class Solution {
	
	//Basic solution
	//Time: O(n)
	//Space: O(1)
    public ListNode reverseList(ListNode head) {
        ListNode curr=head;
        ListNode pre=null;
        while(curr!=null){
            ListNode temp=curr.next;
            curr.next=pre;
            pre=curr;
            curr=temp;
        }
        return pre;
    }
}