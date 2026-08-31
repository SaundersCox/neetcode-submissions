class Solution {
    public int[] twoSum(int[] nums, int target) {
        // use a set to track complements
        // find indices, need map to track
        // map complements to indices
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // check before to avoid comparing against same index
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
