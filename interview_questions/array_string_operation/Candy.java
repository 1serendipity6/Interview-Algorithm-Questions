package interview_questions.array_string_operation;

import interview_questions.MaxProfit;

/**
 * @author Leo
 * @data 2024/8/9 上午 08:52
 * 糖果
 * n 个孩子站成一排。给你一个整数数组 ratings 表示每个孩子的评分。
 * 你需要按照以下要求，给这些孩子分发糖果：
 * 每个孩子至少分配到 1 个糖果。
 * 相邻两个孩子评分更高的孩子会获得更多的糖果。
 * 请你给每个孩子分发糖果，计算并返回需要准备的 最少糖果数目 。
 */


public class Candy {
    public static int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) {
            return 0;
        }
        int n = ratings.length;
        int[] leftToRight = new int[n]; // 从左到右遍历得到的糖果数
        int[] rightToLeft = new int[n]; // 从右到左遍历得到的糖果数

        // 初始化数组，每个孩子至少得到1颗糖果
        for (int i = 0; i < n; i++) {
            leftToRight[i] = 1;
            rightToLeft[i] = 1;
        }

        // 从左到右遍历，为评分更高的孩子分配更多的糖果
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                leftToRight[i] = leftToRight[i - 1] + 1;
            }
        }

        // 从右到左遍历，为评分更高的孩子分配更多的糖果
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                rightToLeft[i] = rightToLeft[i + 1] + 1;
            }
        }

        // 计算并返回总糖果数
        int totalCandies = 0;
        for (int i = 0; i < n; i++) {
            // 选择左右两个方向中糖果数的最大值
            totalCandies += Math.max(leftToRight[i], rightToLeft[i]);
        }

        return totalCandies;
    }
    /**这段代码定义了一个名为Solution的类，其中包含一个名为candy的方法，该方法接受一个整数数组ratings作为参数，并返回一个整数，表示最少需要准备的糖果数目。代码逻辑如下：

     首先检查输入数组是否为空或null。
     初始化两个数组leftToRight和rightToLeft，分别用于记录从左到右和从右到左遍历时每个孩子得到的糖果数。
     两次遍历ratings数组，第一次从左到右，第二次从右到左，确保评分更高的孩子得到更多的糖果。
     对于每个位置，比较两个方向上得到的糖果数，并选择两者中的最大值累加到总糖果数totalCandies。
     最后返回totalCandies作为结果。*/

    public static void main(String[] args) {
     int []ratings1={1,6,10,8,7,3,2};
     int []ratings2={1,2,3};
        int candy = candy(ratings1);
        System.out.println("ratings1評分組獲得的糖果為： "+candy);
        int candy1 = candy(ratings2);
        System.out.println("ratings2評分組獲得的糖果為：" +candy1);

    }
}
