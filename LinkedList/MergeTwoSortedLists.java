class Solution {
	//With extra space
	//Time: O(n1+n2)
	//Space: O(n1+n2)
    public ListNode mergeTwoListsWithExtraLinkedList(ListNode l1, ListNode l2) {
        ListNode dummy=new ListNode();
        ListNode curr=dummy,temp;
        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
                temp=new ListNode(l1.val);
                l1=l1.next;
            }
            else{
                temp=new ListNode(l2.val);
                l2=l2.next;
            }
            curr.next=temp;
            curr=curr.next;
        }
        while(l1!=null){
            curr.next=new ListNode(l1.val);
            l1=l1.next;
            curr=curr.next;
        }
        while(l2!=null){
            curr.next=new ListNode(l2.val);
            l2=l2.next;
            curr=curr.next;
        }
        return dummy.next;
    }
	
	//Iterative choice
	//Time: O(n1+n2)
	//Space: O(1)
	public ListNode mergeTwoListsIterative(ListNode l1, ListNode l2) {
        ListNode dummy=new ListNode();
        ListNode curr=dummy;
        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
                curr.next=l1;
                l1=l1.next;
                curr=curr.next;
            }
            else{
                curr.next=l2;
                l2=l2.next;
                curr=curr.next;
            }
        }
        while(l1!=null){
            curr.next=l1;
            l1=l1.next;
            curr=curr.next;
        }
        while(l2!=null){
            curr.next=l2;
            l2=l2.next;
            curr=curr.next;
        }
        return dummy.next;
    }
	
	//Recursive choice
	//Time: O(n1+n2)
	//Space: O(1)
	public ListNode mergeTwoListsRecursion(ListNode l1, ListNode l2) {
        if(l1==null)return l2;
        if(l2==null)return l1;
        if(l1.val<l2.val){
            l1.next=mergeTwoListsRecursion(l1.next,l2);
            return l1;
        }
        else{
            l2.next=mergeTwoLists(l1,l2.next);
            return l2;
        }
    }
}