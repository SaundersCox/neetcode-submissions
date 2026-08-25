class Solution {
    public int longestConsecutive(int[] nums) {

        // we cannot sort by O(n)
        // I want to count up, but I don't want to overcount
        // what distinguishes these numbers?
        // some numbers are lower bounds ie dont have 
        // a lower consecutive neighbor
        // use this property to count only values that are
        // lower bounds
        // use a set for deduping & fast finds
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int longest = 0;
        for (int num : nums) {
            // fast fail this iteration on non-lower bounds
            if (set.contains(num - 1)) {
                continue;
            }
            // now working with lower bound
            int len = 1;
            while (set.contains(++num)) {
                len++;
            }
            longest = Math.max(len, longest);
        }
        return longest;
    }
}
