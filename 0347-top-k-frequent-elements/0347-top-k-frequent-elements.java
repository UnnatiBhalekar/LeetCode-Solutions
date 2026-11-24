class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int i : nums) {
            freq.put(i, freq.getOrDefault(i, 0) + 1);
        }
        List<Integer>[] bucket = new List[nums.length + 1];
        for (int x : freq.keySet()) {
            int count = freq.get(x);
            if (bucket[count] == null) {
                bucket[count] = new ArrayList<>();
            }
            bucket[count].add(x);
        }
        int[] result = new int[k];
        int index = 0;
        for(int i = bucket.length - 1; i > 0 && index < k; i--){
            if(bucket[i] == null){
                continue;
            }
            for(int x: bucket[i]){
                if(index < k){
                    result[index++] = x;
                }
            }
        }
        return result;
    }
}