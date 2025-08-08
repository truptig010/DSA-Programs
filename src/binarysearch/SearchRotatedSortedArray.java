package binarysearch;

public class SearchRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums={4, 5, 6, 7, 0,1,2};
        int target=0;
        int low=0,high=nums.length-1;
        System.out.println(SearchInRotatedSortedArray(nums,low,high,target));
    }
    public static int SearchInRotatedSortedArray(int[] nums,int low,int high,int target){


        if(low>high) return -1;// Base case: if range is invalid, target not found

        int mid=low+(high-low)/2;

        if(nums[mid]==target)  // Case 1: Found the target
            return mid;

        // Case 2: Left half is sorted (nums[low] < nums[midIndex])
        if(nums[low]<nums[mid]){
            // If target lies in the sorted left half ,otherwise ,search the right half
            if(target>=nums[low] && target<nums[mid]){
                return SearchInRotatedSortedArray(nums,low,mid-1,target);
            }
            return SearchInRotatedSortedArray(nums,mid+1,high,target);
        }
        // Case 3: Right half is sorted (nums[midIndex] <= nums[high])
        if(nums[mid]<=nums[high])
        {
            // If target lies in the sorted right half, otherwise ,search the left half
            if(target>nums[mid] && target<nums[high])
                return SearchInRotatedSortedArray(nums,mid+1,high,target);
            return SearchInRotatedSortedArray(nums,low,mid-1,target);
        }
        return -1;
    }
}
