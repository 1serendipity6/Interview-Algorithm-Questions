package interview_questions;

/**
 * @author Leo
 * @data 2024/7/24 上午 10:30
 * 合并有序数组
 */

/**
 * 思路：首先初始化两个指针index1和index2，
 * 分别指向nums1和nums2的最后一个元素。然后，
 * 使用一个填充指针fillIndex从后向前遍历两个数组，
 * 将较大的元素复制到nums1的末尾。如果nums2中的元素较小，
 * 那么nums1中的元素将被复制到nums1的末尾，反之亦然。
 * 当其中一个数组的所有元素都被复制后，
 * 将另一个数组剩余的元素复制到nums1的前面。由于nums1的前面部分已经有序，
 * 所以不需要再进行排序。
 *
 * 请注意，这个方法不返回任何值，而是直接修改输入数组nums1，使其包含合并后的元素。
 **/


public class MergeOrderArray {
    public static void main(String[] args) {
        //1.定义两个递增整数数组
        int[] num1 = {1, 2, 3, 0, 0, 0};
        int[] num2 = {2, 5, 6};
        int m = 3, n = 3;
        int[] merge = merge(num1, m, num2, n);
        for (int i = 0; i < merge.length; i++) {
            System.out.print(merge[i] + " ");
        }


    }

    public static int[] merge(int[] nums1, int m, int[] nums2, int n) {
        // 初始化两个指针，分别指向nums1和nums2的最后一个元素
        int index1 = m - 1;
        int index2 = n - 1;

        // 初始化填充指针，指向nums1的末尾（包括末尾的0）
        int fillIndex = m + n - 1;

        // 从后向前合并，保持非递减顺序
        while (index1 >= 0 && index2 >= 0) {
            if (nums1[index1] > nums2[index2]) {
                nums1[fillIndex--] = nums1[index1--];
            } else {
                nums1[fillIndex--] = nums2[index2--];
            }
        }

        // 如果nums2中还有元素，将它们填充到nums1的前面
        while (index2 >= 0) {
            nums1[fillIndex--] = nums2[index2--];
        }

        // nums1中剩余的元素已经在正确的位置上，不需要操作
        return nums1;
    }
}

