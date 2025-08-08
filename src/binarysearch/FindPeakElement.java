package binarysearch;

public class FindPeakElement {

    public static void main(String[] args) {
        int [] nums={1,2,1,8,5,6,4};
        int low=0,high=nums.length-1;
        System.out.println(findIndexOfPeakElement(nums,low,high));
    }
    public static int findIndexOfPeakElement(int [] nums,int low,int high){
        // Find the middle index without risking integer overflow
        int mid=low+(high-low)/2;

        // Base case: if the search range has narrowed to a single element,
        // that element is a peak.
        if(low==high)
            return low;

        // If the left neighbor is greater than the current element,
        // the peak must be in the left half of the array.
        if(mid>0 && nums[mid-1]>nums[mid])
            return findIndexOfPeakElement(nums,low,mid+1);

        // If the right neighbor is greater than the current element,
        // the peak must be in the right half of the array.
        else if(mid<nums.length-1 && nums[mid+1]>nums[mid])
            return findIndexOfPeakElement(nums,mid+1,high);

        // Otherwise, the current element is greater than or equal to both neighbors,
        // so it's a peak.
        else
            return mid;

    }
}
