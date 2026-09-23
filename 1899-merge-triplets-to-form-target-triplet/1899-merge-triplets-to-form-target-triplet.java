class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int[] maxTriplet = new int[3];
        boolean answer = false;
        for(int[] triplet: triplets){
            if(triplet[0] <= target[0] && triplet[1] <= target[1] && triplet[2] <= target[2]){
                maxTriplet[0] = Math.max(triplet[0], maxTriplet[0]);
                maxTriplet[1] = Math.max(triplet[1], maxTriplet[1]);
                maxTriplet[2] = Math.max(triplet[2], maxTriplet[2]);
            }
        }
        if(maxTriplet[0] == target[0] && maxTriplet[1] == target[1] && maxTriplet[2] == target[2]){
            answer = true;
        }
        return answer;
    }
}