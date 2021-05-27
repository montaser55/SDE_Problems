class Solution {
	
	//Use HashMap to locate copy node and point next and random accordingly.
	//Time: O(n)
	//Space: O(n)
	
	//Create new node in between original nodes. Point random pointers of the new nodes. Separate new nodes.
	//Time: O(n)
	//Space: O(1)
    public Node copyRandomList(Node head) {
        if(head==null)return null;
        
        Node curr=head;
        while(curr!=null){
            Node temp=curr.next;
            Node newNode=new Node(curr.val);
            curr.next=newNode;
            newNode.next=temp;
            curr=temp;
        }
        
        curr=head;
        while(curr!=null){
            if(curr.random!=null){
            curr.next.random=curr.random.next;
            }
            curr=curr.next.next;
        }
        
        curr=head;
        Node dummy=new Node(0);
        Node copyCurr=dummy;
        while(curr!=null){
            copyCurr.next=curr.next;
            curr.next=curr.next.next;
            copyCurr=copyCurr.next;
            curr=curr.next;
        }
        return dummy.next;
    }
}