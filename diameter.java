import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeSet;

import HW3.RandomGraph;

public class diameter {
    public RandomGraph graph;
    public ArrayList<ArrayList<Integer>> nodes;
    private boolean ifFinite;

    public static void main(String []args){
        diameter g = new diameter(10000, 0.0003);
        //g.graph.printGraph(g.graph.nodes);
    }

    public diameter(int vertices, double prob){     
        graph = new RandomGraph(vertices, prob);
        nodes = graph.nodes;
        ifFinite = false;
        System.out.println("n: "+vertices+", p: "+prob);
        compute();
    }

    // compute and print the diameter
    private void compute(){
        int max = 0;
        for(int start = 0; start < nodes.size(); start++){
            TreeSet<Integer> seen = new TreeSet<>();
            Queue<Integer> q = new LinkedList<>();
            int length = -1;
            q.add(start);
            seen.add(start);
            while(!q.isEmpty()) {
                int currSize = q.size();
                for(int i = 0; i < currSize; i++){
                    int n = q.remove();
                    for (int v: nodes.get(n)){
                        if(!seen.contains(v)){
                            q.add(v);
                            seen.add(v);
                        }
                    }
                }
                length++;
            }
            if(seen.size() != nodes.size()){
                ifFinite = true;
            }
            max = Math.max(length, max);
        }
        if(ifFinite){
            System.out.print("Finite diamater: ");
        }else {
            System.out.print("Diamater: ");
        }
        System.out.print(max);
        System.out.println();
    }
}
