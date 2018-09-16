/**
* There are two sorted arrays nums1 and nums2 of size m and n respectively.
*
* Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
*
* Example 1:
* nums1 = [1, 3]
* nums2 = [2]
*
* The median is 2.0
* Example 2:
* nums1 = [1, 2]
* nums2 = [3, 4]
*
* The median is (2 + 3)/2 = 2.5
*
*/


public class Solution{
  public static void main(String[] args){
    Solution s = new Solution();
    // int[] nums1 = {1, 3, 5, 7, 9};
    // int[] nums2 = {2, 4, 6, 8};
    // int[] nums1 = {1, 5, 7, 15};
    // int[] nums2 = {2, 3, 4, 9, 17, 40};
    // int[] nums1 = {1, 5};
    // int[] nums2 = {4, 9};
    // int[] nums1 = {2};
    // int[] nums2 = {4, 9};
    // int[] nums1 = {1, 2};
    // int[] nums2 = {1, 2};
    int[] nums1 = {1};
    int[] nums2 = {2,3,4};
    System.out.println(s.findMedianSortedArrays(nums1, nums2));
  }

  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    if(nums1.length == 0){
      return (nums2.length % 2 == 0) ? (((double)nums2[nums2.length/2]+nums2[nums2.length/2-1]))/2: nums2[nums2.length/2];
    }

    if(nums2.length == 0){
      return (nums1.length % 2 == 0) ? (((double)nums1[nums1.length/2]+nums1[nums1.length/2-1]))/2: nums1[nums1.length/2];
    }

    int nums1UpPtr = 0;
    int nums1DownPtr = nums1.length - 1;

    int nums2UpPtr = 0;
    int nums2DownPtr = nums2.length - 1;

    int nums1Ptr = 0;
    int nums2Ptr = 0;

    int tmpNumSize = nums1DownPtr + nums2DownPtr + 2;
    // System.out.println(tmpNumSize);
    double ret = 0.0;
    boolean isfind = false;
    while(tmpNumSize > 3){
      nums1Ptr = (nums1UpPtr + nums1DownPtr) / 2;

      double nums1M;
      int nums1tmpPtr;
      if((nums1UpPtr + nums1DownPtr) == nums1Ptr*2){
        nums1M = nums1[nums1Ptr];
        nums1tmpPtr = nums1Ptr;
      }else{
        nums1M = (double)(nums1[nums1Ptr] + nums1[nums1Ptr+1]) / 2;
        nums1tmpPtr = nums1Ptr + 1;
      }
      nums2Ptr = (nums2UpPtr + nums2DownPtr) / 2;
      double nums2M;
      int nums2tmpPtr;
      if((nums2UpPtr + nums2DownPtr) == nums2Ptr*2){
        nums2M = nums2[nums2Ptr];
        nums2tmpPtr = nums2Ptr;
      }else{
        nums2M = (double)(nums2[nums2Ptr] + nums2[nums2Ptr+1]) / 2;
        nums2tmpPtr = nums2Ptr + 1;
      }
      //
      System.out.println(nums1M);
      System.out.println(nums2M);

      if(nums2Ptr+1 < nums2.length && nums1M >= nums2[nums2Ptr] && nums1M <= nums2[nums2Ptr+1]){
        nums2UpPtr = nums2Ptr;
        nums2DownPtr = nums2Ptr+1;
        if(nums1Ptr+1 < nums1.length && nums2M >= nums1[nums1Ptr] && nums2M <= nums1[nums1Ptr+1]){
          nums1UpPtr = nums1Ptr;
          nums1DownPtr = nums1Ptr+1;
          tmpNumSize  = (nums1DownPtr - nums1UpPtr) + (nums2DownPtr - nums2UpPtr) + 2;
          break;
        }
      }else if(nums1Ptr+1 < nums1.length && nums2M >= nums1[nums1Ptr] && nums2M <= nums1[nums1Ptr+1]){
        nums1UpPtr = nums1Ptr;
        nums1DownPtr = nums1Ptr+1;
      }else if(nums1M > nums2M){
        // System.out.println("in here");
        nums1DownPtr = nums1Ptr;
        nums2UpPtr = nums2tmpPtr;
      }else if(nums1M < nums2M){
        // System.out.println("in here");
        nums1UpPtr = nums1tmpPtr;
        nums2DownPtr = nums2Ptr;
      }else{
        isfind = true;
        ret = nums1M;
        break;
      }


      tmpNumSize  = (nums1DownPtr - nums1UpPtr) + (nums2DownPtr - nums2UpPtr) + 2;
      // System.out.println(tmpNumSize);

      // System.out.println(nums1UpPtr);
      // System.out.println(nums1DownPtr);
      //
      // System.out.println(nums2UpPtr);
      // System.out.println(nums2DownPtr);
    }

    // System.out.println(tmpNumSize);

    if(isfind){

    }else{
      if(tmpNumSize == 2){
        ret = ((double)nums1[nums1UpPtr] + nums2[nums2UpPtr])/2;
      }else if(tmpNumSize == 3){

        if(nums1UpPtr == nums1DownPtr){

          if(nums1[nums1UpPtr] < nums2[nums2UpPtr]){
            System.out.println("in here1");
            ret = nums2[nums2UpPtr];
          }else if(nums1[nums1UpPtr] > nums2[nums2DownPtr]){
            System.out.println("in here1");
            ret = nums2[nums2DownPtr];
          }else{
            System.out.println("in here1");
            ret = nums1[nums1UpPtr];
          }
        }else{
          if(nums2[nums2UpPtr] < nums1[nums2UpPtr]){
            ret = nums1[nums1UpPtr];
          }else if(nums2[nums2UpPtr] > nums1[nums1DownPtr]){
            ret = nums1[nums1DownPtr];
          }else{
            ret = nums2[nums2UpPtr];
          }
        }
      }else if(tmpNumSize == 4){
        if(nums1[nums1UpPtr] > nums2[nums2UpPtr]){
          if(nums1[nums1DownPtr] > nums2[nums2DownPtr]){
            ret = ((double)(nums1[nums1UpPtr] + nums2[nums2DownPtr]))/2;
          }else{
            ret = ((double)(nums1[nums1UpPtr] + nums1[nums1DownPtr]))/2;
          }
        }else{
          if(nums1[nums1DownPtr] > nums2[nums2DownPtr]){
            ret = ((double)(nums2[nums2UpPtr] + nums2[nums2DownPtr]))/2;
          }else{
            ret = ((double)(nums2[nums2UpPtr] + nums1[nums1DownPtr]))/2;
          }
        }
      }
    }
    return ret;
    // return 0.0;
  }
}
