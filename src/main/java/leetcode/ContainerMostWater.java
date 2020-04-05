package leetcode;

/**
 * @author shivanidwivedi on 28/01/20
 * @project JavaProgramming
 */
public class ContainerMostWater {
    public static int maxArea(int[] height) {
        if (height.length == 2){
            return Math.min(height[0], height[1]);
        }
        int maxArea = 0;
        if (height.length > 2){
            for (int i = 0; i < height.length; i++){
                for (int j = i+1; j < height.length; j++){
                    int currentArea = getArea(height[i],height[j], j - i);
                    if(maxArea < currentArea){
                        maxArea = currentArea;
                    }
                }
            }
        }
        return maxArea;
    }

    static int getArea(int a, int b, int distance){
        return Math.min(a,b)*distance;
    }

    public static int maxAreaPointer(int[] height){
        int i = 0; int j = height.length - 1;
        int maxArea = 0;
        while (i < j) {
            int distance = j - i;
            int area = Math.min(height[i],height[j]) * distance;
            maxArea = Math.max(maxArea, area);
            if (height[i] < height[j]) {
                i++;
            }else {
                j--;
            }
        }
        return maxArea;
    }
}
