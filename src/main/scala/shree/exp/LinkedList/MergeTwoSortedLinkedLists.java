package shree.exp.LinkedList;


public class MergeTwoSortedLinkedLists {

    public static void main(String[] args) {

        int[] list1 = {2,4,6,8,9};
        int[] list2 = {1,2,3,5,7,10,12};

        Node head1 = new Node(list1[0]);
        Node curr1 = head1;
        System.out.println("List-1: ");
        for (int i = 1; i < list1.length; i++) {
            System.out.print(list1[i]+",");
            curr1.next = new Node(list1[i]);
            curr1 =  curr1.next;
        }

        Node head2 = new Node(list2[0]);
        Node curr2 = head2;
        System.out.println("List-2: ");
        for (int i = 1; i < list2.length; i++) {
            System.out.print(list2[i]+",");
            curr2.next = new Node(list2[i]);
            curr2 =  curr2.next;
        }

        Node mergedHead = merge(head1, head2);

        System.out.println("merged: ");
        while(mergedHead != null) {

            System.out.print(mergedHead.data+", ");
            mergedHead = mergedHead.next;
        }


    }

    private static Node merge(Node list1, Node list2) {

        Node toReturnListHead = null;

        if(toReturnListHead == null) {
            if(list1.data < list2.data) {
                toReturnListHead = list1;
                list1 = list1.next;
            } else {
                toReturnListHead = list2;
                list2 = list2.next;
            }
            toReturnListHead.next = null;
        }

        Node curr = toReturnListHead;

        while(list1 != null && list2 != null) {
            if(list1.data < list2.data) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
            curr.next = null;
        }

        while(list1 != null ) {
            curr.next = list1;
            list1 = list1.next;
            curr = curr.next;
        }

        while(list2 != null) {
            curr.next = list2;
            list2 = list2.next;
            curr = curr.next;
        }

        return toReturnListHead;
    }

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }
}
