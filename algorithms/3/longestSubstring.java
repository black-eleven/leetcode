public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int pptr = 0;
        int eptr = 0;
        int ll = 0;
        int max = 0;

        while(eptr <= s.length()-1 && ((max)<(s.length()-pptr))){
            String lstStr = s.substring(eptr, eptr+1);
            String tmpStr = s.substring(pptr, eptr);
            int samePtr = tmpStr.indexOf(lstStr);
            if(samePtr == -1){
                ll++;
            }else{
                ll -= (samePtr);
                pptr += samePtr+1;
            }

            if(ll > max){
                max = ll;
            }
            eptr++;
        }

        if(s.length() == 1){
            return 1;
        }

        return max;
    }
}
