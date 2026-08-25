class Solution {
    public int[] twoSum(int[] nums, int target) {
        // brute force - every combination, unacceptable
        // how to exploit -> consider 3 components where 1 is static (target)
        // then for each addend, there is only ever 1 complementary addend
        // use set to dedupe and fast find complements
        // however, we need to track indices, so use a map where addend is key
        // and value is index
        // don't need to store all numbers, we can short circuit once solved
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // must check before adding (because addend may match itself)
            int compl = target - nums[i];
            if (map.containsKey(compl)) {
                return new int[]{map.get(compl), i};
            }
            map.put(nums[i], i);
        }
        return null; // should never run bc 1 answer exists
    }
}
