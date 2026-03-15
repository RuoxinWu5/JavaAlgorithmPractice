package stack_queue_heap;

import java.util.LinkedList;
import java.util.Queue;

// ====================== 核心思路 ======================
// 题目：字符流中第一个不重复的字符
// 要求：Insert插入字符，FirstAppearingOnce返回第一个只出现一次的字符
// 解法：计数数组 + 队列
// 1. times[128]：记录每个ASCII字符出现的次数
// 2. 队列：按插入顺序保存字符，保证队首始终是【第一个不重复的字符】
// 3. 每次插入后清理队首：重复出现的字符直接弹出，直到队首只出现一次
// 4. 无满足条件字符时返回 '#'

// 时间复杂度：O(1) Insert，O(1) 获取结果
// 空间复杂度：O(n)
// ======================================================

public class FirstUniqueCharInStream {
    private int[] times = new int[128];
    private Queue<Character> queue = new LinkedList<>();

    //Insert one char from stringstream
    public void Insert(char ch) {
        times[ch]++;
        queue.add(ch);
        while (!queue.isEmpty() && times[queue.peek()] > 1) {
            queue.poll();
        }
    }

    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        return queue.isEmpty() ? '#' : queue.peek();
    }

    public static void main(String[] args) {
        FirstUniqueCharInStream test = new FirstUniqueCharInStream();
        test.Insert('g');
        System.out.println(test.FirstAppearingOnce());
        test.Insert('o');
        System.out.println(test.FirstAppearingOnce());
        test.Insert('o');
        System.out.println(test.FirstAppearingOnce());
        test.Insert('g');
        System.out.println(test.FirstAppearingOnce());
        test.Insert('l');
        System.out.println(test.FirstAppearingOnce());
        test.Insert('e');
        System.out.println(test.FirstAppearingOnce());
    }
}
