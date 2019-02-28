import java.io.IOException;

public class Main {
    private static final String FOLDER ="C:\\Users\\Constantin\\IdeaProjects\\ForHashCode\\ExampleProblemData";
    private static final String FILENAME= FOLDER+"\\a_example.in";

    public static void main(String[] args) {


        try {
            PizzaSlicer pizzaSlicer=new PizzaSlicer(FILENAME);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
