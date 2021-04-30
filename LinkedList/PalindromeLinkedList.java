class Solution {
	
	//Reverse from middle and check nodes
	//Time: O(n)
	//Space: O(1) 
    public boolean isPalindrome(ListNode head) {
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        if(fast!=null){
            slow=slow.next;
        }
        ListNode middle=slow;
        slow=reverseList(slow);
        while(slow!=null){
            if(head.val!=slow.val){
                reverseList(middle);
                return false;
            }
            head=head.next;
            slow=slow.next;
        }
        reverseList(middle);
        return true;
    }
    public ListNode reverseList(ListNode head){
        ListNode pre=null;
        ListNode curr=head;
        while(curr!=null){
            ListNode temp=curr.next;
            curr.next=pre;
            pre=curr;
            curr=temp;
        }
        return pre;
    }
}