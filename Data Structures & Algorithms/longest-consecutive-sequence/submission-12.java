class Solution {
    public int longestConsecutive(int[] nums) {
        // brute force - sort and track
        // dedupe, check both directions & remove when checked
        // dedupe, check only when direction goes up (lower bound) & loop upward
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num); // dedupe + fast lookup
        }
        int longest = 0;
        for (int num : nums) {
            if (set.contains(num - 1)) continue; // not a lower bound, ineligible
            int len = 0;
            while (set.contains(num++)) {
                len++;
                longest = Math.max(len, longest);
            }
        }
        return longest;
    }
}
