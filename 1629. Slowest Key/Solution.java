class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int maxTime = 0;
        int currTime = 0;
        char c = ' ';
        for (int i = 0; i < keysPressed.length(); i++) {
            
            if (i == 0) {
                maxTime = releaseTimes[0] - 0;
                c = keysPressed.charAt(0);
            }
            else 
                currTime = releaseTimes[i]- releaseTimes[i - 1];
            
            if (maxTime == currTime && keysPressed.charAt(i) > keysPressed.charAt(i-1)) {
                c = keysPressed.charAt(i);
            }        
            
            if (maxTime < currTime) {
                maxTime = (releaseTimes[i]- releaseTimes[i - 1]);
                c = keysPressed.charAt(i);
            }
        }
        return c;
    }
}