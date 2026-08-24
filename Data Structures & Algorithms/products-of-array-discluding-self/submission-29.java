class Solution {
    public int[] productExceptSelf(int[] nums) {
        // product of all nums except self without division
        // how do we build up the factors?
        // a   b   c
        // bc  ac  ab
        //     a   b (from the left)
        // bc  c     (from the right)

        int[] result = new int[nums.length];
        Arrays.fill(result, 1);

        int factor = 1;
        for (int i = 1; i < nums.length; i++) {
            factor *= nums[i - 1];
            result[i] *= factor;
        }
        factor = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            factor *= nums[i + 1];
            result[i] *= factor;
        }
        return result;
    }
}  
