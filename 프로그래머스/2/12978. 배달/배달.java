import java.util.*;

class Solution {
    
    static int[] visited;
    
    class Node {
        int start, end, time;
        
        Node(int start, int end, int time) {
            this.start = start;
            this.end = end;
            this.time = time;
        }
    }
    
    public int solution(int N, int[][] road, int K) {
        ArrayList<ArrayList<Node>> list = new ArrayList<>();
        for(int i=0; i<=N; i++) {
            list.add(new ArrayList<>());
        }
        
        // 양방향 연결
        for(int[] r : road) {
            list.get(r[0]).add(new Node(r[0], r[1], r[2]));
            list.get(r[1]).add(new Node(r[1], r[0], r[2]));
        }
        
        visited = new int [N+1];
        for(int i=2; i<visited.length; i++) {
            visited[i] = Integer.MAX_VALUE;
        }
        
        arrive(list.get(1), list);
        
        int answer = 1;
        for(int i=2; i<visited.length; i++) {
            if(visited[i] <= K) {
                answer++;
            }
        }
        
        return answer;
    }
    
    /**
        각 도시에 도착하는 최단 거리 계산
    */
    private void arrive(ArrayList<Node> node, ArrayList<ArrayList<Node>> list) {
        Queue<Node> queue = new LinkedList<>();
        queue.addAll(node);
        
        while(!queue.isEmpty()) {
            Node n = queue.poll();
            
            // 최단거리 할당
            if(visited[n.end] >= visited[n.start] + n.time) {
                visited[n.end] = visited[n.start] + n.time;
                queue.addAll(list.get(n.end));
            }
        }
    }
}