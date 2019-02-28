import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    //private final SlideShowMaker slideShowMaker=new SlideShowMaker();

    private static final String FILENAME_1=".\\PictureData\\a_example.txt";
    private static final String RESULT=".\\PictureData\\result.txt";


    public static void main(String[] args) {

        try {
            PictureDataset pictureDataset=new PictureDataset(FILENAME_1);
            System.out.println(pictureDataset.toString());

            ArrayList<Slide> slides=pictureDataset.genSlides();
            final SlideShowMaker slideShowMaker=new SlideShowMaker();

            ArrayList<Slide> optimizedSlides=slideShowMaker.buildSlideShow(slides);

            for(final Slide s:optimizedSlides){
                System.out.println(s.toString());
            }
            //now store our results
            PictureDataset.CreateOutputFile(RESULT,optimizedSlides);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
