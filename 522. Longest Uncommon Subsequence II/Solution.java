class Solution {
    public int findLUSlength(String[] strs) {
        int maxLen = -1;
        for(int i = 0; i < strs.length ; i++){
            boolean flag = false ;
            int currLen = strs[i].length() ;
            for(int j = 0 ; j<strs.length; j++)
            {
                if(i != j && check(strs[i], strs[j]))
                {
                    flag = true ;
                    break ;
                }
            }
            if(!flag)
            {
                maxLen = Math.max(maxLen , currLen); 
            }
        }
        return maxLen ;
    }
    public boolean check(String str1, String str2){
        int A = str1.length() , B = str2.length() ;
        while(A > 0 && B > 0)
        {
            int i = str1.length() - A ;
            int j = str2.length() - B ;
            if(str1.charAt(i) == str2.charAt(j))
            {
                A-- ;
            }
            B-- ;
        }
        return A == 0;
    }
}