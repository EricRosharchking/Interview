public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode n7 = new ListNode(7);
        ListNode n6 = new ListNode(6);
        ListNode n5 = new ListNode(5);
        ListNode n4 = new ListNode(4);
        ListNode n3 = new ListNode(3);
        ListNode n2 = new ListNode(2);
        ListNode n1 = new ListNode(1);
        n6.setNext(n7);
        n5.setNext(n6);
        n4.setNext(n5);
        n3.setNext(n4);
        n2.setNext(n3);
        n1.setNext(n2);

        ListNode head = n1;

        while (head.getNext() != null) {
            System.out.print(head.getVal() + " ");
            head = head.getNext();
        }
        System.out.println(head.getVal());

        head = reverse(n1);
        while (head.getNext() != null) {
            System.out.print(head.getVal() + " ");
            head = head.getNext();
        }
        System.out.println(head.getVal());
    }

    public static ListNode reverse(ListNode head) {
        ListNode node = new ListNode();
        if (head.getNext() == null) {
            node = head;
        // } else if(head.getNext().getNext() == null) {
        //     Node tmp1 = new Node(head.getNext().getVal(), head);
        //     node = tmp1;
        //     head.setNext(null);
        // } else if(head.getNext().getNext().getNext() == null) {
        //     Node tmp1 = new Node(head.getNext().getNext().getVal(), head.getNext());
        //     Node tmp2 = new Node(head.getNext().getVal(), head);
        //     tmp1.setNext(tmp2);
        //     head.setNext(null);
        //     node = tmp1;
        // } else if(head.getNext().getNext().getNext().getNext() == null) {
        //     Node tmp1 = new Node(head.getNext().getNext().getNext().getVal(), head.getNext().getNext());
        //     Node tmp2 = new Node(head.getNext().getNext().getVal(), head.getNext());
        //     Node tmp3 = new Node(head.getNext().getVal(), head);
        //     tmp1.setNext(tmp2);
        //     tmp2.setNext(tmp3);
        //     head.setNext(null);
        //     node = tmp1;
        } else {
            node = reverse(head, head.getNext());
            head.setNext(null);
        }

        return node;
    }

    public static ListNode reverse(ListNode head, ListNode tail) {
        ListNode newHead = new ListNode();
        if (tail.getNext() == null) {
            newHead.setVal(tail.getVal());
            newHead.setNext(head);
        } else {
            newHead.setNext(head);
            newHead.setVal(tail.getVal());
            ListNode tmp = reverse(newHead, tail.getNext());
            tail.setNext(null);
            newHead = tmp;
        }
        return newHead;

    }

}
