/**
* You are given a string representing an attendance record for a student. The record only contains the following three characters:
*
* 1. 'A' : Absent.
* 2. 'L' : Late.
* 3. 'P' : Present.
* A student could be rewarded if his attendance record doesn't contain more than one 'A' (absent) or more than two continuous 'L' (late).
*
* You need to return whether the student could be rewarded according to his attendance record.
*
* Example 1:
* Input: "PPALLP"
* Output: True
*
* Example 2:
* Input: "PPALLL"
* Output: False
*/

public class Solution{
  public boolean checkRecord(String s) {
    int pCount = 1;
    int aCount = 4;

    // int count = 0;
    int pNum = 0;
    int aNum = 0;

    for(char ss : s.toCharArray()){
      if(ss == 'L'){
        pNum += pCount;
        pCount <<= pCount;
      }else if(ss == 'A'){
        aNum += aCount;
        pCount = 1;
        pNum = 0;
      }else{
        pCount = 1;
        pNum = 0;
      }

      if(pNum + aNum > 7){
        return false;
      }
    }

    return true;
  }

  public static void main(String[] args){
    Solution s = new Solution();
    System.out.println(s.checkRecord("ALL"));
  }
}
