package interview_questions.array_string_operation;

/**
 * @author Leo
 * @data 2024/7/29 上午 08:15
 * 数组/字符串操作之多數元素
 */
/**给定一个大小为n的数组nums，返回其中的多数元素。多数元素是指在数组中出现次数大于 n/2 的元素。

 你可以假设数组是非空的，并且给定的数组总是存在多数元素。*/

/*这个问题是经典的"多数投票问题"（Boy Scout Rule），可以使用摩尔投票算法（Moore's Voting Algorithm）来解决。
这个算法的核心思想是使用两个变量，一个记录当前的候选多数元素，另一个记录该元素的票数。
遍历数组，对于每个元素，如果它与当前候选元素相同，则增加票数；
如果不同，则减少票数。如果在减少票数后票数变为0，则将当前元素作为新的候选多数元素。*/
public class MajorityElement {
    public static void main(String[] args) {
    int []nums={3,1,3,2,2,4,2};
        int i = majorityElement(nums);
        System.out.println(i);
    }
    public static int majorityElement(int[] nums){
        int candidate = nums[0]; // 当前候选多数元素
        int count = 1; // 当前候选元素的票数

        // 摩尔投票算法的主体
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                candidate = nums[i]; // 重置候选元素
                count = 1; // 重置票数
            } else if (nums[i] == candidate) {
                count++; // 如果当前元素与候选元素相同，增加票数
            } else {
                count--; // 如果当前元素与候选元素不同，减少票数
            }
         }
        return candidate;
    }
    //补充：如果给定数组不一定有多数元素呢？
    public int majorityElement1(int[] nums) {
        int candidate = nums[0]; // 当前候选多数元素
        int count = 1; // 当前候选元素的票数

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == candidate) {
                count++; // 如果当前元素与候选元素相同，增加票数
            } else {
                if (count == 0) {
                    candidate = nums[i]; // 票数归零，更新候选元素
                } else {
                    count--; // 如果当前元素与候选元素不同，减少票数
                }
            }
        }

        // 验证候选元素是否确实是多数元素
        int result = 0;
        int validCount = 0;
        for (int num : nums) {
            if (num == candidate) {
                validCount++;
            }
        }

        // 如果候选元素的票数大于数组长度的一半，则返回该元素
        if (validCount > nums.length / 2) {
            return candidate;
        }

        // 如果没有找到多数元素（尽管题目保证一定存在），则返回0
        return 0;
    }
    //这个方法的时间复杂度是 O(n)，空间复杂度是 O(1)，因为它只需要常数级别的额外空间。
}
