class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> freq = new HashMap<>();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            if (freq.containsKey(key)) {
                freq.get(key).add(s);
            } else {
                List<String> newList = new ArrayList<>();
                newList.add(s);
                freq.put(key, newList);
            }
        }
        return new ArrayList<>(freq.values());
    }
}