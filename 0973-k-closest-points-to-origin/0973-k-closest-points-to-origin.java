import java.util.Arrays;

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // QuickSelect rearranges the array in-place so the K closest are at the front
        quickSelect(points, 0, points.length - 1, k);
        return Arrays.copyOf(points, k);
    }

    private void quickSelect(int[][] points, int left, int right, int k) {
        if (left >= right) return;

        // 1. Pick the middle element as our pivot value
        int pivotDist = getDist(points[left + (right - left) / 2]);
        int i = left, j = right;

        // 2. Push smaller distances to the left, larger distances to the right
        while (i <= j) {
            while (getDist(points[i]) < pivotDist) i++;
            while (getDist(points[j]) > pivotDist) j--;
            
            if (i <= j) {
                int[] temp = points[i];
                points[i] = points[j];
                points[j] = temp;
                i++;
                j--;
            }
        }

        // 3. Decide which half needs further processing based on index 'k'
        if (k <= j) {
            quickSelect(points, left, j, k); // Look in the left part
        } else if (k >= i) {
            quickSelect(points, i, right, k); // Look in the right part
        }
    }

    // Simple math helper to compute squared distance (x^2 + y^2)
    private int getDist(int[] point) {
        return (point[0] * point[0]) + (point[1] * point[1]);
    }
}