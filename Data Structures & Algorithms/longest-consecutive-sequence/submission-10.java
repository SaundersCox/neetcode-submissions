class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        // Big idea: only start at the low end of a sequence
        //  i.e. only begin counting if no number exists below it
        int longest = 1;
        for (int num : nums) {
            if (set.contains(num - 1)) { // ineligible
                continue;
            }
            int cur = 1;
            while (set.contains(++num)) {
                cur++;
                longest = Math.max(longest, cur);
            }
        }
        return longest;
    }
}
