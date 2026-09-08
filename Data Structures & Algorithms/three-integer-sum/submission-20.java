class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // could check all combinations for O(n^3)
        // sort & scan reduces to O(n^2) - for each num, scan inward with 2pt
        // multiple solutions
        List<List<Integer>> triplets = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            // no more potential solutions
            if (nums[i] > 0) {
                break;
            }
            // skip duplicates
            if (i >= 1 && nums[i] == nums[i - 1]) {
                continue;
            }
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum < 0) {
                    l++;
                } else if (sum > 0) {
                    r--;
                } else {
                    triplets.add(List.of(nums[i], nums[l], nums[r]));
                    l++;
                    r--;
                    // skip dupes
                    while (l < r && nums[l] == nums[l - 1]) {
                        l++;
                    }
                }
            }
        }
        return triplets;
    }
}
