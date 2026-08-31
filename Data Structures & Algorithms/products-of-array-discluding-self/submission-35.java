class Solution {
    public int[] productExceptSelf(int[] nums) {
        // run products starting at index 1 compounding the running product
        int[] result = new int[nums.length];
        Arrays.fill(result, 1);
        int l = 1;
        int r = 1;
        for (int i = 1; i < nums.length; i++) {
            int rev = nums.length - 1 - i;
            l *= nums[i - 1];
            r *= nums[rev + 1];
            result[i] *= l;
            result[rev] *= r;
        }
        return result;
    }
}  
