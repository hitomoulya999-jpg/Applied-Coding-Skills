class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<Integer>[] graph=new ArrayList[n];
        for(int i=0;i<n;i++){
            graph[i]=new ArrayList<>();
        }
        for(int[] edge:edges){
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        boolean[] visited=new boolean[n];
        Queue<Integer> queue=new LinkedList<>();
        queue.add(source);
        visited[source]=true;
        while(!queue.isEmpty()){
            int current =queue.poll();
            if(current==destination){
                return true;
            }
            for(int next:graph[current]){
                if(!visited[next]){
                    visited[next]=true;
                    queue.add(next);
                }
            }
        }
        return false;
    }
}