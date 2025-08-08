package binarysearch;

public class SearchFirstAndLastIndex {
    public static void main(String[] args) {
        int []nums={5,7,7,8,8,8,8,10};
        searchRange(nums,8);
    }

    public static int[] searchRange(int []nums,int target){

        int[] result={-1,-1};
        int low=0,high=nums.length-1;
        result[0]=firstIndexOfAnElement(nums,low,high,target);
        result[1]=lastIndexOfAnElement(nums,low,high,target);
        System.out.println("FirstIndex :"+result[0] +" LastIndex : "+result[1]);
        return result;
    }
    public static int firstIndexOfAnElement(int[] nums,int low,int high, int target){

        int leftIndex=-1;
        while(low<=high)
        {
            int mid= low+(high-low)/2;
            if(nums[mid]==target){
                leftIndex=mid;   // Possible first occurrence found
                high=mid-1;     // Keep searching LEFT side for earlier occurrence
            }
            else if(nums[mid]<target)
                low=mid+1;    // Search in the RIGHT half
            else
                high=mid-1;  // Search in the LEFT half

        }
        return leftIndex;
    }
    public static int lastIndexOfAnElement(int[] nums,int low,int high, int target){
        int rightIndex=-1;
        while(low<=high)
        {
            int mid= low+(high-low)/2;
            if(nums[mid]==target){
                rightIndex = mid;  // Possible last occurrence found
                low = mid + 1;     // Keep searching RIGHT side for later occurrence
            }
            else if(nums[mid]<target)
                low=mid+1;
            else
                high=mid-1;

        }
        return rightIndex;
    }
}
