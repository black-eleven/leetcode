/**
* Given a set of candidate numbers (C) (without duplicates) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
* The same repeated number may be chosen from C unlimited number of times.
* Note:
* All numbers (including target) will be positive integers.
* The solution set must not contain duplicate combinations.
*
* For example, given candidate set [2, 3, 6, 7] and target 7,
* A solution set is:
* [
*   [7],
*   [2, 2, 3]
* ]
*/

import java.util.*;

public class Solution{
  public List<List<Integer>> combinationSumRecursive(int[] candidates, int target, int i) {
    if(target == 0){
      List<List<Integer>> ret = new ArrayList<List<Integer>>();
      List<Integer> innerRet = new ArrayList<Integer>();
      ret.add(innerRet);
      return ret;
    }else if(target < 0){
      return null;
    }else{
      List<List<Integer>> retList = new ArrayList<List<Integer>>();
      for(int j = i; j < candidates.length; j++){
        int cd = candidates[j];
        List<List<Integer>> midList = combinationSumRecursive(candidates, target-cd, i);
        if(midList != null){
          for(List<Integer> mp : midList){
            mp.add(cd);
          }
          retList.addAll(midList);
        }
        i++;

      }
      return retList;
    }
  }

  public List<List<Integer>> combinationSum(int[] candidates, int target) {
      return combinationSumRecursive(candidates, target, 0);
  }

  public static void main(String[] args){
    int[] aa = {2, 3, 6, 7};
    Solution s = new Solution();
    System.out.println(s.combinationSum(aa, 7));
  }
}
