import java.util.ArrayList;

public class SimpleSlideshowGenerator {


    public static ArrayList<Slide> generateSimple(final ArrayList<Picture> pictures){
        ArrayList<Picture> horizontalPics=new ArrayList<>();
        ArrayList<Picture> verticalPics=new ArrayList<>();

        for(final Picture p:pictures){
            if(p.format==Picture.HORIZONTAL){
                horizontalPics.add(p);
            }else{
                verticalPics.add(p);
            }
        }
        //Horizontal we only need one
        //Vertical 2
        ArrayList<Slide> slides=new ArrayList<>();
        for(final Picture p:horizontalPics){
            slides.add(new Slide(p));
        }
        for(int i=0;i<verticalPics.size()-1;i+=2){
            slides.add(new Slide(verticalPics.get(i),verticalPics.get(i+1)));
        }
        return slides;
    }
}
