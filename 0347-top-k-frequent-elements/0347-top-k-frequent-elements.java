class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b) -> map.get(a) - map.get(b));

        for(int num : map.keySet()){
            heap.add(num);
            if(heap.size() > k){
                heap.remove();
            }
        }

        int[] result = new int[k];
        for(int i = 0; i < k; i++){
            result[i] = heap.poll();
        }

        return result;
    }
}