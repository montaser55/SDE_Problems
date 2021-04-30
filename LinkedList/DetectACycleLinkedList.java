public class Solution {
	
	//Hashing
	//Time: O(n)
	//Space: O(1)
    public boolean hasCycleHashing(ListNode head) {
        Set<ListNode> set=new HashSet<>();
        while(head!=null){
            if(set.contains(head))return true;
            else{
                set.add(head);
                head=head.next;
            }
        }
        return false; 
    }
	
	//Two pointer
	//Time: O(n)
	//Space: O(1)
	public boolean hasCycleTwoPointer(ListNode head) {
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow)return true;
        }
        return false;
    }
}