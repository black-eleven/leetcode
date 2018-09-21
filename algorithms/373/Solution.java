/**
* You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.
*
* Define a pair (u,v) which consists of one element from the first array and one element from the second array.
*
* Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.
*
* Example 1:
* Given nums1 = [1,7,11], nums2 = [2,4,6],  k = 3
*
* Return: [1,2],[1,4],[1,6]
*
* The first 3 pairs are returned from the sequence:
* [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
* Example 2:
* Given nums1 = [1,1,2], nums2 = [1,2,3],  k = 2
*
* Return: [1,1],[1,1]
*
* The first 2 pairs are returned from the sequence:
* [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
* Example 3:
* Given nums1 = [1,2], nums2 = [3],  k = 3
*
* Return: [1,3],[2,3]
*
* All possible pairs are returned from the sequence:
* [1,3],[2,3]
*
*/

import java.util.*;

public class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
      int i = 0;
      int j = 0;
      int m = 1;
      List<int[]> ret = new ArrayList<int[]>();
      if(nums1.length == 0){
        return ret;
      }
      if(nums2.length == 0){
        return ret;
      }

      int min_sum = nums1[0] + nums2[0];
      int i_sum = min_sum;
      int j_sum = min_sum;

      while((i < nums1.length && j < nums2.length) && m < k){

        int tmp_i = i;
        while(tmp_i >= 0 && j+1 < nums2.length && min_sum >= nums1[tmp_i]+nums2[j+1]){
            System.out.println("A: " + min_sum + ", " + nums1[i] + ", " + nums2[j+1]);
            i_sum = nums1[tmp_i] + nums2[j+1];
            tmp_i--;
        }
        if(tmp_i < 0){
            tmp_i++;
        }

        int tmp_j = j;
        while (tmp_j >= 0 && i+1< nums1.length && min_sum >= nums1[i+1]+nums2[tmp_j]) {
            //System.out.println("B:" + min_sum + ", " + nums1[i+1] + ", " + nums2[j]);
            j_sum = nums1[i+1] + nums2[tmp_j];
            tmp_j--;
        }
        if(tmp_j < 0){
            tmp_j++;
        }

        if(i_sum > j_sum) {
            min_sum = j_sum;
            //i++;
            j = tmp_j;
        } else {
            min_sum = i_sum;
            //j++;
            i = tmp_i;
        }

        //System.out.println(min_sum);

        // int[] tmp = {nums1[i], nums2[j]};
        // ret.add(tmp);
        // tmp_sum = nums1[i] + nums2[j];
      }
      return ret;
    }

    public static void main(String[] args){
      Solution s = new Solution();
      int[] nums1 = {1, 1, 2};
      int[] nums2 = {1, 2, 3};
      List<int[]> ret = s.kSmallestPairs(nums1, nums2, 10);
      for(int [] a: ret) {
          for(int i=0; i < a.length; i++) {
            //System.out.print(a[i] + " ");
          }
          //System.out.println();
      }
    }
}
