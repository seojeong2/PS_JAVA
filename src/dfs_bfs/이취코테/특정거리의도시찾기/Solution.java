package dfs_bfs.이취코테.특정거리의도시찾기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

    static int n, m,k,x;
    public static ArrayList<ArrayList<Integer>> map = new ArrayList<ArrayList<Integer>>();
    public static int[] distance = new int[300001]; //모든 도시에 대한 최단 거리


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        // 그래프 및 최단거리 배열 초기화
        for(int i=0; i<=n; i++){
            map.add(new ArrayList<Integer>());
            distance[i] = -1;
        }
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map.get(a).add(b);
        }
        // 출발지 도시 0으로 설정
        distance[x] = 0;

        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(x);

        while(!q.isEmpty()){
            int now = q.poll();
            // 현재 도시에서 이동할 수 있는 도시들을 탐색
            for(int i=0; i<map.get(now).size(); i++){
                int nextNode = map.get(now).get(i);
                // 아직 방문하지 않은 도시라면
                if(distance[nextNode] == -1){
                    distance[nextNode] = distance[now] + 1;
                    q.offer(nextNode);
                }
            }
        }

        boolean check = false;
        for(int i=1; i<= n; i++){
            if(distance[i] == k){
                System.out.println(i);
                check = true;
            }
        }
        if(!check) System.out.println(-1);
    }
}
