class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> charFreqStrToWordMap = new HashMap<>();

        // goal: group anagrams via a map of 'sorted' words
        for (String str : strs) {
            // use str representation of char array as keys
            char[] charFreq = new char[26];
            for (char ch : str.toCharArray()) {
                charFreq[ch - 'a']++;
            }
            // since val is a list, use compute to initialize
            // remember that compute will return the value to operate on
            charFreqStrToWordMap.computeIfAbsent(Arrays.toString(charFreq),
                k -> new ArrayList<>())
                .add(str);
        }
        return new ArrayList<>(charFreqStrToWordMap.values());
    }
}
