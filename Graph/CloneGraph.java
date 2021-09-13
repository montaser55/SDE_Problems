class Solution {
    
	//Time: O(n+e)
	//Space: O(n)
    public Node cloneGraph(Node node) { 
        HashMap<Integer, Node> map = new HashMap<>();
     
        return clone(node,map);
    }
    
    public Node clone(Node node, HashMap<Integer, Node> map) { 
        if (node==null) return null;
        
        if(map.containsKey(node.val)){
            return map.get(node.val);
        }
        
        Node newNode = new Node(node.val);
        map.put(node.val,newNode);
        
        for(Node n: node.neighbors){
            newNode.neighbors.add(clone(n,map));
        }
        
        return newNode;
    }
}