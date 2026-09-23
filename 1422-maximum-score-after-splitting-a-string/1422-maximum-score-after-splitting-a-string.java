class Solution {
    public int maxScore(String s) {
        int onesCount = 0;
        int max_score = Integer.MIN_VALUE;

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '1'){
                onesCount++;
            }
        }
        int zeroCount = 0;
        for(int i = 0; i <s.length() - 1; i++){
            if(s.charAt(i) == '0'){
                zeroCount++;
            }
            else{
                onesCount--;
            }
            max_score = Math.max(max_score, onesCount + zeroCount);
        }
        return max_score;
    }
}