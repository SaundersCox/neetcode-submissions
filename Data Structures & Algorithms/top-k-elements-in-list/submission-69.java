class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // first count elements
        // then pass counts into min heap & poll when exceeding k
        //   this retains the top k elements
        //   if it was ordered answer, order the k elements at the end
        Map<Integer, Integer> numToFreqMap = new HashMap<>();
        for (int num : nums) {
            numToFreqMap.merge(num, 1, Integer::sum);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(
            Map.Entry.comparingByValue()
        );
        for (Map.Entry<Integer, Integer> numToFreq : numToFreqMap.entrySet()) {
            minHeap.offer(numToFreq);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        // pq -> int[]
        int[] top = new int[k];
        for (int i = 0; i < k; i++) {
            top[i] = minHeap.poll().getKey();
        }
        return top;
    }
}
