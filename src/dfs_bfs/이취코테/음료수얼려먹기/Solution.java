package dfs_bfs.이취코테.음료수얼려먹기;

import java.util.Scanner;

public class Solution {

    static int n,m;
    static int[][] map;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine();

        map = new int[n][m];

        for(int i=0; i<n; i++){
            String str = sc.nextLine();
            for(int j=0; j<m; j++){
                map[i][j] = str.charAt(j) - '0';
            }
        }
        int result = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(dfs(i,j)){
                    result += 1;
                }
            }
        }
        System.out.println(result);
    }
    public static boolean dfs(int x, int y){
        if(x < 0 || x>=n || y<0 || y>=m){
            return false;
        }
        if(map[x][y] == 0){
            map[x][y] = 1;

            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                dfs(nx,ny);
            }
            return true;
        }
        return false;
    }
}

/*
- tc1:
4 5
00110
00011
11111
00000

- tc2
15 14
00000111100000
11111101111110
11011101101110
11011101100000
11011111111111
11011111111100
11000000011111
01111111111111
00000000011111
01111111111000
00011111111000
00000001111000
11111111110011
11100011111111
11100011111111

*/
