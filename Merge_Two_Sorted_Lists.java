package algorithms;

public class Merge_Two_Sorted_Lists {
    //Input: 1->2->4, 1->3->4
    //Output: 1->1->2->3->4->4
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val){
            this.val = val;
        }
        ListNode(int val, ListNode next){
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args){
        ListNode l11 = new ListNode(1);
        ListNode l12 = new ListNode(2);
        ListNode l13 = new ListNode(4);
        ListNode l21 = new ListNode(1);
        ListNode l22 = new ListNode(3);
        ListNode l23 = new ListNode(4);
//        ListNode l24 = new ListNode(8);

        l11.next = l12;
        l12.next = l13;
        l21.next = l22;
        l22.next = l23;
//        l23.next = l24;

        ListNode mergedList = merge_linked_list_sort(l11, l21);
        printList(mergedList);
    }

    public static ListNode merge_linked_list_sort(ListNode l1, ListNode l2){
        while(l2 != null){
            l1 = insertNode(l1, l2);
            l2 = l2.next;
        }
        return l1;
    }

    public static void printList(ListNode a){
        while(a != null){
            System.out.println(a.val);
            a = a.next;
        }
    }

    public static ListNode insertNode(ListNode l1, ListNode l2){
        ListNode new_node = new ListNode(l2.val);
        if(l1.next == null && (l1.val <= new_node.val)){
            l1.next = new_node;
            return l1;
        }
        if(l1.next == null && (l1.val > new_node.val)){
            new_node.next = l1;
            l1 = new_node;
            return l1;
        }

        ListNode ptr = l1;
        int pos = 0;
        while(ptr != null){
            if(ptr.val <= new_node.val) {
                   pos++;
            } else {
                break;
            }
            ptr = ptr.next;
        }
        ptr = l1;
        if(pos == 0){
            new_node.next = l1;
            l1 = new_node;
            return l1;
        }
        while(pos-- > 1){
            ptr = ptr.next;
        }
        new_node.next = ptr.next;
        ptr.next = new_node;
        return l1;
    }
}
