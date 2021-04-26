class Solution {
	
	//Two pass
	//Time: O(2n)
	//Space: O(1)
	Travel the linked list first time to count total nodes. Then calculate and start from head to the required number of node and skip it.
	
	
	//One Pass
	//Time: O(n)
	//Space: O(1)
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy=new ListNode();
        dummy.next=head;
        ListNode fast=dummy;
        ListNode slow=dummy;
        while(n>0){
            fast=fast.next;
            n--;
        }
        while(fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }
        slow.next=slow.next.next;
        return dummy.next;
        
    }
}