package interview_questions;

/**
 * @author Leo
 * @data 2024/7/26 上午 08:50
 * 刪除有序數組中的重複項
 *
 */

/**
 * 给你一个 非严格递增排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，
 * 返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。然后返回 nums 中唯一元素的个数。
 * 考虑 nums 的唯一元素的数量为 k ，你需要做以下事情确保你的题解可以被通过：
 * 更改数组 nums ，使 nums 的前 k 个元素包含唯一元素，
 * 并按照它们最初在 nums 中出现的顺序排列。nums 的其余元素与 nums 的大小不重要。
 * 返回 k
 **/

//思路：
  //  初始化两个指针：i 从索引 0 开始，j 从索引 1 开始。i 用于记录新数组的长度，j 用于遍历数组。
    //遍历数组：从索引 1 开始遍历数组，使用 j 指针。
     //检查重复：对于每个 j 索引的元素，检查它是否与 i 索引的元素相同。如果不同，则将该元素复制到 i+1 的位置，并递增 i。
// 保持相对顺序：由于数组是非严格递增的，如果当前元素不等于前一个元素，就可以安全地将其移动到 i+1 的位置。
//返回新长度：遍历完成后，i 的值即为删除重复元素后数组的新长度。
public class removeDuplicaties {
    public static void main(String[] args) {
int []nums={1,1,2,2,4,5};
        int i = removeDuplicates(nums);
        System.out.println(i);
    }
   public static int removeDuplicates(int[] nums){
        //k用于记录nums数组的唯一元素的个数
        int k=0;
        //用指针进行游走遍历，指针k所指元素用于进行比对
        //如果二者所指元素值不等，则两个值交换
        for (int i = 0; i <nums.length ; i++) {
            if(nums[k] != nums[i]){
                //指针先前移后交换
                nums[++k]=nums[i];
            }
        }
        //返回数组长度
        return k+1;
    }
}
