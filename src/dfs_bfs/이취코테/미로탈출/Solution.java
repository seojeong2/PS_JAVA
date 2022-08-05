package dfs_bfs.이취코테.미로탈출;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

    static class Node{
        int x;
        int y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static int n,m;
    static int[][] map;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine(); // 버퍼 지우기

        map = new int[n][m];
        for(int i=0; i<n; i++){
            String str = sc.nextLine();
            for(int j=0; j<m; j++){
                map[i][j] = str.charAt(j) - '0';
            }
        }
        System.out.println(bfs(0,0));

    }
    public static int bfs(int x, int y){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x,y));

        while(!q.isEmpty()){
            Node node = q.poll();
            x = node.x;
            y = node.y;

            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 범위 체크
                if(nx < 0 || nx >= n || ny < 0 || ny >= m){
                    continue;
                }
                // 벽(=0)인 경우 무시
                if(map[nx][ny] == 0) continue;
                if(map[nx][ny] == 1){
                    map[nx][ny] = map[x][y] + 1;
                    q.offer(new Node(nx,ny));
                }

            }
        }
        return map[n-1][m-1];
    }
}
