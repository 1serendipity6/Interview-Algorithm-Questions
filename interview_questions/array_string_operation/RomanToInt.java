package interview_questions.array_string_operation;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Leo
 * @data 2024/8/12 上午 10:45
 * 罗马数字转整数
 *
 */
/**罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。

 字符          数值
 I             1
 V             5
 X             10
 L             50
 C             100
 D             500
 M             1000
 例如， 罗马数字 2 写做 II ，即为两个并列的 1 。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。

 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：

 I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
 C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 给定一个罗马数字，将其转换成整数。*/
public class RomanToInt {

    /**将罗马数字转换为整数的过程可以通过遍历字符串并根据罗马数字的规则来累加数值来实现。以下是转换算法的基本步骤：
     1.创建一个映射：首先，创建一个映射（例如，使用哈希表或数组），将罗马数字字符映射到它们的整数值。
     2.初始化变量：初始化一个变量来存储转换后的整数值，通常从0开始。
     3.遍历字符串：遍历罗马数字字符串的每个字符。
     4.处理规则：对于每个字符，执行以下操作：
     5.如果当前字符的值小于它右边字符的值（如果存在），则从累加值中减去当前字符的值。
     如果当前字符的值大于或等于它右边字符的值，或者它是字符串中最后一个字符，则将当前字符的值添加到累加值。
     6.返回结果：遍历完成后，返回累加值作为结果。
     */
    //实现方式1：使用hashMap
//    public int romanToInt(String s){
//        // 定义罗马数字与整数的映射关系
//        Map<Character, Integer> romanMap = new HashMap<>();
//        romanMap.put('I', 1);
//        romanMap.put('V', 5);
//        romanMap.put('X', 10);
//        romanMap.put('L', 50);
//        romanMap.put('C', 100);
//        romanMap.put('D', 500);
//        romanMap.put('M', 1000);
//
//        int total = 0;
//        int prevValue = 0;
//
//        // 从字符串的末尾向前遍历
//        for (int i = s.length() - 1; i >= 0; i--) {
//            char currentChar = s.charAt(i);
//            int currentValue = romanMap.get(currentChar);
//
//            // 如果当前字符代表的数值小于前一个字符代表的数值，则减去当前数值
//            // 否则加上当前数值
//            if (currentValue < prevValue) {
//                total -= currentValue;
//            } else {
//                total += currentValue;
//            }
//            prevValue = currentValue;
//        }
//
//        return total;
//    }


//方式2：使用數組
    public int romanToInt(String s) {
        // 将字符串转换为字符数组，以便遍历
        char[] charArray = s.toCharArray();
        // 获取数组中第一个字符的整数值，并初始化
        int pre = getValue(charArray[0]);
        // 初始化总和为0，用于累加结果
        int sum = 0;

        // 遍历字符数组，从第二个字符开始
        for(int i = 1; i < charArray.length; i++) {
            // 获取当前字符的整数值
            int cur = getValue(charArray[i]);

            // 如果当前字符的值大于前一个字符的值，则从总和中减去前一个字符的值
            // 这是因为罗马数字中，如果一个较小的数字在一个大数字的左边，表示的是大数字减去小数字
            if(pre < cur) {
                sum = sum - pre;
            } else {
                // 否则，将前一个字符的值加到总和中
                sum = sum + pre;
            }

            // 更新前一个字符的值为当前字符的值
            pre = cur;
        }

        // 循环结束后，将最后一个字符的值加到总和中
        // 因为循环中不处理字符串的最后一个字符
        sum = sum + pre;

        // 返回计算得到的整数结果
        return sum;
    }

    /**
     * 根据罗马数字字符返回其整数值。
     * @param c 罗马数字字符
     * @return 对应的整数值
     */
    private int getValue(char c) {
        // 使用switch语句根据字符返回对应的整数值
        switch(c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0; // 如果字符不是罗马数字的一部分，则返回0
        }
    }


    }

