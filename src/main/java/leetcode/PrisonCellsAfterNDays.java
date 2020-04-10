package leetcode;

import java.util.Arrays;

/**
 * @author shivanidwivedi on 09/04/20
 * @project JavaProgramming
 * There are 8 prison cells in a row, and each cell is either occupied or vacant.
 *
 * Each day, whether the cell is occupied or vacant changes according to the following rules:
 *
 * If a cell has two adjacent neighbors that are both occupied or both vacant, then the cell becomes occupied.
 * Otherwise, it becomes vacant.
 * (Note that because the prison is a row, the first and the last cells in the row can't have two adjacent neighbors.)
 *
 * We describe the current state of the prison in the following way: cells[i] == 1 if the i-th cell is occupied, else cells[i] == 0.
 *
 * Given the initial state of the prison, return the state of the prison after N days (and N such changes described above.)
 *
 *
 *
 * Example 1:
 *
 * Input: cells = [0,1,0,1,1,0,0,1], N = 7
 * Output: [0,0,1,1,0,0,0,0]
 * Explanation:
 * The following table summarizes the state of the prison on each day:
 * Day 0: [0, 1, 0, 1, 1, 0, 0, 1]
 * Day 1: [0, 1, 1, 0, 0, 0, 0, 0]
 * Day 2: [0, 0, 0, 0, 1, 1, 1, 0]
 * Day 3: [0, 1, 1, 0, 0, 1, 0, 0]
 * Day 4: [0, 0, 0, 0, 0, 1, 0, 0]
 * Day 5: [0, 1, 1, 1, 0, 1, 0, 0]
 * Day 6: [0, 0, 1, 0, 1, 1, 0, 0]
 * Day 7: [0, 0, 1, 1, 0, 0, 0, 0]
 *
 * Example 2:
 *
 * Input: cells = [1,0,0,1,0,0,1,0], N = 1000000000
 * Output: [0,0,1,1,1,1,1,0]
 */
public class PrisonCellsAfterNDays {
    public static int[] prisonAfterNDays(int[] cells, int N) {
        if (N==0){
            return cells;
        }
        int cellslength = cells.length;
        cells = changeCells(cells,cellslength);
        if (N == 1){
            return cells;
        }
        N--;
        boolean repeat = false;
        int cycle = 0;
        int[] next = cells;
        while(!repeat && N != 0){
            next = changeCells(next, cellslength);
            N--;
            repeat = Arrays.equals(cells, next);
            cycle++;
        }
        if (N == 0){
            return next;
        }
        N = N % cycle;
        while(N!=0){
            next = changeCells(next, cellslength);
            N--;
        }
        return next;
    }
    static int[] changeCells(int[] prev, int cellslength){
        int next[] = new int[cellslength];
        next[0] = 0;
        next[cellslength - 1] = 0;
        for (int i = 1; i < cellslength -1; i++){
            next[i] = prev[i-1] == prev[i+1] ? 1 : 0;
        }
        return next;
    }
}
