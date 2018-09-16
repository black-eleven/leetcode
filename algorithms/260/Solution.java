/**
* Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.
*
* For example:
*
* Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].
*
* Note:
* The order of the result is not important. So in the above example, [5, 3] is also correct.
* Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
*/


public class Solution{
  public static void main(String[] args){
    Solution s = new Solution();
    int[] a = {1, 2, 1, 3, 2, 5};
    s.singleNumber(a);
  }

  public int[] singleNumber(int[] nums) {
    int andInt = 1;
    int orInt = 1;
    int xorInt = 0;
    for(int tmp : nums){
      andInt &= tmp;
      orInt |= tmp;
      xorInt ^= tmp;
    }

    System.out.println(andInt);
    System.out.println(orInt);
    System.out.println(xorInt);

    System.out.println();

    System.out.println(3&5);
    System.out.println(3|5);
    System.out.println(3^5);

    System.out.println();

    System.out.println(7&6);
    System.out.println(7|6);
    System.out.println(7^6);

    return null;
  }
}
