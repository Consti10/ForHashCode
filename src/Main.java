import java.io.IOException;

public class Main {
    public static final String FOLDER ="C:\\Users\\Constantin\\IdeaProjects\\ForHashCode\\ExampleProblemData";
    private static final String FILENAME1= FOLDER+"\\a_example.in";
    private static final String FILENAME2= FOLDER+"\\b_small.in";

    public static void main(String[] args) {


        try {
            PizzaSlicer pizzaSlicer=new PizzaSlicer(FILENAME1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
