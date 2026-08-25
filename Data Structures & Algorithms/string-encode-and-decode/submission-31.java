class Solution {

    public String encode(List<String> strs) {
        //use a delimiter, but delimiter could be arbitrary
        // how can we ensure?
        // use a number to define length, and a delimiter to ensure
        // we parsed the length correctly
        // this distinguishes the metadata from the string guaranteed
        // 3&cup4&pail
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str.length())
                .append('&')
                .append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();

        // decode by parsing EXACTLY via sliding window
        int l = 0;
        int r = 0;
        // while we have more to parse
        while (l < str.length()) {
            while (str.charAt(r) != '&') {
                r++;
            }
            int len = Integer.parseInt(str.substring(l, r));
            // reset l to be 1 past the delimiter
            l = r + 1;
            // reset r to match l offset by len
            r = l + len;
            result.add(str.substring(l, r));
            // r should be sitting at the beginning of the next str
            l = r;
        }
        return result;
    }
}
