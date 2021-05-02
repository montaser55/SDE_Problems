class GfG
{
	//From last merge two linkedlists and keep returning
	//Time: O(n*m)
	//Space: O(1)
    Node merge(Node a,Node b){
        Node dummy=new Node(0);
        Node curr=dummy;
        while(a!=null && b!=null){
            if(a.data<b.data){
                curr.bottom=a;
                curr=curr.bottom;
                a=a.bottom;
            }else{
                curr.bottom=b;
                curr=curr.bottom;
                b=b.bottom;
            }
        }
        if(a!=null){
            curr.bottom=a;
        }
        if(b!=null){
            curr.bottom=b;
        }
        return dummy.bottom;
    }
    Node flatten(Node root)
    {
    	if(root==null)return null;
    	//System.out.println(root.data);
    	Node next=flatten(root.next);
    	return merge(root,next);
    	
    }
}