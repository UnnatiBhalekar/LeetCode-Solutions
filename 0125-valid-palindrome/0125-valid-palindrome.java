class Solution {
    public boolean isPalindrome(String s) {
        int l = 0, r=s.length() - 1;
        while(l<r){
        while(l<r && !Character.isLetterOrDigit(s.charAt(l))) l++;
        while(l<r && !Character.isLetterOrDigit(s.charAt(r))) r--;

        char left = Character.toLowerCase(s.charAt(l));
        char right = Character.toLowerCase(s.charAt(r));

        if(left!=right) return false;

        l++;
        r--;
    }
    return true;
    }
    
}