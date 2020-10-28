import java.util.ArrayList;
import java.util.Arrays;
import HW3.RandomGraph;

public class coloring {
    private RandomGraph graph;
    private ArrayList<ArrayList<Integer>> nodes;
    private int[] result;
    private boolean[] colors;
    private int v;
    public int max;

    public static void main(String []args){
        double p= 0.002;
        int avg = 0;
        for(int i = 0; i < 100; i++){
            coloring g = new coloring(1000, p);
            avg += g.max;
        }
        System.out.println("p = " + p + ", # of colors: "+avg/100);
    }

    public coloring(int vertices, double prob){     
        graph = new RandomGraph(vertices, prob);
        nodes = graph.nodes;
        v = vertices;
        max = 0;
        result = new int[v];
        colors = new boolean[v];
        Arrays.fill(result, -1);
        Arrays.fill(colors, true);
        compute();
    }

    private void compute(){
        result[0] = 0;
        for(int i = 1; i < v; i++){
            for(int adjacent: nodes.get(i)){
                if(result[adjacent] != -1){
                    colors[result[adjacent]] = false;
                }
            }
            
            for(int c = 0; c < v; c++){
                if(colors[c]){
                    result[i]=c;
                    max = Math.max(c, max);
                    break;
                }
            }
            Arrays.fill(colors, true);
        }
    }
}
