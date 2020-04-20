package codechef;

import java.util.Scanner;

/**
 * @author shivanidwivedi on 20/04/20
 * @project JavaProgramming
 */
public class LiftMe {
    public static int totalFloorsTravelled(int numberOfFloors, int[][] requests){
        int totalfloors = 0;
        if (requests[0][0] <=numberOfFloors && requests[0][1] <=numberOfFloors && requests[0][0] >= 0 && requests[0][1] >= 0) {
        totalfloors = Math.abs(requests[0][0] - requests[0][1]);
        } else return 0;

        int extrafloors = 0;
        for (int i = 1; i < requests.length; i++){
            if (requests[i][0] <= numberOfFloors && requests[i][1] <= numberOfFloors && requests[i-1][1] <= numberOfFloors && requests[i][0] >= 0 && requests[i][1] >= 0 ) {
                totalfloors += Math.abs(requests[i][0] - requests[i][1]);
                extrafloors = Math.abs(requests[i - 1][1] - requests[i][0]);
                totalfloors += extrafloors;
            }
        }
        totalfloors += requests[0][0];
        return totalfloors;
    }
    /*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tests = sc.nextInt();
        int[][] testCases = new int[tests][];
        for (int i = 0; i < tests; i++) { //number of test cases
            int totalFloors = sc.nextInt();
            int totalRequests = sc.nextInt();
            int[][] requests = new int[totalRequests][2];
            for (int j = 0; j < totalRequests; j++) {
                requests[j][0] = sc.nextInt(); //from
                requests[j][1] = sc.nextInt(); //to
            }
            System.out.println(totalFloorsTravelled(totalFloors, requests));
        }
    }*/
}