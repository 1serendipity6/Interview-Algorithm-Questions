package interview_questions.array_string_operation;

/**
 * @author Leo
 * @data 2024/8/19 上午 08:51
 * @description: 這是一個用於查找字符串數組中的最長公共前綴的函數。
 * 存在則返回前綴，不存在則返回空字符串。
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        String s = longestCommonPrefix(strs);
        System.out.println(s);
    }

    public static String longestCommonPrefix(String[] strs){
        //判空
        if (strs.length==0 ||strs==null){
            return "";
        }

        //設置第一個字符串為前綴字符串
        String prefix=strs[0];

        //如果第一個字符串的第一個字符與第二個不相同，則縮減前綴，前綴為空時返回空字符串
        for (String s:strs){
        while (!s.startsWith(prefix)){
                //不相同，則縮減前綴
               prefix= prefix.substring(0,prefix.length()-1);
                //若前綴為空則返回空字符串
                if (prefix.isEmpty()){
                    return "";
                }
            }
        }
        return prefix;

    }
}
