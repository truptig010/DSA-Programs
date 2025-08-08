package binarysearch;


public class BinarySearchSortedArray {

    public static void main(String[] args) {
        int [] nums={1,5,6,7,9,10,11};
        int low=0,high=nums.length-1;
        int target=9;
        System.out.println(iterativeBinarySearch(nums,low,high,target));
        System.out.println(recursiveBinarySearch(nums,low,high,target));
    }

    public static int iterativeBinarySearch(int []nums,int low,int high,int target){

        while(low<=high) {

            // Find the middle index without risking integer overflow
            int mid=low+(high-low)/2;

            // If the middle element is the target, return its index
            if (nums[mid] == target)
                return mid;

            // If target is greater, ignore left half
            if(nums[mid]<target)
                low=mid+1;
            // If target is smaller, ignore right half
            else
                high=mid-1;
        }
        // Target not found
        return -1;
    }

    public static int recursiveBinarySearch(int [] nums,int low,int high,int target){
        int mid=low+ (high-low)/2;

        if(nums[mid]== target)
            return mid;
        if(nums[mid]<target)
            return recursiveBinarySearch(nums,mid+1,high,target);
        return recursiveBinarySearch(nums,low,mid-1,target);

    }
}
