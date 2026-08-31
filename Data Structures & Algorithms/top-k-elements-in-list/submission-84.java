class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // most frequent -> heap/PQ
        // shave off min with minheap to retain top k
        // use freq count (map)
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.merge(num, 1, Integer::sum);
        }
        // use heap to retain top k frequencies, remember num is the key
        // similar to sorting descending, where end of q is guaranteed min
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
            (a, b) -> a.getValue() - b.getValue()
        );
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.offer(entry);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        // need to return as int[]
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = pq.poll().getKey();
        }
        return result;
    }
}
