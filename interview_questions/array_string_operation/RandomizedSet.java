package interview_questions.array_string_operation;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

/**
 * @author Leo
 * @data 2024/8/6 上午 08:14
 * o（1）时间的插入、删除和获取随机元素
 * 实现RandomizedSet 类：
 *
 * RandomizedSet() 初始化 RandomizedSet 对象
 * bool insert(int val) 当元素 val 不存在时，向集合中插入该项，并返回 true ；否则，返回 false 。
 * bool remove(int val) 当元素 val 存在时，从集合中移除该项，并返回 true ；否则，返回 false 。
 * int getRandom() 随机返回现有集合中的一项（测试用例保证调用此方法时集合中至少存在一个元素）。每个元素应该有 相同的概率 被返回。
 * 你必须实现类的所有函数，并满足每个函数的 平均 时间复杂度为 O(1)
 */

public class RandomizedSet {
    public static void main(String[] args) {

        RandomizedSet randomizedSet = new RandomizedSet();
        boolean insert = randomizedSet.insert(1);
        boolean remove1 = randomizedSet.remove(2);
        boolean insert1 = randomizedSet.insert(2);
        int random1 = randomizedSet.getRandom();
        boolean remove = randomizedSet.remove(1);
        boolean insert2 = randomizedSet.insert(2);
        int random2 = randomizedSet.getRandom();
        System.out.println(insert);
        System.out.println(remove1);
        System.out.println(insert1);
        System.out.println(random1);
        System.out.println(remove);
        System.out.println(insert2);
        System.out.println(random2);

    }

    /**实现思路：我们需要实现O（1）时间复杂度的时间插入、删除和获取随机元素
     单独使用ArrayList集合或哈希集合，都没有办法实现，因为哈希集合不方便实现获取随机元素，ArrayList集合查询操作无法满足条件。这时不妨想想，哈希集合查询元素的时间复杂度为O(1),ArrayList集合删除最后一个元素，以及插入一个元素到最后都为O（1），且可以实现随机访问元素。
     这样一想，我们是不是可以将二者进行结合呢？
     因此我们先来进行对象初始化，需要定义3个对象：
     （1）定义ArrayList集合对象：用于存储元素和删除元素
     （2）定义哈希集合对象：用于查询元素
     （3）定义随机数对象用于获取随机索引
     然后进行方法的构思：
     insert方法首先检查值是否已经存在于HashMap中，如果存在，则返回false。如果不存在，将值添加到ArrayList的末尾，并在HashMap中记录这个值到其索引的映射。
     remove方法检查值是否存在于HashMap中，如果不存在，则返回false。如果存在，找到这个值的索引，将ArrayList的最后一个元素移动到要删除的元素的位置，并更新HashMap中的索引。然后，从ArrayList中删除最后一个元素，并从HashMap中删除对应的映射。
     getRandom方法使用Random对象生成一个随机索引，并从ArrayList中返回该索引处的元素。
     * */

    // 使用HashMap存储数字到索引的映射
    private HashMap<Integer, Integer> numToIndex;
    // 使用ArrayList存储集合中的所有数字
    private ArrayList<Integer> nums;
    // Random对象用于生成随机数
    private Random rand;

    // 构造函数，初始化HashMap、ArrayList和Random对象
    public RandomizedSet() {
        numToIndex = new HashMap<>();
        nums = new ArrayList<>();
        rand = new Random();
    }

    // 插入操作，如果元素已存在则返回false，否则插入并返回true
    public boolean insert(int val) {
        // 检查元素是否已存在
        if (numToIndex.containsKey(val)) {
            return false;
        }
        // 将元素添加到ArrayList的末尾，并记录其索引
        numToIndex.put(val, nums.size());
        nums.add(val);
        return true;
    }

    // 删除操作，如果元素不存在则返回false，否则删除并返回true
    public boolean remove(int val) {
        // 检查元素是否存在
        if (!numToIndex.containsKey(val)) {
            return false;
        }
        // 获取要删除元素的索引
        int removeIndex = numToIndex.get(val);
        // 获取ArrayList的最后一个元素
        int lastElement = nums.get(nums.size() - 1);
        // 将最后一个元素放到要删除的元素的位置
        nums.set(removeIndex, lastElement);
        // 更新最后一个元素在HashMap中的索引
        numToIndex.put(lastElement, removeIndex);
        // 从ArrayList中移除最后一个元素
        nums.remove(nums.size() - 1);
        // 从HashMap中移除要删除元素的映射
        numToIndex.remove(val);
        return true;
    }

    // 随机获取一个元素
    public int getRandom() {
        // 生成一个随机索引
        int randomIndex = rand.nextInt(nums.size());
        // 返回ArrayList中随机索引处的元素
        return nums.get(randomIndex);
    }

}
