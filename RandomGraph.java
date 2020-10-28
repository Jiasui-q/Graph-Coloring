package HW3;
import java.util.ArrayList;
import java.util.Random;

public class RandomGraph {
    private int vertices;
    private double prob;
    public ArrayList<ArrayList<Integer>> nodes;
    private Random rand;

     public static void main(String []args){
        RandomGraph graph = new RandomGraph(10, 0.2);
        graph.printGraph(graph.nodes);
     }

    public RandomGraph(int vertices, double prob){     
        this.vertices = vertices;
        this.prob = prob;
        nodes = new ArrayList<ArrayList<Integer>> ();
        for(int i = 0; i < vertices; i++){
            nodes.add(new ArrayList<Integer>());
        }
        rand = new Random();
        generate();
    }

    // generate the adjacency list
    private void generate(){
        for(int i = 0; i < vertices-1; i++){
            for(int j = i+1; j < vertices; j++){
                if(rand.nextDouble() < prob){
                    nodes.get(i).add(j); 
                    nodes.get(j).add(i);
                }
            }
        }
    }

    public void printGraph(ArrayList<ArrayList<Integer>> nodes) { 
        for (int i = 0; i < nodes.size(); i++) { 
            System.out.print("Adjacency list of vertex " + i); 
            for (int j = 0; j < nodes.get(i).size(); j++) { 
                System.out.print(" -> "+nodes.get(i).get(j)); 
            } 
            System.out.println(); 
        } 
    }
}