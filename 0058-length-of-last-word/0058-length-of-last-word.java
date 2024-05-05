class Solution {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0)
            return 0;

        char[] ch = s.toCharArray();
        StringBuilder ans = new StringBuilder();
        int n = ch.length;
        for (int i = n - 1; i >= 0; i--) {
            if (ch[i] != ' ') {
                ans.append(ch[i]);
            } else if (ans.length() > 0) {
                break;
            }
        }
        return ans.length();
    }
}
