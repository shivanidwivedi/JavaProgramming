package leetcode;

/**
 * @author shivanidwivedi on 17/04/20
 * @project JavaProgramming
 * There is a robot starting at position (0, 0), the origin, on a 2D plane. Given a sequence of its moves, judge if this robot ends up at (0, 0) after it completes its moves.
 *
 * The move sequence is represented by a string, and the character moves[i] represents its ith move. Valid moves are R (right), L (left), U (up), and D (down). If the robot returns to the origin after it finishes all of its moves, return true. Otherwise, return false.
 *
 * Note: The way that the robot is "facing" is irrelevant. "R" will always make the robot move to the right once, "L" will always make it move left, etc. Also, assume that the magnitude of the robot's movement is the same for each move.
 *
 * Example 1:
 *
 * Input: "UD"
 * Output: true
 * Explanation: The robot moves up once, and then down once. All moves have the same magnitude, so it ended up at the origin where it started. Therefore, we return true.
 *
 *
 * Example 2:
 *
 * Input: "LL"
 * Output: false
 * Explanation: The robot moves left twice. It ends up two "moves" to the left of the origin. We return false because it is not at the origin at the end of its moves.
 */
//Time Complexity: O(N), where N is the length of moves. We iterate through the string.
//Space Complexity: O(1). In Java, our character array is O(N).
public class RobotCircle {
    public static boolean judgeCircle(String moves) {
        if ((moves.length() % 2) == 1){
            return false;
        }
        int hori = 0, vert = 0;
        for (int i = 0; i < moves.length(); i++){
            hori += moves.charAt(i) == 'R' ? 1 : moves.charAt(i) == 'L' ? -1 : 0;
            vert += moves.charAt(i) == 'U' ? 1 : moves.charAt(i) == 'D' ? -1 : 0;;
        }
        if (hori == 0 && vert == 0){
            return true;
        }
        return false;
    }

    /**
     * Method-2:
     */
    public static boolean judgeCircleAnother(String moves) {
        if ((moves.length() % 2) == 1){
            return false;
        }
        int hori = 0, vert = 0;
        for (int i = 0; i < moves.length(); i++){
            if (moves.charAt(i) == 'L') hori--;
            if (moves.charAt(i) == 'R') hori++;
            if (moves.charAt(i) == 'U') vert++;
            if (moves.charAt(i) == 'D') vert--;
        }
        if (hori == 0 && vert == 0){
            return true;
        }
        return false;
    }
}




















