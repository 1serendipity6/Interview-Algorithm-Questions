package interview_questions.array_string_operation;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author Leo
 * @data 2024/8/5 上午 08:27
 *
 * 给你一个整数数组 citations ，其中 citations[i] 表示研究者的第 i 篇论文被引用的次数。计算并返回该研究者的 h 指数。
 *
 * 根据维基百科上 h 指数的定义：h 代表“高引用次数” ，一名科研人员的 h 指数 是指他（她）至少发表了 h 篇论文，
 * 并且 至少 有 h 篇论文被引用次数大于等于 h 。如果 h 有多种可能的值，h 指数 是其中最大的那个。
 */
public class HIndex {
    public static void main(String[] args) {

        int[] citation = {10, 8, 5, 4, 3};
        int[] citation1 = {1, 3, 1};
        int i = hIndex(citation);
        int i1 = hIndex(citation1);
        System.out.println("h指数为： " + i);
        System.out.println(i1);
    }
    /**要计算一个研究者的 h 指数，你可以按照以下步骤进行：
     1.排序：将论文引用次数从高到低进行排序。
     2.计算 h 指数：从排序后的数组的最后一个元素（即引用次数最高的论文）开始，向前遍历数组：
     (1)维护一个计数器 h，初始值为 1。
     (2)对于数组中的每个元素 citations[i]：
     如果 citations[i] 大于或等于 h，则 h 加 1。
     如果 citations[i] 小于 h，则停止增加 h，因为此时已经不能满足 h 指数的定义（即每篇论文至少被引用 h 次）。
     (3)返回 h 指数：返回计算出的 h 值。*/
//    public static int hIndex(int[] citations) {
//        //数组从高到低进行排序  Arrays.sort
//        Arrays.sort(citations);
//        int h=1;  //定义h指数
//        //对数组进行遍历，从后往前，如果数组元素大于等于h，则为h指数，h++
//        for (int i = citations.length-1; i >=0 ; i--) {
//            if (citations[i] >= h){
//                h++;
//            }else {
//                break;
//            }
//        }
//        return h-1;//因最后一次符合条件的判断多加了一次，因此需要减一
//    }

    /**
     * 使用一个计数数组来统计每个引用次数的论文数量，然后通过反向迭代来确定 h 指数。
     */
    public static int hIndex(int[] citations) {
        int n = citations.length; // 1. 获取输入数组 citations 的长度。
        int[] count = new int[n + 1]; // 2. 创建一个长度为 n + 1 的数组 count，用于统计每个引用次数的论文数量。数组索引从 0 到 n，其中索引 i 表示引用次数为 (i + 1) 的论文数量。

        for (int num : citations) { // 3. 遍历数组 citations 中的每个引用次数 num。
            count[Math.min(num, n)]++; // 4. 对于每个引用次数 num，如果 num 大于 n，则它将与 n 一样被视为 n。然后，对应索引的 count 数值增加 1。
        }

        int total = 0; // 5. 初始化总论文数量计数器 total 为 0，用于计算至少被引用特定次数的论文总数。

        for (int i = n; ; i--) { // 6. 开始一个无限循环，从 n 开始递减至 0。循环条件为空，表示无限迭代，但内部的逻辑将决定何时退出循环。
            total += count[i]; // 7. 将当前索引 i 对应的引用次数的论文数量加到 total 上。这表示统计了至少被引用 i 次的论文数量。
            if (total >= i) { // 8. 如果 total 大于等于当前的索引 i，根据 h 指数的定义，我们找到了满足条件的最小 h 值。
                return i; // 9. 返回索引 i 作为 h 指数的值。此时，我们知道至少有 i 篇论文被引用了至少 i 次。
            }
        }
    }
}
    /**代码逻辑的核心在于：

     使用 count 数组来统计每个引用次数的论文数量，数组索引 i 表示引用次数为 (i + 1) 的论文数量。
     通过反向迭代 count 数组，累加至少被引用特定次数的论文总数。
     当累加的论文总数 total 大于等于当前的引用次数 i 时，满足 h 指数的定义，返回当前的 i 作为 h 指数。
     这种方法的时间复杂度是 O(n)，其中 n 是数组 citations 的长度，因为它只需要对数组进行两次遍历：
     一次用于统计引用次数，一次用于计算 h 指数。这种方法避免了对原始数组进行排序，因此在某些情况下可能更高效。**/
