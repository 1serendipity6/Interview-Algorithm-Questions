package interview_questions;

/**
 * @author Leo
 * @data 2024/7/31 上午 07:52
 * 买股票的最佳时机
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。
 * 设计一个算法来计算你所能获取的最大利润。
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 */
public class MaxProfit {
    public static void main(String[] args) {

        int []prices={7,6,4,3,1};
        int i = maxProfit(prices);
        System.out.println(i);
    }

    //實現思路一：
   /*****从左到右遍历数组，同时维护一个最小买入价格 min_price 和计算到目前为止的最大利润 max_profit。
    以下是 O(n) 算法的步骤：
    初始化 min_price 为第一个元素，即第一天的股票价格。
    初始化 max_profit 为 0。
    从第二天开始遍历数组 prices：
    对于每个价格 prices[i]，计算如果今天卖出的利润：profit = prices[i] - min_price。
    如果 profit 大于 max_profit，则更新 max_profit。
    如果 prices[i] 小于 min_price，则更新 min_price。
    返回 max_profit。*/
    public static int maxProfit(int[] prices) {
        // 如果数组为空或者只有一个价格点，无法进行交易，因此返回0
        if (prices == null || prices.length <= 1) {
            return 0;
        }

        // 初始化买入价格为数组的第一个价格点
        int minPrice = prices[0];
        // 初始化最大利润为0
        int maxProfit = 0;

        // 从数组的第二天价格开始遍历（索引1）
        for (int i = 1; i < prices.length; i++) {
            // 计算如果在今天卖出能够得到的利润
            int profit = prices[i] - minPrice;

            // 如果今天卖出的利润大于之前记录的最大利润，则更新最大利润
            if (profit > maxProfit) {
                maxProfit = profit;
            }

            // 如果今天的价格比之前的最小买入价格还要低，更新最小买入价格
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
        }

        // 返回计算出的最大利润
        return maxProfit;
    }

    //代码优化  Math.max  Math.min替换if判断语句
    class Solution {
        // 定义一个公开的方法 maxProfit，它接受一个整型数组 prices 作为参数，并返回一个整型值。
        public int maxProfit(int[] prices) {
            // 初始化结果变量 res 为 0，这将用来累积计算得到的最大利润。
            int res = 0;
            // 初始化买入价格 minBuy 为数组的第一个元素，即假设第一天买入。
            int minBuy = prices[0];

            // 从数组的第二个元素开始遍历（索引从1开始），因为我们已经用第一个元素初始化了 minBuy。
            for(int i = 1; i < prices.length; i++){
                // 计算当前价格与最小买入价格的差值，即如果今天卖出能得到的利润。
                // 使用 Math.max 函数更新 res，使其始终保持最大的利润值。
                res = Math.max(res, prices[i] - minBuy);

                // 更新 minBuy，使其始终保持迄今为止遇到的最小价格。
                // 如果当前价格更低，说明这是一个更好的买入点。
                minBuy = Math.min(minBuy, prices[i]);
            }

            // 遍历完成后，返回累计的最大利润。
            return res;
        }
    }

}
