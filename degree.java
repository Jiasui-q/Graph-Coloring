import java.util.ArrayList;
import java.util.HashMap;
import HW3.RandomGraph;

public class degree {
    private RandomGraph graph;
    public HashMap<Integer, Integer> count;

    public static void main(String []args){
        degree g = new degree(1000, 0.002);
    }

    public degree(int vertices, double prob){     
        graph = new RandomGraph(vertices, prob);
        count = new HashMap<>();
        System.out.println("n: "+vertices+", p: "+prob);
        compute();
        for(int i: count.keySet()){
            System.out.println("degree "+i+": "+count.get(i));
        }
    }

    private void compute(){
        for(ArrayList<Integer> arr: graph.nodes){
            int degree = arr.size();
            if(!count.containsKey(degree)){
                count.put(degree,1);
            }else{
                int c = count.get(degree)+1;
                count.put(degree,c);
            }
        }
    }
}
