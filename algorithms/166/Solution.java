/**
* Given two integers representing the numeratorLong and denominatorLong of a fraction, return the fraction in string format.
*
* If the fractional part is repeating, enclose the repeating part in parentheses.
*
* For example,
*
* Given numeratorLong = 1, denominatorLong = 2, return "0.5".
* Given numeratorLong = 2, denominatorLong = 1, return "2".
* Given numeratorLong = 2, denominatorLong = 3, return "0.(6)".
*/

import java.util.*;

public class Solution{
  public static void main(String[] args){
    Solution s = new Solution();
    int numerator = -50;
    int denominator = 8;
    System.out.println(s.fractionToDecimal(numerator, denominator));
  }

  public String fractionToDecimal(int numerator, int denominator) {
    List<Long> divisionList = new ArrayList<Long>();
    Map<Long, Integer> residueMap = new HashMap<Long, Integer>();
    int i = 0;
    int getI = -4;
    long residue = -1;

    long numeratorLong = (long)numerator;
    long denominatorLong = (long)denominator;

    if(numeratorLong == 0){
      return "0";
    }

    boolean numF = (numeratorLong<0);
    if(numF){numeratorLong = -numeratorLong;}
    boolean denF = (denominatorLong<0);
    if(denF){denominatorLong = -denominatorLong;}

    boolean fu = numF ^ denF;

    do{

      if(numeratorLong < denominatorLong){
        residueMap.put(numeratorLong, i);
        numeratorLong *= 10;
        divisionList.add(0L);
      }else{
        Long div = numeratorLong/denominatorLong;
        residue = numeratorLong - div*denominatorLong;
        numeratorLong = residue*10;
        divisionList.add(div);
        if(residueMap.containsKey(residue)){
          getI = residueMap.get(residue);
          break;
        }else{
          residueMap.put(residue, i);
        }
      }
      i++;
    }while(residue != 0);
    String ret = fu?"-":"";
    int tmp = 0;
    for(long j : divisionList){
      if(tmp == (getI+1)){
        ret += "(";
      }
      ret += j;
      if(tmp == 0 && divisionList.size() != 1){
        ret += ".";
      }

      tmp++;
    }
    return getI<0?ret:ret+")";
  }
}
