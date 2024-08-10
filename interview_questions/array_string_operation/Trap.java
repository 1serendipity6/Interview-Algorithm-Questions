package interview_questions.array_string_operation;

/**
 * @author Leo
 * @data 2024/8/10 下午 04:59
 */
public class Trap {
    //接雨水问题
    /**
     给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
     示例 1：
     输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
     输出：6
     解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
     示例 2：

     输入：height = [4,2,0,3,2,5]
     输出：9
     */
    public class trap {
        public static int trap(int[] height) {
            if (height == null || height.length == 0) {
                return 0;
            }

            int n = height.length;
            int left = 0, right = n - 1;
            int leftMax = 0, rightMax = 0;
            int ans = 0;

            while (left < right) {
                if (height[left] < height[right]) {
                    // 当左边的柱子高度小于右边的柱子高度
                    if (height[left] >= leftMax) {
                        // 更新左边的柱子能接的雨水量
                        leftMax = height[left];
                    } else {
                        // 计算当前柱子能接的雨水量，并累加到总雨水量中
                        ans += leftMax - height[left];
                    }
                    left++;
                } else {
                    // 右边的柱子高度不小于左边的柱子高度
                    if (height[right] >= rightMax) {
                        // 更新右边的柱子能接的雨水量
                        rightMax = height[right];
                    } else {
                        // 计算当前柱子能接的雨水量，并累加到总雨水量中
                        ans += rightMax - height[right];
                    }
                    right--;
                }
            }

            return ans;
        }


        public static void main(String[] args) {

            int[] height1 = {0,1,0,2,1,0,1,3,2,1,2,1};
            int trap = trap(height1);
            System.out.println(trap);// 输出：6

            int[] height2 = {4,2,0,3,2,5};
            int trap1 = trap(height2);
            System.out.println(trap1);// 输出：9
        }
    }

/**
 接雨水问题的实现思路主要基于以下观察：
 1.局部最大值：一个柱子能接雨水的量取决于它左右两边最高的柱子高度中的较小值（因为雨水只能在两者较低的一侧积累）。
 2.双指针：使用两个指针 left 和 right 分别从数组的两端向中间遍历。这样可以同时考虑左右两边的柱子高度。
 3.维护最大高度：在遍历过程中，维护两个变量 leftMax 和 rightMax 来记录从左边和右边开始遍历到目前为止遇到的最高的柱子高度。
 4.计算雨水量：当遍历到的柱子高度小于 leftMax 或 rightMax 时，可以计算出当前柱子能接的雨水量，即 min(leftMax, rightMax) - height[i]。如果柱子高度大于等于记录的最大高度，则更新 leftMax 或 rightMax。
 5.累加雨水量：将每次计算出的雨水量累加到总雨水量 ans 中。
 6.边界条件：如果输入数组为空或长度为0，则直接返回0，因为没有柱子可以接雨水。

 具体步骤如下：
 1.初始化两个指针 left 和 right 分别指向数组的开始和结束位置，以及两个变量 leftMax 和 rightMax 为0。
 2.使用一个循环，当 left 小于 right 时继续执行：
 (1)如果 height[left] < height[right]，则移动 left 指针，并更新 leftMax：
 (2)如果当前柱子高度大于等于 leftMax，则更新 leftMax。
 (3)否则，计算当前柱子能接的雨水量，并累加到 ans。
 (4)否则，移动 right 指针，并更新 rightMax：
 (5)类似地更新 rightMax 和累加雨水量。
 3.当 left 和 right 相遇时，遍历结束，返回计算出的总雨水量 ans。

 这种双指针的方法时间复杂度为 O(n)，其中 n 是数组 height 的长度，因为每个元素只被遍历一次。空间复杂度为 O(1)，因为只需要常数级别的额外空间。
 */
}
