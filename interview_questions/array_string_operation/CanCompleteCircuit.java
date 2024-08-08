package interview_questions.array_string_operation;

/**
 * @author Leo
 * @data 2024/8/8 上午 11:42
 * 加油站
 * 在一条环路上有 n 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
 *
 * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个
 * 加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，
 * 开始时油箱为空。
 *
 * 给定两个整数数组 gas 和 cost ，如果你可以按顺序绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1 。如果存在解，则 保证 它是 唯一 的。
 */
public class CanCompleteCircuit {
    public static void main(String[] args) {

        int []gas={1,2,3,4,5};
        int []cost={3,4,5,1,2};
        int i = canCompleteCircuit(gas, cost);
        System.out.println(i);

    }
    /**这个问题是一个典型的贪心算法问题，
     * 要求找出一个能够使汽车绕环路一周的起始加油站。
     * 解决这个问题的关键在于如何有效地判断是否存在这样的加油站。**/
    // 定义一个方法，用于判断是否存在一个加油站可以作为起点，使得汽车能够绕环路一周
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        // 初始化总油量和当前油量变量
        int totalTanks = 0, currTanks = 0;
        // 初始化起始加油站编号和当前加油站编号
        int startStation = 0, currStation = 0;
        // 获取加油站数量
        int n = gas.length;

        // 遍历所有加油站
        for (int i = 0; i < n; i++) {
            // 更新总油量，即所有加油站油量与消耗的差值
            totalTanks += gas[i] - cost[i];
            // 更新当前油量，即从起始站到当前站的油量累计
            currTanks += gas[i] - cost[i];

            // 如果当前油量不足以到达下一个加油站，则更新起始加油站编号
            // 并将当前油量重置为0，以便从新的起始站重新开始计算
            if (currTanks < 0) {
                currStation = i + 1;
                currTanks = 0;
                startStation = currStation;
            }
        }

        // 如果总油量大于等于0，说明存在至少一个加油站可以作为起始点
        // 返回这个加油站的编号，否则返回-1表示无法完成环路
        return totalTanks >= 0 ? startStation : -1;
    }
}
/**这段代码逻辑：
 *
 * 1.初始化totalTanks来记录整个环路中油量总和，currTanks来记录当前油箱的油量，
 * startStation来记录可能的起始加油站编号，currStation来记录当前加油站编号。

 2.遍历数组，计算每个加油站的油量差（gas[i] - cost[i]），并更新totalTanks和currTanks。

 3.如果currTanks小于0，说明从当前加油站出发无法继续前进，因此重置currTanks为0，
 并更新startStation为下一个可能的起始加油站编号。

4. 遍历结束后，如果totalTanks大于等于0，说明存在至少一个加油站可以作为起始点，
 返回startStation；否则返回-1。*/
