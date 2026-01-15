class Solution {
    public int[] plusOne(int[] digits) {
        
        for(int i = digits.length - 1; i >= 0; i--){
            if(digits[i] < 9){
                digits[i] = digits[i] + 1;
                return digits;
            }
             if(digits[i] == 9){
                digits[i] = 0;
            
            }
        }
        int[] answer = new int[digits.length + 1];
        answer[0] = 1;
        return answer;
        
    }
}