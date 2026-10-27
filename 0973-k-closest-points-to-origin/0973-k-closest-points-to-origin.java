
import java.util.*;

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int left = 0, right = points.length - 1;

        while (left <= right) {
            int pivot = partition(points, left, right);

            if (pivot == k - 1) {
                break;
            } else if (pivot < k - 1) {
                left = pivot + 1;
            } else {
                right = pivot - 1;
            }
        }

        return Arrays.copyOf(points, k);
    }

    private int partition(int[][] points, int left, int right) {
        int[] pivotPoint = points[right];
        long pivot = distance(pivotPoint);
        int i = left;

        for (int j = left; j < right; j++) {
            if (distance(points[j]) <= pivot) {
                int[] temp = points[i];
                points[i++] = points[j];
                points[j] = temp;
            }
        }

        points[right] = points[i];
        points[i] = pivotPoint;

        return i;
    }

    private long distance(int[] point) {
        return (long) point[0] * point[0]
             + (long) point[1] * point[1];
    }
}
