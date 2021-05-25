class Solution {
	
	//Rotate 3 times
	//Time: O(3n)
	//Space: O(1)
    public ListNode rotateRight(ListNode head, int k) {
        if(k==0|| head==null||head.next==null)return head;
        int count=0;
        ListNode dummy=new ListNode();
        dummy.next=head;
        ListNode curr=head;
        while(curr!=null){
            curr=curr.next;
            count++;
        }
        k=k%count;
        dummy.next=rotate(dummy.next,count);
        dummy.next=rotate(dummy.next,k);
        curr=dummy;
        int temp=k;
        while(temp>0){
            curr=curr.next;
            temp--;
        }
        
        curr.next=rotate(curr.next,count-k);
        return dummy.next;
    }
    
    public ListNode rotate(ListNode head,int k){
        if (k==1||k==0)return head;
        ListNode pre=null;
        ListNode curr=head;
        while(k>0){
            ListNode temp=curr.next;
            curr.next=pre;
            pre=curr;
            curr=temp;
            k--;
        }
        head.next=curr;
        return pre;
    }
	
	//Cycle linked list
	//Time: O(n)
	//Space: O(1)
	public ListNode rotateRightCyclic(ListNode head, int k) {
        if(k==0||head==null||head.next==null)return head;
        int len=1;
        ListNode curr=head;
        while(curr.next!=null){
            curr=curr.next;
            len++;
        }
        
        k=k%len;
        if(k==0)return head;
        
        curr.next=head;
        
        k=len-k;
        while(k-->0){
            curr=curr.next;
        }
        
        head=curr.next;
        curr.next=null;
        
        return head;
    }
}