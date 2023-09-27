// USING : Recursion DFS top down
// TC : O(m*n)
// SC : O(m*n)
class Solution {
    int[][] memo;
    public int uniquePaths(int m, int n) {
        if( m == 0 || n==0) return 0;
        memo = new int[m][n];
        return dfs( 0, 0, m , n );
    }

    private int dfs (int i , int j , int m ,int n){
        //base
        if(i== m-1 || j ==n-1) return 1;
        if(i<0 || j<0 || i == m || j==n) return 0;
        //logic
        if(memo[i][j]== 0){
            memo[i][j] = dfs(i,j+1,m,n) + dfs(i+1,j,m,n);
        }
        return memo[i][j];
    }
}



// USING : DP bottom up 
// TC : O(m*n)
// SC : O(m*n)

class Solution {
    int[][] dp;
    public int uniquePaths(int m, int n) {
        if( m == 0 || n==0) return 0;
        dp = new int[m+1][n+1];
        dp [m-1][n-1] =1;
        for (int i = m-1 ; i>=0; i--){
            for(int j =n-1 ; j>=0;j--){
                if(i == m-1 && j ==n-1) continue;
                dp[i][j] =dp[i+1][j] + dp[i][j+1];
            }
        }
        return dp[0][0];
    }

    
}


// USING : DP bottom up
// TC : O(m*n)
// SC : O(n-1)

class Solution {
    int[] dp;
    public int uniquePaths(int m, int n) {
        if( m == 0 || n==0) return 0;
        dp = new int[n+1];
        dp [n-1] =1;
        for (int i = m-1 ; i>=0; i--){
            for(int j =n-1 ; j>=0;j--){
                if(i == m-1 && j ==n-1) continue;
                dp[j] =dp[j] + dp[j+1];
            }
        }
        return dp[0];
    }    
}