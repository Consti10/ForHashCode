import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    //private final SlideShowMaker slideShowMaker=new SlideShowMaker();

    private static final String FILENAME_1=".\\PictureData\\a_example.txt";
    private static final String FILENAME_2=".\\PictureData\\b_lovely_landscapes.txt";

    private static final String RESULT=".\\PictureData\\result.txt";


    private static final String[] FILENAMES_INPUT={
            "a_example",
            "b_lovely_landscapes",
            "c_memorable_moments",
            "d_pet_pictures",
            "e_shiny_selfies"
    };


    public static void main(String[] args) {
        try {
            for(final String INPUT:FILENAMES_INPUT){
                GenerateData(".\\PictureData\\"+INPUT+".txt",".\\PictureData\\"+"SOLUTION_"+INPUT+".txt");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
    public static void GenerateData(final String inputFilename,final String outputFilename) throws IOException {

        PictureDataset pictureDataset=new PictureDataset(inputFilename);
        System.out.println(pictureDataset.toString());

        ArrayList<Slide> slides=pictureDataset.genSlides();
        final SlideShowMaker slideShowMaker=new SlideShowMaker();

        //ArrayList<Slide> optimizedSlides=slideShowMaker.buildSlideShow(slides);
        ArrayList<Slide> optimizedSlides=SimpleSlideshowGenerator.generateSimple(pictureDataset.pictures);

        for(final Slide s:optimizedSlides){
            System.out.println(s.toString());
        }
        //now store our results
        PictureDataset.CreateOutputFile(outputFilename,optimizedSlides);
    }
}
