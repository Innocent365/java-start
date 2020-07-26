package leetCode;

import leetCode.assist.ListNode;
import org.junit.Test;

import java.util.*;

/**
 * @author hw
 * @version on 2020/3/28
 */
@SuppressWarnings("All")
public class _84_LargestRectangleArea {

    /**
     * Map多此一举
     *
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {
        Map<Integer, Queue> map = new TreeMap<>();
        for (int i = 0; i < heights.length; i++) {
            Queue queue = map.computeIfAbsent(heights[i], k -> new LinkedList());
            queue.offer(i);
        }

        int maxArea = 0, area = 0;
        Iterator<Integer> iterator = map.keySet().iterator();
        //从最小数开始遍历
        while (iterator.hasNext()) {
            int num = iterator.next();
            Queue<Integer> queue = map.get(num);
            Integer index;
            while (queue.size() > 0) {
                index = queue.poll();

                int left = 0;
                for (int i = index - 1; i >= 0; i--) {
                    if (heights[i] < num) {
                        left = i + 1;
                        break;
                    }
                }

                int right = heights.length - 1;
                for (int i = index + 1; i < heights.length; i++) {
                    if (heights[i] < num) {
                        right = i - 1;
                        break;
                    }
                }
                area = num * (right - left + 1);
                if (area > maxArea) {
                    maxArea = area;
                }
            }
        }

        return maxArea;
    }

    /**
     * 原始暴力
     * @param heights
     * @return
     */
    public int largestRectangleArea2(int[] heights) {

        int maxArea = 0, area = 0;
        //从左向右开始遍历
        for (int i = 0; i < heights.length; i++) {
            int num = heights[i];

            int left = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (heights[j] < num) {
                    left = j + 1;
                    break;
                }
            }

            int right = heights.length - 1;
            for (int j = i + 1; j < heights.length; j++) {
                if (heights[j] < num) {
                    right = j - 1;
                    break;
                }
            }
            area = num * (right - left + 1);
            if (area > maxArea) {
                maxArea = area;
            }
        }
        return maxArea;
    }

    /**
     * 维护一个索引的有序集合来优化查找left，right过程
     * @param heights
     * @return
     */
    public int largestRectangleArea3(int[] heights) {
        Map<Integer, Queue> map = new TreeMap<>();
        for (int i = 0; i < heights.length; i++) {
            Queue queue = map.computeIfAbsent(heights[i], k -> new LinkedList());
            queue.offer(i);
        }
        //维护一个小于n的数的索引列表
        LinkedList<Integer> list = new LinkedList();

        int maxArea = 0, area = 0;
        Iterator<Integer> iterator = map.keySet().iterator();
        //从最小数开始遍历
        while (iterator.hasNext()) {
            int num = iterator.next();
            Queue<Integer> queue = map.get(num);
            Integer index;
            while (queue.size() > 0) {
                index = queue.poll();

                //list.add(index);
                //Collections.sort(list);
                //int i = list.indexOf(index);
                //int left = (i == 0) ? 0 : (list.get(i-1) + 1);
                //int right = (i==list.size()-1) ? heights.length-1:(list.get(i + 1) - 1);

                int left = -1, right = heights.length-1;
                for (int i = 0; i < list.size(); i++) {
                    if(list.get(i) > index){
                        left = i==0?0:list.get(i-1) + 1;
                        right = list.get(i) - 1;
                        list.add(i, index);
                        break;
                    }
                }
                if(left == -1){
                    list.add(index);
                    left = list.get(list.size() - 1);
                }
                area = num * (right - left +1 );
                if (area > maxArea) {
                    maxArea = area;
                    //list.stream().forEach(System.out::print);
                    //System.out.println("index: [" + left + ", " + right + "]") ;
                }
            }
        }

        return maxArea;
    }
    /**
     * 自定义一个索引的有序集合来优化查找left，right过程
     * @param heights
     * @return
     */
    public int largestRectangleArea4(int[] heights) {
        Map<Integer, Queue> map = new TreeMap<>();
        for (int i = 0; i < heights.length; i++) {
            Queue queue = map.computeIfAbsent(heights[i], k -> new LinkedList());
            queue.offer(i);
        }
        //维护一个小于n的数的索引列表
        LinkNode fake = new LinkNode(-1);
        LinkNode node;

        int maxArea = 0, area = 0;
        Iterator<Integer> iterator = map.keySet().iterator();
        //从最小数开始遍历
        while (iterator.hasNext()) {
            int num = iterator.next();
            Queue<Integer> queue = map.get(num);
            Integer index;
            while (queue.size() > 0) {
                index = queue.poll();
                node = fake;
                int left, right;
                while (true){
                    if(node.next != null) {
                        if (node.next.val > index) {
                            left = node.val + 1;
                            right = node.next.val - 1;
                            LinkNode temp = node.next;
                            node.next = new LinkNode(index);
                            node.next.next = temp;
                            break;
                        }
                        node = node.next;
                    }else{
                        left = node.val + 1;
                        right = heights.length-1;
                        node.next = new LinkNode(index);
                        break;
                    }
                }

                area = num * (right - left +1 );
                if (area > maxArea) {
                    maxArea = area;
                    //list.stream().forEach(System.out::print);
                    //System.out.println("index: [" + left + ", " + right + "]") ;
                }
            }
        }

        return maxArea;
    }

    public int calculateArea(int[] heights, int start, int end) {
        if (start > end)
            return 0;
        int minindex = start;
        for (int i = start; i <= end; i++)
            if (heights[minindex] > heights[i])
                minindex = i;
        return Math.max(
                heights[minindex] * (end - start + 1),
                Math.max(calculateArea(heights, start, minindex - 1),
                        calculateArea(heights, minindex + 1, end)));
    }

    /**
     * copy 官方，分治算法
     * @param heights
     * @return
     */
    public int largestRectangleArea5(int[] heights) {
        return calculateArea(heights, 0, heights.length - 1);
    }

    /**
     * 栈 copy
     * @param heights
     * @return
     */
    public int largestRectangleArea6(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxarea = 0;
        for (int i = 0; i < heights.length; i++) {
            while (stack.peek()!=-1 && heights[i] < heights[stack.peek()]){
                int h = heights[stack.pop()];
                maxarea = Math.max(maxarea, h * (i - stack.peek() -1));
            }
            stack.push(i);
        }
        while (stack.peek() != -1){
            int h = heights[stack.pop()];
            maxarea = Math.max(maxarea, h * (heights.length - stack.peek() -1));
        }
        return maxarea;
    }



    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 6, 7, 3};
        //int[] arr = {5,1,5,6,2,3};
        //int[] arr = {1};
        //int[] arr = new int[20000];
        //for (int i = 0; i < 20000; i++) {
        //    arr[i] = i;
        //}
        System.out.println(new _84_LargestRectangleArea().largestRectangleArea6(arr));
        System.out.println(new _84_LargestRectangleArea().largestRectangleArea2(arr));
        //System.out.println(new _84_LargestRectangleArea().largestRectangleArea3(arr));
        //System.out.println(new _84_LargestRectangleArea().largestRectangleArea4(arr));
    }

    class LinkNode {
        int val;
        LinkNode next;

        public LinkNode(int val) {
            this.val = val;
        }
    }

    @Test
    public void test(){
        LinkedList<Integer> list = new LinkedList(
                Arrays.asList(new Integer[]{3,6,7,9,10}));
        int a = 2;
        //int a = 4;
        //int a = 11;

        int left = -1, right = 20;
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i) > a){
                left = i==0?0:list.get(i-1) + 1;
                right = list.get(i) - 1;
                list.add(i, a);
                break;
            }
        }
        if(left<0) {
            list.add(a);
            left = list.get(list.size() - 1);
        }

        System.out.println("right=" + right + ", left=" + left);
        System.out.println("area= "+ (right - left + 1));

        list.stream().forEach(System.out::print);
    }
}
