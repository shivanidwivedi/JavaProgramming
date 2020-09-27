package google.kickstart;

import java.util.*;

/**
 * @author shivanidwivedi on 26/09/20
 * @project JavaProgramming
 */
public class ATMQueue {

    public static List<Turn> exitOrder(int[] requiredAmount, int maxAmount) {
        List<Turn> turns = initializeTurns(requiredAmount, maxAmount);
        Collections.sort(turns);
        return turns;
    }

    private static List<Turn> initializeTurns(int[] requiredAmount, int max) {
        List<Turn> turns = new ArrayList<>();
        int seq = 1;
        for(int amt : requiredAmount) {
            turns.add(new Turn(seq++, amt, max));
        }
        return turns;
    }


    private static String print(List<Turn> turns) {
        StringBuilder out = new StringBuilder();

        for(Turn turn : turns) {
            out .append(turn.sequence+" ");
        }
        return out.toString();
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        for(int i=1; i<=count; i++) {
            int size = in.nextInt();
            int budget = in.nextInt();
            int[] arr = new int[size];
            for(int j=0; j<size; j++) {
                arr[j] = in.nextInt();
            }
           // System.out.println("Case #"+i+": "+exitOrder(arr,budget).stforEach(nb -> System.out.print(nb + " "));exitOrder(size,budget,arr));
            System.out.println("Case #"+i+": "+print(exitOrder(arr, budget)));
        }
    }
}

class Turn implements Comparable<Turn>{
    int sequence;
    int amountToWithdraw;

    public Turn(int sequence, int amount, int max) {
        this.sequence = sequence;
        this.amountToWithdraw = ceilAmount(max, amount);
    }

    @Override
    public int compareTo(Turn o) {
        if(this.amountToWithdraw == o.amountToWithdraw) {
            return 0;
        } else if (this.amountToWithdraw > o.amountToWithdraw) {
            return 1;
        } else {
            return -1;
        }
    }

    public int ceilAmount(int max, int amount) {
        int amt = amount;
        if(amount % max != 0) {
            amt = ((amount / max) + 1)*max;
        }
        return amt;
    }
}