class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        int shift = 0;
        StringBuilder ans = new StringBuilder();
        int index;
        for (int i : shifts) {
            shift = (shift + i) % 26;
        }
        
        for (int i =0; i < s.length(); i++) {
            index = s.charAt(i) - 'a';
            ans.append((char)((index + shift) % 26 + 97));
            shift = Math.floorMod(shift - shifts[i], 26);
        }
        
        return ans.toString();
    }
}