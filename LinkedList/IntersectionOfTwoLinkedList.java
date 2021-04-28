public class Solution {
	
	//Brute Force
	//Time: O(l1*l2)
	//Space: O(1)
    public ListNode getIntersectionNodeBruteForce(ListNode headA, ListNode headB) {
        ListNode temp;
        while(headA!=null){
            temp=headB;
            while(temp!=null){
                if(headA==temp)
                    return headA;
                temp=temp.next;
            }
            headA=headA.next;
        }
        return null;
    }
	
	//Hashing
	//Time: O(l1+l2)
	//Space: O(l1)
	public ListNode getIntersectionNodeHashing(ListNode headA, ListNode headB) {
        Set<ListNode> set=new HashSet<>();
        while(headA!=null){
            set.add(headA);
            headA=headA.next;
        }
        while(headB!=null){
            if(set.contains(headB))
                return headB;
            headB=headB.next;
        }
        return null;
    }
	
	//Make both linkedlist equal length, then find out iteratively
	//Time: O(l1+l2)
	//Space: O(1)
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int count1=0,count2=0;
        ListNode currA=headA,currB=headB;
        while(currA!=null){
            count1++;
            currA=currA.next;
        }
        while(currB!=null){
            count2++;
            currB=currB.next;
        }
        int diff=Math.abs(count1-count2);
        if(count1>count2){
            while(diff>0){
                headA=headA.next;
                diff--;
            }
        }
        else{
            while(diff>0){
                headB=headB.next;
                diff--;
            }
        }
        while(headA!=null && headB!=null){
            if(headA==headB)return headA;
            headA=headA.next;
            headB=headB.next;
        }
        return null;
    }

	
	//Iterate over a linkedlist and then go to the next one
	//Time: O(l1+l2)
	//Space: O(1)
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null||headB==null)return null;
        ListNode curr1=headA;
        ListNode curr2=headB;
        while(curr1!=curr2){
            if(curr1==null){
                curr1=headB;
            }
            else{
                curr1=curr1.next;
            }
            if(curr2==null){
                curr2=headA;
            }else{
                curr2=curr2.next;
            }
        }
        return curr1;
    }
}