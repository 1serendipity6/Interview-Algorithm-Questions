package interview_questions.array_string_operation;

/**
 * @author Leo
 * @data 2024/8/2 上午 07:55
 * 跳跃游戏
 */
/*给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
数组中的每个元素代表你在该位置可以跳跃的最大长度。
判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。*/

    /**这个问题是一个经典的贪心算法问题，通常被称为“跳跃游戏”。要解决这个问题，
你可以从左到右遍历数组，使用一个变量来跟踪当前可以到达的最远位置。在每一步中，更新这个最远位置，
如果当前位置超过了之前记录的最远位置，说明无法到达数组的末尾。
以下是解决这个问题的算法步骤：
初始化两个变量，maxReach 表示当前可以到达的最远下标，初始值为 0，因为最开始你位于第一个下标。
初始化另一个变量 i 表示当前考虑的下标，初始值也为 0。
遍历数组 nums 从第一个元素开始（下标为 0）：
如果 i 小于或等于 maxReach，说明当前下标仍然在可到达范围内。
更新 maxReach 为 max(maxReach, i + nums[i])，
即当前最远位置与当前下标加上可以跳跃的最大长度中的较大值。
如果 maxRearch 能够到达或超过数组的最后一个下标（nums.length - 1），则返回 true，否则在循环结束后返回 false。*/
public class CanJump {
    public static void main(String[] args) {
 int[] nums={3,2,1,0,4};
        boolean jump = canJump(nums);
        System.out.println(jump);
    }
public static boolean canJump(int[] nums){
        int maxReach=0;  //记录当前下标可以到达的最远下标
    for (int i = 0; i < nums.length; i++) {
        if (i <= maxReach){//如果当前下标在可到达范围
            maxReach=Math.max(maxReach,i+nums[i]);// 更新最远下标
        }
    }
    return maxReach >= nums.length-1;  //如果最远距离能到达数组末尾，则返回true，否则返回false
}
}
