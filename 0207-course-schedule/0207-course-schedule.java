class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        //creating the adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }

        //creating an indegree array to check how many prerequisite each course has
        int[] inDegree = new int[numCourses];

        //building the graph and indegree array from pre requisites
        for(int[] prerequisite: prerequisites){
            adj.get(prerequisite[1]).add(prerequisite[0]);
            inDegree[prerequisite[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        //adding all the courses which has 0 prerequisites to the queue
        for(int i = 0; i < numCourses; i++){
            if(inDegree[i] == 0)
            {
                queue.offer(i);
            }
        }

        int nodeVisited = 0;
        while(!queue.isEmpty()){
            int node = queue.poll();
            nodeVisited++;

            for(int neighbor: adj.get(node)){
                inDegree[neighbor]--;

                if(inDegree[neighbor] == 0){
                    queue.offer(neighbor);
                }
            }

        }
        return nodeVisited == numCourses;

    }
}