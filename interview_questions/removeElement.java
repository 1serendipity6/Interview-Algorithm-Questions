package interview_questions;

/**
 * @author Leo
 * @data 2024/7/25 上午 10:16
 *
 * 移除元素
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素。
 * 元素的顺序可能发生改变。然后返回 nums 中与 val 不同的元素的数量。
 * 假设 nums 中不等于 val 的元素数量为 k，要通过此题，您需要执行以下操作：
 *
 * 更改 nums 数组，使 nums 的前 k 个元素包含不等于 val 的元素。nums 的其余元素和 nums 的大小并不重要。
 * 返回 k。
 */
public class removeElement {
    public static void main(String[] args) {

        int[]nums={1,2,4,4,5,7,0};
        int val=4;
        int i = removeElement(nums, val);
        System.out.println(i);

    }
//思路：1.初始化两个指针 i 和 j，其中 i 用于遍历数组，j 用于记录不等于 val 的元素的位置。
//2.遍历数组 nums，当遇到不等于 val 的元素时，将其复制到索引 j 的位置，并递增 j。
//3.完成遍历后，j 将指向最后一个不等于 val 的元素之后的位置。
//4.将 j 之后的数组元素置为某个值（如果需要的话），以确保数组的其余部分不包含不等于 val 的元素。
//5.返回 j，即不等于 val 的元素的数量。
    public static int removeElement(int[] nums, int val){
        //k用于记录nums数组中不等于val的元素个数
        int k=0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != val){
                nums[k]=nums[i];//赋值不等于val的元素
                k++;//递增k
            }
        }

        return k;
    }
}
