class Solution {
    public int[] productExceptSelf(int[] nums) {
        // a   b.  c 
        // bc. ac. ab
        //     a.  ab
        // bc. c.  
        int[] result = new int[nums.length];
        Arrays.fill(result, 1);
        
        for (int i = 1; i < nums.length; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }
        // need to track the factor in reverse, bc result modified
        int factor = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            factor *= nums[i + 1];
            result[i] *= factor;
        }
        return result;
    }
}  
