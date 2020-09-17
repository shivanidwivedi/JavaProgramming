package leetcode.Trees;

import java.util.*;

/**
 * @author shivanidwivedi on 17/09/20
 * @project JavaProgramming
 */
public class SerializeDeserializeNAryTree {
    public String serialize(NAryNode root) {
        if(root == null) return "";
        StringBuilder sb = new StringBuilder();
        dfs(sb, root);
        return sb.toString();
    }

    public void dfs(StringBuilder sb, NAryNode root){
        if(root == null) return;
        sb.append(root.val+ " ");
        for(NAryNode node : root.children){
            dfs(sb, node);
        }
        sb.append("X ");
    }

    public NAryNode deserialize(String data) {
        if(data.length() == 0) return null;
        Queue<String> q = new LinkedList<>(Arrays.asList(data.split(" ")));
        return helper(q);
    }

    private NAryNode helper(Queue<String> queue){
        String current = queue.poll();
        if(current.equals("X")) return null;

        NAryNode node = new NAryNode(Integer.valueOf(current), new ArrayList<>());
        while(!queue.isEmpty() && !queue.peek().equals("X")){
            node.children.add(helper(queue));
        }
        queue.poll();
        return node;
    }
}

class NAryNode{
    public int val;
    List<NAryNode> children;
    NAryNode(int val, List<NAryNode> children){
        this.val = val;
        this.children = children;
    }
}