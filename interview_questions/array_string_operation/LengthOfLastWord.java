package interview_questions.array_string_operation;

import sun.security.util.Length;

/**
 * @author Leo
 * @data 2024/8/16 上午 09:41
 * @description: 最後一個單詞的長度
 * 给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。
 * 返回字符串中 最后一个 单词的长度。
 * 单词 是指仅由字母组成、不包含任何空格字符的最大
 * 子字符串
 * 。
 */
public class LengthOfLastWord {
    public static void main(String[] args) {

        String s="Hello World";
        int i = lengthOfLastWord(s);
        System.out.println("最后一个单词的长度为："+i);
    }
//    思路1：将字符串转成全为单词的字符串列表，然后直接返回最后一个单词的长度即可
//     将所给字符串，利用正则表达式进行匹配筛选，将空格去掉后
//    得到一个全为单词的字符串列表，然后返回最后一个单词的长度即可
//    public static int lengthOfLastWord(String s) {
//        //正则表达式匹配去掉空格，得到单词列表
//        String[] words = s.split("\\s+");
//        //判断列表是否为空
//        if (words.length == 0) {
//            return 0;
//        }
//        //获取最后一个单词的长度
//        return words[words.length - 1].length();
//        //等价于  int lastWordIndex=words.length-1;
//        //        int lastWordLength=words[lastWordIndex].length();
//    }

    //思路2：通过遍历，直接计算最后一个单词的长度
//    这里我们需要做一些处理，首先去掉字符串前后的字符串（确保前后没有空格），然后从后往前开始遍历，记录当前索引，遇到空格时，遍历使用break关键字跳出循环，说明最后一个单词已经遍历完，
//     返回此时的指针索引，字符串长度减去此时的指针索引即为最后一个单词的长度
    public static int lengthOfLastWord(String s) {
        // 如果字符串s为空或为null，返回0
        if(s.length() == 0 || s == null) {
            return 0;
        }
        // 去除字符串s两端的空白字符
        s = s.trim();

        // 初始化start变量，这将用于记录最后一个单词的起始索引
        int start = 0;

        // 从字符串的末尾开始向前遍历，直到遇到一个非空格字符
        for(int i = s.length() - 1; i >= 0; i--) {
            if(s.charAt(i) == ' ') {
                // 遇到空格，结束循环
                break;
            }
            // 更新start为当前非空格字符的索引
            start = i;
        }

        // 计算最后一个单词的长度，即字符串长度减去start
        // 由于start是在最后一个单词的第一个字符上，所以用字符串长度减去start
        // 得到最后一个单词的长度
        return s.length() - start;
    }
}
