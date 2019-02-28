import java.io.IOException;

public class Main {
    public static final String FOLDER ="C:\\Users\\Constantin\\IdeaProjects\\ForHashCode\\ExampleProblemData";
    private static final String FILENAME1= FOLDER+"\\a_example.in";
    private static final String FILENAME2= FOLDER+"\\b_small.in";
    private static final String FILENAME3= FOLDER+"\\c_medium.in";
    private static final String FILENAME4= FOLDER+"\\d_big.in";


    public static void main(String[] args) {


        try {
            PizzaSlicer pizzaSlicer=new PizzaSlicer(FILENAME4);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
