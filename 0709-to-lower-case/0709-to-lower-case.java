class Solution {
    public String toLowerCase(String s) {
        char[] arr = s.toCharArray();
        for(int i = 0; i < arr.length; i++){
            if(Character.isUpperCase(arr[i])){
                char c = Character.toLowerCase(arr[i]);
                arr[i] = c;
            }
        }
        return new String(arr);
    }
}