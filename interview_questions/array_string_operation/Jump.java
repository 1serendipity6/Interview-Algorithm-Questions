package interview_questions.array_string_operation;

/**
 * @author Leo
 * @data 2024/8/3 下午 03:31
 * 跳跃游戏 ||
 * 给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。
 * 每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。
 * 换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:
 * 0 <= j <= nums[i]
 * i + j < n
 * 返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。
 */

/**这个问题是一个典型的贪心算法问题，通常被称为“跳跃游戏II”或“青蛙过河”问题。要解决这个问题，你可以从左到右遍历数组，并使用一个变量来跟踪当前能够达到的最远位置。

 以下是解决这个问题的算法步骤：

 1.初始化两个变量，maxReach 表示当前可以达到的最远下标，初始值为 0，因为最开始你位于第一个下标。
 2.初始化另一个变量 end 表示当前考虑的下标，初始值也为 0。
 3.初始化一个变量 step 来记录到达终点所需的最小跳跃次数，初始值为 0。
 4.遍历数组 nums 从下标 0 开始：
 (1)在每一步，更新 maxReach 为 max(maxReach, end + nums[end])，即当前最远位置与当前下标加上可以跳跃的最大长度中的较大值。
 (2)如果 maxReach 大于或等于 n - 1（数组的最后一个下标），则说明可以到达终点，此时增加 step 并结束循环。
 (3)如果没有到达终点，将 end 向前移动到 maxReach，表示下一次跳跃的起始点是当前能够达到的最远位置。
 5.在循环结束后，返回 step 作为结果。**/
public class Jump {
    public static void main(String[] args) {

        int [] nums={2,3,1,1,4};
        int jump = jump(nums);
        System.out.println("最小跳跃次数为："+jump);
    }
    public static int jump(int[] nums) {
        int maxReach = 0; // 当前可以到达的最远下标
        int end = 0;      // 当前考虑的下标
        int step = 0;     // 到达终点所需的最小跳跃次数

        for (int i = 0; i < nums.length - 1; i++) {
            maxReach = Math.max(maxReach, i + nums[i]); // 更新最远下标

            if (maxReach >= nums.length - 1) { // 如果可以到达终点
                step++; // 增加跳跃次数
                break;   // 结束循环
            }

            if (i == end) { // 如果当前下标是之前跳跃的最远下标
                step++; // 增加跳跃次数
                end = maxReach; // 更新下一次跳跃的起始点
            }
        }

        return step;
    }
}
