import java.io.IOException;
import java.util.List;

public class Main {


    public static final String FOLDER ="C:\\Users\\Constantin\\IdeaProjects\\ForHashCode\\PictureData";

    private static final String FILENAME_1=FOLDER+"\\a_example.txt";


    public static void main(String[] args) {

        try {
            PictureDataset pictureDataset=new PictureDataset(FILENAME_1);
            System.out.println(pictureDataset.toString());

            List<Slide> slides=pictureDataset.genSlides();
            for(final Slide s:slides){
                System.out.println(slides.toString());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
