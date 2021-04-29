class Solution {
	
	//Copy the next value and then remove the next node
	//Time: O(1)
	//Space: O(1)
    public void deleteNode(ListNode node) {
        node.val=node.next.val;
        node.next=node.next.next;
    }
}