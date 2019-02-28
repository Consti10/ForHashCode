import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class VerticalPhotoUnification {


    /**
     * Naively creates Slides from all vertical Photos based on the heuristic more tags => better.
     * joins pictures with the least tags to those with the most tags.
     * @param list
     * @return
     */
    public List<Slide> naiveUnify(List<Picture> list){
        List<Picture> downlist = new ArrayList<>(list);
        downlist.sort(Comparator.comparing(Picture::getLength));
        if (downlist.size() % 2 == 1) downlist.remove(0);//odd lists are a problem: drop one with least number of tags
        List<Picture> uplist = new ArrayList<>(downlist);
        Collections.reverse(uplist);
        List<Slide> res = new ArrayList<>(downlist.size());
        for (int i = 0; i < downlist.size(); i++) {
            List<String> slideTags = new ArrayList<>(uplist.get(i).tags.size()+downlist.get(i).tags.size());
            slideTags.addAll(uplist.get(i).tags);
            slideTags.addAll(downlist.get(i).tags);
            res.add(i, new Slide(slideTags));
        }
        return res;
    }


}
