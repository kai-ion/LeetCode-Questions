/*
You are given several boxes with different colors represented by different positive numbers.

You may experience several rounds to remove boxes until there is no box left. Each time you can choose some continuous boxes with the same color (i.e., composed of k boxes, k >= 1), remove them and get k * k points.

Return the maximum points you can get.
*/
import java.util.*;
public class RemoveBoxes {
    public static int removeBoxes(int[] boxes) {
        int points = 0;
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for (int i = 0; i < boxes.length; i++) {
            if (!map.containsKey(boxes[i])) {
                map.put(boxes[i], 1);
            }
            else {
                map.put(boxes[i], map.get(boxes[i]) + 1);
            }
        }
        
        for (Map.Entry<Integer,Integer> entry : map.entrySet())
            points += entry.getValue() * entry.getValue();
        
        return points;
    }

    public static void main(String[] args) {
        int[] x = {1,3,2,2,2,3,4,3,1}; //Ans = 23
        int[] y = {1,2,1,2,1}; //Ans = 11
        //System.out.println(removeBoxes(x));
        System.out.println(removeBoxes(y));
    }
}
