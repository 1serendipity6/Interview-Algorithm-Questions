package interview_questions.array_string_operation;

/**
 * @author Leo
 * @data 2024/7/30 上午 08:09
 * 转轮数组
 *
 * 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数
 */

/*思路：原地旋转
首先，反转整个数组。
然后，反转数组的前 k 个元素。
最后，反转数组的剩余元素。*/
public class Rotate {
    public static void main(String[] args) {

        int []nums={-1,-100,3,99};
        int[] rotate = rotate(nums, 2);
        for (int i = 0; i < rotate.length; i++) {
            System.out.print(rotate[i]+" ");

        }

    }

    public static int[]  rotate(int[] nums, int k){
       int n=nums.length;  //记录数组长度
         k= k % n; //如果旋转度大于数组长度，取余数以优化
         //考虑边界情况
        if(n==0 || k==0)
        {
            return null;     //数组为空或旋转度为0，则无需旋转
        }else {
            //反转整个数组
            reverse(nums, 0, n - 1);
            //反转数组前k个元素
            reverse(nums, 0, k - 1);
            //反转后n-k个元素
            reverse(nums, k, n - 1);
            return nums;
        }
    }
    //本函数用于逆转数组元素
    public static void reverse(int[] nums, int start, int end){
        //临时变量用于作为媒介交换
        int temp=0;
        //交换前提为start<end
        //利用循环完成整个数组旋转
        while(start<end){
            temp=nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            //start前移，end后移，继续交换
            start++;
            end--;
        }
    }
}
