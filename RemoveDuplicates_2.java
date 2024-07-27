package interview_questions;

/**
 * @author Leo
 * @data 2024/7/27 上午 09:50
 * 刪除有序數組中的重複元素 2-進階版
 */

/**给你一个有序数组 nums ，请你 原地 删除重复出现的元素，
 * 使得出现次数超过两次的元素只出现两次 ，返回删除后数组的新长度。

 不要使用额外的数组空间，
 你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。*/
public class RemoveDuplicates_2 {
    public static void main(String[] args) {
    int[]nums={0,0,1,1,1,1,2,3,3};
        int i = removeDuplicates(nums);
        System.out.println(i);
    }
    //实现思路：
    /**我们可以使用双指针技术来解决这个问题，同时满足原地修改数组和O(1)额外空间的要求。
    1. 检查数组长度：如果数组长度小于等于2，直接返回数组的长度，因为所有元素出现次数都不超过两次。
    2. 初始化指针：使用两个指针 i 和 j。i 用于遍历数组，j 用于记录新数组的长度。
     3.处理前两个元素：将前两个不同的元素复制到 j 的位置，因为有序数组至少有两个不同的元素可以保留。
    4. 遍历数组：从索引 2 开始遍历数组 nums。
     5.更新新数组：
     如果当前元素 nums[j] 与 nums[i] 相同，说明当前元素出现次数超过两次，需要删除多余的元素。
     如果当前元素 nums[j] 与 nums[i] 不同，更新 nums[j] 为 nums[i] 并递增 j。
     返回新长度：遍历完成后，j 的值即为删除重复元素后数组的新长度。*/

    public static int removeDuplicates(int[] nums){
        if (nums == null || nums.length <= 2) {
            return nums.length;
        }
        int j = 2; // 新数组的长度，初始化为2，保留前两个元素
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[j - 2]) {
                nums[j++] = nums[i]; // 复制新元素到j的位置
            }
        }
        return j; // 返回新数组的长度
    }
}
