class Solution {
    public boolean judgeSquareSum(int c) {
        HashSet<Integer> set = new HashSet<>();
        double x = Math.sqrt(c);
        int inverse = 0;
        
        if (c % x == 0)
            return true;
        
        int y = (int)x;
        
        for (int i = 1; i < y; i++) {
            set.add(i * i);
        }
        
        for (int i = 1; i < y; i++) {
            inverse = c - (i * i);
            if (!set.add(inverse))
                return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        int x = 5;
        Boolean answer = judgeSquareSum(x);
        System.out.println(answer);
        
    }
}