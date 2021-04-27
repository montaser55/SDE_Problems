class Solution {
	
	//Add from two linkedlists and then from the longer one
	//Time: O(max(n1,n2))
	//Space: O(n)
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy=new ListNode();
        ListNode curr=dummy;
        int carry=0;
        while(l1!=null && l2!=null){
            carry+=l1.val+l2.val;
            ListNode temp=new ListNode(carry%10);
            curr.next=temp;
            curr=curr.next;
            carry=carry/10;
            l1=l1.next;
            l2=l2.next;
        }
        while(l1!=null){
            carry+=l1.val;
            ListNode temp=new ListNode(carry%10);
            curr.next=temp;
            curr=curr.next;
            carry=carry/10;
            l1=l1.next;
        }
        while(l2!=null){
            carry+=l2.val;
            ListNode temp=new ListNode(carry%10);
            curr.next=temp;
            curr=curr.next;
            carry=carry/10;
            l2=l2.next;
        }
        if(carry>0){
            ListNode temp=new ListNode(1);
            curr.next=temp;
        }
        return dummy.next;
    }
}