import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    //private final SlideShowMaker slideShowMaker=new SlideShowMaker();


    public static final String FOLDER ="C:\\Users\\Constantin\\IdeaProjects\\ForHashCode\\PictureData";

    private static final String FILENAME_1=FOLDER+"\\a_example.txt";
    private static final String RESULT=FOLDER+"\\result.txt";


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
