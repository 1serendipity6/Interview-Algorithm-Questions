package interview_questions.array_string_operation;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Leo
 * @data 2024/10/12 上午 11:04
 * @description: 文本左右对齐
 */
public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        // 创建一个列表来存储最终的排版结果
        List<String> result = new ArrayList<>();
        // 从第一个单词开始排版
        int start = 0;

        // 遍历单词数组，直到所有单词都被排版
        while (start < words.length) {
            // 初始化当前行的结束位置和当前行的长度
            int end = start;
            int lineLength = 0;

            // 计算当前行可以包含的单词和总长度
            while (end < words.length && lineLength + words[end].length() + (end - start) <= maxWidth) {
                // 如果当前单词可以放入当前行，则增加行长度并移动结束位置
                lineLength += words[end].length();
                end++;
            }

            // 构建当前行
            StringBuilder line = new StringBuilder();
            // 计算当前行的单词数量和空格数量
            int numOfWords = end - start;
            int numOfGaps = numOfWords - 1;

            // 如果是最后一行或者当前行只有一个单词，则左对齐
            if (end == words.length || numOfWords == 1) {
                for (int i = start; i < end; i++) {
                    // 将单词添加到行中
                    line.append(words[i]);
                    // 如果不是最后一个单词，则添加一个空格
                    if (i < end - 1) line.append(" ");
                }
                // 如果行的长度小于maxWidth，则用空格填充至maxWidth
                while (line.length() < maxWidth) line.append(" ");
            } else {
                // 如果不是最后一行且当前行有多个单词，则左右对齐
                // 计算总空格数和每个单词之间的空格数
                int totalSpaces = maxWidth - lineLength;
                int spacesBetweenWords = totalSpaces / numOfGaps;
                int extraSpaces = totalSpaces % numOfGaps;

                for (int i = start; i < end; i++) {
                    // 将单词添加到行中
                    line.append(words[i]);
                    // 如果不是最后一个单词，则添加计算出的空格数
                    if (i < end - 1) {
                        for (int j = 0; j < spacesBetweenWords; j++) {
                            line.append(" ");
                        }
                        // 如果还有额外的空格，则添加一个空格
                        if (extraSpaces > 0) {
                            line.append(" ");
                            extraSpaces--;
                        }
                    }
                }
            }

            // 将当前行添加到结果列表中
            result.add(line.toString());
            // 移动开始位置到下一行的开始
            start = end;
        }

        // 返回排版后的文本列表
        return result;
    }

    public static void main(String[] args) {
        TextJustification tj = new TextJustification();
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        String[] words_01 = {"What","must","be","acknowledgment","shall","be"};
        int maxWidth = 16;
        List<String> justifiedText = tj.fullJustify(words, maxWidth);
        List<String> justifiedText_01 = tj.fullJustify(words_01, maxWidth);
        for (String line : justifiedText) {
            System.out.println("\"" + line + "\"");
        }

        for (String line_01:justifiedText_01){
            System.out.println("\""+ line_01 + "\'" );
        }
    }
}
