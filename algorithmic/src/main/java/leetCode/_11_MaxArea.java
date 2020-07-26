package leetCode;

/**
 * 盛最多水的容器
 * @author hw
 * @version on 2020/3/16
 */
public class _11_MaxArea {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int left=0,right=0;

        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int area = (j - i) * Integer.min(height[i], height[j]);
                if(area > maxArea){
                    maxArea = area;
                    left = i;
                    right = j;
                }
            }
        }
        System.out.println("第"+left+"个元素"+height[left]+"和第"+right + "个元素"+height[right]+", 面积 " + maxArea);
        return maxArea;
    }

    public int maxArea_copy(int[] height){
        int i = 0, j = height.length - 1, res = 0;
        while(i < j){
            int area = 0;
            if(height[i] < height[j]){
                area =  (j - i) * height[i];
                i++;
            }else{
                area =  (j - i) * height[j];
                j--;
            }
            if(area > res){
                res = area;
            }
        }

        //简化版
        //while(i < j){
        //    res = height[i] < height[j] ?
        //            Math.max(res, (j - i) * height[i++]):
        //            Math.max(res, (j - i) * height[j--]);
        //}

        return res;
    }

    public static void main(String[] args) {
        int[] array = {1,8,6,2,5,4,8,3,7};
        System.out.println(new _11_MaxArea().maxArea_copy(array));
        ;

        //int[] array = {1,8,6};
        //new _11_MaxArea().maxArea(array);
    }
}
