package leetcode.contest;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shivanidwivedi on 22/08/20
 * @project JavaProgramming
 */
public class MostVisitedSectorInCircularTrack {
    public static List<Integer> mostVisited(int totalSectors, int[] rounds) {
        List<Integer> mostVisited;
        int[] sectorCount = new int[totalSectors]; //count of each sector visit
        int startRound = rounds[0];
        int endRound = 0;

        //sector visit count
        for (int currSectorIndex = 1; currSectorIndex < rounds.length; currSectorIndex++) {
            endRound = rounds[currSectorIndex];
            updateSectorsVisits(startRound, endRound, totalSectors, sectorCount);
            startRound = endRound+1;
        }

        //find max visited sector by eliminating other sectors
        mostVisited = findMaxVisitedSector(sectorCount, totalSectors);


        return mostVisited;

    }

    /**
     * * [4, 5] -> [2]
     * [1, 1, 1, 1, 1, 1, 1] -> [1,2,3,4,5,6,7]
     *
     * @param sectorCount: [2,2,1,1], index 0 is 1st sector, n-1 is nth sector
     * @param n
     * @return
     */
    private static List<Integer> findMaxVisitedSector(int[] sectorCount, int n) {

        int[] sorted = new int[n]; //max array size
        List<Integer> output = new ArrayList<>(); //should contain sector# with max count
        int round = 0;
        // Build the output character array
        // To make it stable we are operating in reverse order.
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < sectorCount.length; i++) {
            if (sectorCount[i] > max) {
                max = sectorCount[i];
            }
        }

        for (int i = 0; i < sectorCount.length; i++) {
            if (sectorCount[i] == max) {
                output.add(i + 1);
            }
        }


        return output;
    }

    /**
     * update visit count for each marathon
     * @param start start track for a given marathon
     * @param end end track for a given marathon
     * @param max total tracks
     * @param sectorCount array to update
     */
    private static void updateSectorsVisits(int start, int end, int max, int[] sectorCount) {
        if (end < start) {
            for (int i = start; i <= max; i++) {
                sectorCount[i - 1] += 1;
            }
            for (int i = 1; i <= end; i++) {
                sectorCount[i - 1] += 1;
            }

        } else if (end > start) {
            for (int i = start; i <= end; i++) {
                sectorCount[i - 1] += 1;
            }
        } else {
            sectorCount[end - 1] += 1;
        }
    }

    public static void main(String[] args) {
        // Assert.assertEquals();
        System.out.println(mostVisited(4, new int[]{1, 3, 1, 2}));
        System.out.println(mostVisited(2, new int[]{2, 1, 2, 1, 2, 1, 2, 1, 2}));
        System.out.println(mostVisited(7, new int[]{1, 3, 5, 7}));
    }
}
