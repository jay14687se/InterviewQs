package algorithms;

public class Remove_Duplicates_from_Sorted_Array {
    public static void main(String[] args){
        int[] nums = {1,2};
        int len = verify(nums);
//        System.out.println(len);
        for(int i = 0; i < len;i++){
            System.out.println(nums[i]);
        }
    }

    public static int verify(int[] nums){
        if(nums.length == 0 || nums == null) return 0;
        if(nums.length == 1) return 1;
        if(nums[nums.length - 1] == nums[0]) return 1;
        int len = 0;
        for(int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                len++;
                for (int j = i; j < nums.length - 1; j++) {
                    nums[j] = nums[j + 1];
                }
            }
            if ((nums[i] == nums[i - 1]) && (nums[nums.length - 1] != nums[i])) {
                i--;
            } else if ((nums[i] != nums[i - 1]) && (nums[nums.length - 1] == nums[i])) {
                len = i;
                break;
            }
        }
        return len+1;
    }

    /*
    Two pointer method
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}
