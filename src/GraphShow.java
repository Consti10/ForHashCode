import java.util.ArrayList;
import java.util.List;

public class GraphShow {

    public static ArrayList<Slide> buildGraphShow(List<Slide> eingabe){
        int[][] edgeValues = new int[eingabe.size()][eingabe.size()]; //only need upper triangle matrix
        for (int i = 0; i < edgeValues.length; i++) {
            for (int j = 0; j < edgeValues.length; j++) {
                edgeValues[i][j] = SlideShowMaker.calculateScore(eingabe.get(i), eingabe.get(j));
            }
        }

        ArrayList<Slide> output = new ArrayList<>(eingabe.size());
        output.set(0,eingabe.get(0)); //just start randomly
        for (int i = 1; i < eingabe.size(); i++) { //follow the maximal edge from there
            int max = -1;
            int maxpos = -1;
            for (int j = 0; j < eingabe.size(); j++) { //look through all destinations
                if (edgeValues[i][j] > max){
                    max = edgeValues[i][j];
                    maxpos = j;
                }
            }
            for (int j = 0; j < eingabe.size(); j++) {
                edgeValues[j][maxpos] = -1;  //after we use an edge we set the value of all edges leading to it to -1 so it won't be used again
                edgeValues[j][i] = -1; //when leaving an edge, set all connections to it to -1
            }
            output.set(i, eingabe.get(maxpos));
        }
        return output;
    }

}
