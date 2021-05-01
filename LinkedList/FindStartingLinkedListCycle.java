public class Solution {
	
	//Two pointer soultion
	//Time: O(n)
	//Space: O(1)
    public ListNode detectCycle(ListNode head) {
        ListNode fast=head;
        ListNode slow=head;
        boolean hasCycle=false;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                hasCycle=true;
                break;
            }
        }
        if(!hasCycle){
            return null;
        }
        fast=head;
        while(fast!=slow){
            fast=fast.next;
            slow=slow.next;
        }
        return fast;
    }
}