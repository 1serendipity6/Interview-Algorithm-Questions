package interview_questions.array_string_operation;

/**
 * @author Leo
 * @data 2024/8/1 上午 07:53
 * 买股票的最佳时机2
 * 给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。
 * 在每一天，你可以决定是否购买和/或出售股票。
 * 你在任何时候 最多 只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
 * 返回 你能获得的 最大 利润 。
 */
public class MaxProfit2 {
    public static void main(String[] args) {

        int []prices={7,1,5,3,6,4};
        int i = maxProfit(prices);
        System.out.println(i);
    }
    public static int maxProfit(int[] prices) {

        int minprice=prices[0]; //记录最小价格
        int maxprofit=0;//记录利润值

        for (int i = 1; i < prices.length ; i++) {
            //计算利润
            int profit=prices[i]-minprice;
            //是否为正利润，为正利润则更新
            if (profit>0){
                maxprofit += profit;
//                指针前移
                minprice=prices[i];
            }
            //更新最小价格
            if(minprice>prices[i]){
                minprice=prices[i];
            }
        }
        return maxprofit;
    }
    //實現方式2：貪心算法
    /*贪心算法的核心思想是，如果今天的价格比昨天高，就卖出昨天买入的股票。
1.初始化 maxProfit 为 0。
2.遍历数组 prices，对于每一天 i（从1到数组末尾）：
   如果 prices[i] > prices[i - 1]，则表示今天的价格比昨天高，
   可以卖出昨天买入的股票，获得利润 prices[i] - prices[i - 1]，
   并将这个利润加到 maxProfit 上。*/
    public int maxProfit2(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            // 如果今天的价格比昨天高，就卖出股票
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        return maxProfit;
    }
}
