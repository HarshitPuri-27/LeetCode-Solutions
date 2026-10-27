
import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();

        for (int num : nums) {
            freq.merge(num, 1, Integer::sum);
        }

        List<Integer>[] buckets = new List[nums.length + 1];

        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            int count = entry.getValue();

            if (buckets[count] == null) {
                buckets[count] = new ArrayList<>();
            }

            buckets[count].add(entry.getKey());
        }

        int[] result = new int[k];
        int index = 0;

        for (int count = buckets.length - 1;
             count >= 1 && index < k; count--) {
            if (buckets[count] != null) {
                for (int num : buckets[count]) {
                    result[index++] = num;

                    if (index == k) {
                        return result;
                    }
                }
            }
        }

        return result;
    }
}
