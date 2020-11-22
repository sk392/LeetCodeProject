import java.util.HashMap;
import java.util.Map;

class CopyListwithRandomPointer {

    public static void main(String[] args) {
        Node node1 = new Node(7);
        Node node2 = new Node(13);
        Node node3 = new Node(11);
        Node node4 = new Node(10);
        Node node5 = new Node(1);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node1.random = null;
        node2.random = node1;
        node3.random = node5;
        node4.random = node3;
        node5.random = node1;

        copyRandomList(node1);
    }

    public static HashMap<Node, Node> newNodeMap = new HashMap<>();

    public static Node copyRandomList(Node head) {
        if (head == null) return null;
        Node newNode = new Node(head.val);

        newNodeMap.put(head, newNode);
        if (head.next != null) newNode.next = copyRandomList(head.next);

        if (head.random != null) newNode.random = newNodeMap.get(head.random);

        return newNode;
    }

    private static class Node {
        public int val;
        public Node next;
        public Node random;

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next, Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }

    ;

}
