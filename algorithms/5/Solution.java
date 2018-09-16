/**
* Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
*
* Example:
*
* Input: "babad"
*
* Output: "bab"
*
* Note: "aba" is also a valid answer.
* Example:
*
* Input: "cbbd"
*
* Output: "bb"
*
*/


public class Solution{
  public static void main(String[] args){
    Solution s = new Solution();
    System.out.println(s.longestPalindrome("babad"));
  }

  public String longestPalindrome(String s) {
    char[] sCharArr = s.toCharArray();

    int i = 0;
    int j = 0;

    while(j < sCharArr.length-1){
      j++;

      

    }

    return "";
  }
}
