package interview_questions.array_string_operation;

/**
 * @author Leo
 * @data 2024/8/14 下午 01:19
 * description：整數轉罗马数字
 *
 * 七个不同的符号代表罗马数字，其值如下：
 * 符号	值
 * I	1
 * V	5
 * X	10
 * L	50
 * C	100
 * D	500
 * M	1000
 * 罗马数字是通过添加从最高到最低的小数位值的转换而形成的。将小数位值转换为罗马数字有以下规则：
 *（1） 如果该值不是以 4 或 9 开头，请选择可以从输入中减去的最大值的符号，将该符号附加到结果，减去其值，然后将其余部分转换为罗马数字。
 *（2）如果该值以 4 或 9 开头，使用 减法形式，表示从以下符号中减去一个符号，例如 4 是 5 (V) 减 1 (I): IV ，9 是 10 (X) 减 1 (I)：IX。
 * 仅使用以下减法形式：4 (IV)，9 (IX)，40 (XL)，90 (XC)，400 (CD) 和 900 (CM)。
 * 只有 10 的次方（I, X, C, M）最多可以连续附加 3 次以代表 10 的倍数。你不能多次附加 5 (V)，50 (L) 或 500 (D)。如果需要将符号附加4次，请使用 减法形式。
 * 给定一个整数，将其转换为罗马数字。
 */
public class IntToRoman {
    public static String intToRoman(int num) {
        // 定义罗马数字与数值的映射关系
        String[] romanSymbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        StringBuilder roman = new StringBuilder();
        // 从最大的罗马数字开始
        for (int i = 0; num > 0; i++) {
            // 减去相应的罗马数字数值，并添加符号到结果字符串
            while (num >= values[i]) {
                num -= values[i];
                roman.append(romanSymbols[i]);
            }
        }
        return roman.toString();
    }

    public static void main(String[] args) {

        System.out.println(intToRoman(3749)); // 输出："MMMDCCXLIX"
        System.out.println(intToRoman(58));   // 输出："LVIII"
    }
}
