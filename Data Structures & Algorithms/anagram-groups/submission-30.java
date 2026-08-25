class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        // how will I determine anagram, 
        // for lowercase English, use int array as char map
        // to group, we will cluster anagrams using a map
        // how can we consolidate anagrams via a single key?
        // we could sort the letters and use string.equals
        // or we could leverage the bounds of the problem and use Arrays.toString()
        // with the int array as char map
        // this way we can use a map with the order of the letters (a:0, b:1, etc)
        
        // so we map char freq map (int array as str) to the anagrams (strs)
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] charMap = new int[26];
            for (char c : str.toCharArray()) {
                charMap[c - 'a']++;
            }
            String charFreqKey = Arrays.toString(charMap);
            // add to the value list of strings - but may not yet be inst
            map.computeIfAbsent(charFreqKey, k -> new ArrayList<String>()).add(str);
        }
        // now we have a map of char freq keys, lists of str
        // and we want to return the list of strs
        for (List<String> val : map.values()) {
            result.add(val);
        }
        return result;
    }
}
