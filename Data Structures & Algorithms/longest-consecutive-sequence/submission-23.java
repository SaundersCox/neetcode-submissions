class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        // use dedupes + fast access
        // idea is that there is one value to search in the set
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        // to go from O(n^2) -> O(n), only consider seqs
        // that are a starting point (have no prev)
        int result = 1;
        for (int num : set) {
            int len = 1;
            if (set.contains(num - 1)) {
                continue;
            }
            while (set.contains(num + 1)) {
                System.out.println(num);
                len++;
                num++;
            }
            result = Math.max(result, len);
        }
        return result;
    }
}
