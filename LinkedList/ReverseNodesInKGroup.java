class Solution {
	
	//Optimal solution
	//Time: O(n)
	//Space: O(1)
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null||k==1)return head;
        
        ListNode dummy=new ListNode();
        dummy.next=head;
        ListNode pre=dummy,curr=head,next;
        int count=0;
        while(curr!=null){
            count++;
            curr=curr.next;
        }
         
        while(count>=k){
            curr=pre.next;
            next=curr.next;
            for(int i=1;i<k;i++){
                curr.next=next.next;
                next.next=pre.next;
                pre.next=next;
                next=curr.next;
            }
            count-=k;
            pre=curr;
        }
        return dummy.next;
    }
}