class Solution {
    public boolean isAnagram(String s, String t) {
        // anagram -> true
        // lowercase English
        // sort -> nlogn
        // int array as char freq map -> n
        // s will incr freq, t will decr freq
        // check if all freqs neutralize to 0

        // edge cases: differ in len
        if (s.length() != t.length()) {
            return false;
        }
        int[] freqs = new int[26];
        for (char c : s.toCharArray()) {
            freqs[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            freqs[c - 'a']--;
        }
        for (int i = 0; i < freqs.length; i++) {
            if (freqs[i] != 0) return false;
        }
        return true;
    }
}
