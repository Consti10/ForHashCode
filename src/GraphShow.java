import java.util.ArrayList;
import java.util.List;

public class GraphShow {

    public List<Slide> buildGraphShow(List<Slide> eingabe){
        int[][] edgeValues = new int[eingabe.size()][eingabe.size()]; //only need upper triangle matrix
        for (int i = 0; i < edgeValues.length; i++) {
            for (int j = 0; j < edgeValues.length; j++) {
                edgeValues[i][j] = SlideShowMaker.calculateScore(eingabe.get(i), eingabe.get(j));
            }
        }

        List<Slide> output = new ArrayList<>(eingabe.size());
        for (int i = 0; i < eingabe.size(); i++) {

        }

    }

}
