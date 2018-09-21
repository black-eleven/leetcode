
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {
    public static void main(String[] args){
        Solution s = new Solution();

        int[] nums1 = new int[]{2, 4, 3};
        ListNode l1 = s.initList(nums1);
        s.printList(l1);

        int[] nums2 = new int[]{5, 6, 4};
        ListNode l2 = s.initList(nums2);
        s.printList(l2);

        s.printList(s.addTwoNumbers(l1, l2));
    }

    public ListNode initList(int[] nums) {
        if(nums.length == 0) {
        }
        ListNode root = new ListNode(nums[0]);
        ListNode tmp = root;
        for(int i=1; i < nums.length; i++) {
            ListNode mid = new ListNode(nums[i]);
            tmp.next = mid;
            tmp = mid;
        }
        return root;
    }

    public void printList(ListNode nums) {
        while(nums!=null) {
            System.out.println(nums.val);
            nums = nums.next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ret = null;
        ListNode retTmp = null;
        ListNode tmp1 = l1;
        ListNode tmp2 = l2;
        int add = 0;
        while(tmp1 != null || tmp2 != null || add != 0){
            int num1 = 0;
            int num2 = 0;

            num1 = (tmp1==null)?0:tmp1.val;
            num2 = (tmp2==null)?0:tmp2.val;

            int addint = num1+num2+add;

            add = addint/10;

            if(ret == null){
                retTmp = new ListNode(addint%10);
                ret = retTmp;
            }else{
                retTmp.next = new ListNode(addint%10);
                retTmp = retTmp.next;
            }

            tmp1 = (tmp1==null)?tmp1:tmp1.next;
            tmp2 = (tmp2==null)?tmp2:tmp2.next;
        }
        return ret;
    }
}
