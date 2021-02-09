package leetcode;

import java.util.*;

/**
 * @author shivanidwivedi on 09/02/21
 * @project JavaProgramming
 *
 * Given a list accounts, each element accounts[i] is a list of strings,
 * where the first element accounts[i][0] is a name,
 * and the rest of the elements are emails representing emails of the account.
 *
 * Now, we would like to merge these accounts.
 * Two accounts definitely belong to the same person if there is some email that is common to both accounts.
 * Note that even if two accounts have the same name,
 * they may belong to different people as people could have the same name.
 * A person can have any number of accounts initially, but all of their accounts definitely have the same name.
 *
 * After merging the accounts, return the accounts in the following format: the first element of each account
 * is the name, and the rest of the elements are emails in sorted order.
 * The accounts themselves can be returned in any order.
 *
 * Example 1:
 * Input:
 * accounts = [["John", "johnsmith@mail.com", "john00@mail.com"], ["John", "johnnybravo@mail.com"],
 * ["John", "johnsmith@mail.com", "john_newyork@mail.com"], ["Mary", "mary@mail.com"]]
 * Output: [["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com'],
 * ["John", "johnnybravo@mail.com"], ["Mary", "mary@mail.com"]]
 * Explanation:
 * The first and third John's are the same person as they have the common email "johnsmith@mail.com".
 * The second John and Mary are different people as none of their email addresses are used by other accounts.
 * We could return these lists in any order,
 * for example the answer [['Mary', 'mary@mail.com'], ['John', 'johnnybravo@mail.com'],
 * ['John', 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com']] would still be accepted.
 *
 * Time Complexity: O(AlogA), where A = ∑ai, and ai is the length of accounts[i]
 * If we used union-by-rank, this complexity improves to O(Aα(A))≈O(A), where α is the Inverse-Ackermann function.
 *
 * Space Complexity: O(A), the space used by our DSU structure.
 */
public class AccountsMerge {

    //Union Find algo
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        DSU dsu = new DSU();
        Map<String, String> emailToName = new HashMap<>(); //
        Map<String, Integer> emailToId = new HashMap<>();
        int id = 0;

        for(List<String> account : accounts){
            String name = "";
            for(String email : account){
                if(name == ""){
                    name = email;
                    continue;
                }
                emailToName.put(email, name);
                if(!emailToId.containsKey(email)){
                    emailToId.put(email, id++);
                }
                dsu.union(emailToId.get(account.get(1)), emailToId.get(email));
            }
        }

        Map<Integer, List<String>> result = new HashMap<>();
        for(String email : emailToName.keySet()){
            int index = dsu.find(emailToId.get(email));
            if(!result.containsKey(index)){
                result.put(index, new ArrayList());
            }
            result.get(index).add(email);
        }

        for(List<String> component : result.values()){
            Collections.sort(component);
            component.add(0, emailToName.get(component.get(0)));
        }
        return new ArrayList(result.values());
    }

    public static void main(String[] args) {
        AccountsMerge accountsMergeObj = new AccountsMerge();
        List<List<String>> accounts = new ArrayList<>();
        accounts = accountsMergeObj.createInput();
        System.out.println(accountsMergeObj.accountsMerge(accounts));
    }

    private List<List<String>> createInput(){
        List<List<String>> input = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        temp.add("John");
        temp.add("johnsmith@mail.com");
        temp.add("john00@mail.com");
        input.add(temp);
        List<String> temp1 = new ArrayList<>();
        temp1.add("John");
        temp1.add("johnnybravo@mail.com");
        input.add(temp1);
        List<String> temp2 = new ArrayList<>();
        temp2.add("John");
        temp2.add("johnsmith@mail.com");
        temp2.add("john_newyork@mail.com");
        input.add(temp2);
        List<String> temp3 = new ArrayList<>();
        temp3.add("Mary");
        temp3.add("mary@mail.com");
        input.add(temp3);
        return input;
    }
}

class DSU{
    int[] parent;
    public DSU() {
        parent = new int[10001];
        for (int i = 0; i <= 10000; ++i)
            parent[i] = i;
    }
    public int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }
    public void union(int x, int y) {
        parent[find(x)] = find(y);
    }
}
