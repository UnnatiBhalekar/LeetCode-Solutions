class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder result = new StringBuilder();

        //sorting the words
        Arrays.sort(strs);

        String firstString = strs[0];
        String lastString = strs[strs.length-1];

        //finding the longest common Prefix
        for(int i = 0; i < firstString.length(); i++){
            if(firstString.charAt(i) != lastString.charAt(i)){
                break;
            }
            result.append(firstString.charAt(i));
        }
        return result.toString();
    }
}