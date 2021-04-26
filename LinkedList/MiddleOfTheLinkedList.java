class Solution {
	//Two pass
	//Time: O(n)+O(n/2)
	//Space: O(1)
	At first pass count total nodes. Then go to middle and return.
	
	//Two Pointer;
	//Time: O(n/2)
	//Space: O(1)
    public ListNode middleNode(ListNode head) {
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
}