package leetcode;

import java.util.*;

/**
 * @author shivanidwivedi on 06/08/20
 * @project JavaProgramming
 * Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct the itinerary in order.
 * All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.
 *
 * Note:
 *
 * If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string.
 * For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
 * All airports are represented by three capital letters (IATA code).
 * You may assume all tickets form at least one valid itinerary.
 * One must use all the tickets once and only once.
 * Example 1:
 *
 * Input: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
 * Output: ["JFK", "MUC", "LHR", "SFO", "SJC"]
 * Example 2:
 *
 * Input: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
 * Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
 * Explanation: Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"].
 *              But it is larger in lexical order.
 */
public class ReconstructItinerary {
    List<String> result = new ArrayList<>();
    HashMap<String, List<String>> graph = new HashMap<>();
    int totalTickets;
    public List<String> findItinerary(List<List<String>> tickets) {
        if(tickets == null || tickets.size() == 0){
            return result;
        }
        totalTickets = tickets.size();
        for (List<String> ticket : tickets){
            if (!graph.containsKey(ticket.get(0))){
                graph.put(ticket.get(0), new ArrayList<>());
            }else {
                List<String> list = graph.get(ticket.get(0));
                list.add(ticket.get(1));
            }
        }
        for (Map.Entry<String, List<String>> entry : graph.entrySet()){
            Collections.sort(graph.get(entry.getValue()));
        }
        result.add("JFK");
        dfs("JFK");
        return result;
    }

    private void dfs(String current){
        if(!graph.containsKey(current)) return;
        List<String> list = graph.get(current);
        for(int i = 0; i < list.size(); i++){
            String dest = list.get(i);
            list.remove(i);
            result.add(dest);
            dfs(dest);
            if(result.size() == totalTickets + 1){
                return;
            }
            list.add(i, dest);
            result.remove(result.size()-1);
        }
    }

}
