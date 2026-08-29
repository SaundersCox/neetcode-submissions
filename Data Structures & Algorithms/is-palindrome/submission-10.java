class Solution {
    public boolean isPalindrome(String s) {
        // two pointer, fast failing on mismatch
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            char ch1 = s.charAt(l);
            if (!Character.isLetterOrDigit(ch1)) {
                l++;
                continue;
            }
            char ch2 = s.charAt(r);
            if (!Character.isLetterOrDigit(ch2)) {
                r--;
                continue;
            }
            System.out.println(String.format("%c %c", ch1, ch2));
            if (Character.toLowerCase(ch1) != Character.toLowerCase(ch2)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
