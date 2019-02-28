import java.io.IOException;

public class Main {
    public static final String FOLDER ="C:\\Users\\Constantin\\IdeaProjects\\ForHashCode\\PictureData";
    private static final String FILENAME1= FOLDER+"\\a_example.in";
    private static final String FILENAME2= FOLDER+"\\b_small.in";
    private static final String FILENAME3= FOLDER+"\\c_medium.in";
    private static final String FILENAME4= FOLDER+"\\d_big.in";

    private static final String FILENAME_1=FOLDER+"\\a_example.txt";


    public static void main(String[] args) {

        try {
            PictureDataset pictureDataset=new PictureDataset(FILENAME_1);
            System.out.println(pictureDataset.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
