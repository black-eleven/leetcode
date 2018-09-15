/**
* Compare two version numbers version1 and version2.
* If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.
*
* You may assume that the version strings are non-empty and contain only digits and the . character.
* The . character does not represent a decimal point and is used to separate number sequences.
* For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.
*
* Here is an example of version numbers ordering:
*
* 0.1 < 1.1 < 1.2 < 13.37
*/

import java.util.*;

public class Solution{
  public int compareVersion(String version1, String version2) {
    String[] version1Str = version1.split("\\.");
    String[] version2Str = version2.split("\\.");
    int i;
    for(i = 0; i < version1Str.length || i < version2Str.length; i++){

      int v1 = (i < version1Str.length)?Integer.parseInt(version1Str[i]):0;
      int v2 = (i < version2Str.length)?Integer.parseInt(version2Str[i]):0;
      if(v1 == v2){
        continue;
      }
      if(v1 > v2){
        return 1;
      }

      if(v1 < v2){
        return -1;
      }
    }

    return 0;
  }

  public static void main(String[] args){
    String version1 = "1.0";
    String version2 = "1";
    Solution s = new Solution();
    System.out.println(s.compareVersion(version1, version2));
  }
}
