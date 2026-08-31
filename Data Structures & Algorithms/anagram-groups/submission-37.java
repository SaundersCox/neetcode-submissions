class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // map anagrams to a key that shares a trait (char freq map)
        // how to use char freq map as a key? stringify
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] freqs = new int[26];
            for (char c : str.toCharArray()) {
                freqs[c - 'a']++;
            }
            String freqsStr = Arrays.toString(freqs);
            map.computeIfAbsent(freqsStr, k -> new ArrayList<String>())
                .add(str);
        }
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            result.add(entry.getValue());
        }
        return result;
    }
}
