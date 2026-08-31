class Solution {

    public String encode(List<String> strs) {
        // encode as <num><delim><str>
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str.length()).append('#').append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int l = 0;
        int r = 0;
        while (l < str.length()) {
            while (str.charAt(r) != '#') {
                r++;
            }
            int len = Integer.parseInt(str.substring(l, r));
            l = r + 1;
            r = l + len;
            result.add(str.substring(l, r));
            l = r;
        }
        return result;
    }
}
