class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        
        Map<Node, Node> oldToNew = new HashMap<>();
        
        Node current = head;
        while (current != null) {
            oldToNew.put(current, new Node(current.val));
            current = current.next;
        }
        
        current = head;
        while (current != null) {
            Node copy = oldToNew.get(current);
            
            if (current.next != null) {
                copy.next = oldToNew.get(current.next);
            }
            
            if (current.random != null) {
                copy.random = oldToNew.get(current.random);
            }
            
            current = current.next;
        }
        
        return oldToNew.get(head);
    }
}