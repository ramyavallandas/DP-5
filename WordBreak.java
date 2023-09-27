// Using : DP top down
// TC : O(ml + l^3)
// SC : O(ml)

class Solution {
    HashSet<String> set;
    HashMap<String, Boolean> map;
    public boolean wordBreak(String s, List<String> wordDict) {
        this.set = new HashSet<>(wordDict); //ml
        this.map = new HashMap<>();
        return helper(s);
        
    }

    private boolean helper(String s){
        //base
        if(s.length() == 0) return true;


        //logic
        for(int i =0; i<s.length();i++){
            String sub = s.substring(0,i+1);


            if(set.contains(sub)){
                String restOfString = s.substring(i+1);
                if(!map.containsKey(restOfString)){
                    boolean result = helper(restOfString);
                    map.put(restOfString,result);
                }
                boolean inter = map.get(restOfString);
                if(inter) return true;
            }
        }
        return false;
    }

    
}



// Using : DP Bottom up
// Tc : o(ml + n^3)
// sc : O(n) + O(ml) 

class Solution {
    HashSet<String> set;
    public boolean wordBreak(String s, List<String> wordDict) {
        this.set = new HashSet<>(wordDict); //ml -> avg len of word in dict
        boolean[] dp = new boolean[s.length()+1];
        dp[0] =true;
        for(int i = 1; i<dp.length ; i++){ // n -> s.len
            for(int j = 0; j<i ; j++){
                if(dp[j] && set.contains(s.substring(j,i))){ //n
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
        
    }
    
}