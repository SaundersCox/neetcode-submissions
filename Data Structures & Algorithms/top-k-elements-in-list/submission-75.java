class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // k most frequent (top k -> heap)
        // build out a freq map, could use int[2000]
        // map the int to the freq
        // avoid doing a full sort by 
        // leveraging the partial sortedness constraint
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.merge(num, 1, Integer::sum);
        }
        // we want to track the nums, not the freqs
        // so we want to order by the freqs, but return the nums
        // ie init PQ to be a minheap for freqs, but return vals
        // we need to offer pairs to the PQ, use Map.Entry
        // in a minheap, we order from lowest to highest, where we
        // poll the front of the PQ (shaving off the mins)
        // this will retain the top K
        // override the comparator of Map.Entry
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
            (a, b) -> a.getValue() - b.getValue()
        );
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.offer(entry);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        // poll to clear the queue
        int[] result = new int[k];
        for (int i = 0 ; i < k; i++) {
            result[i] = pq.poll().getKey();
        }
        return result;
    }
}
