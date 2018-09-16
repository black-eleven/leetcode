/**
* Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
*
* Subscribe to see which companies asked this question.
*
* Definition for singly-linked list.
*
* public class ListNode {
*     int val;
*     ListNode next;
*     ListNode(int x) { val = x; }
* }
*/


public class Solution{
  public static void main(String[] args){
    ListNode l1 = new ListNode(2);
    l1.next = new ListNode(5);
    l1.next.next = new ListNode(6);

    ListNode l2 = new ListNode(1);
    l2.next = new ListNode(2);
    l2.next.next = new ListNode(9);
    l2.next.next.next = new ListNode(11);

    Solution s = new Solution();
    s.printList(s.mergeTwoLists(l1, l2));
  }

  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if(l1 == null){
      return l2;
    }

    if(l2 == null){
      return l1;
    }
    ListNode ret;
    if(l1.val > l2.val){
        ret = l2;
        l2 = l2.next;
    } else {
        ret = l1;
        l1 = l1.next;
    }
    ListNode tmp = ret;

    while(l1 != null && l2 != null){
      if(l1.val > l2.val){
        tmp.next = l2;
        tmp = l2;
        l2 = l2.next;
      }else{
        tmp.next = l1;
        tmp = l1;
        l1 = l1.next;
      }
    }

    tmp.next = (l1==null ? l2 : l1);

    return ret;
  }

  public void printList(ListNode l){
    while(l != null){
      System.out.println(l.val);
      l = l.next;
    }
  }
}


class ListNode{
  int val;
  ListNode next;
  ListNode(int x){ val = x;}
}
