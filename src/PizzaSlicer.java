import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class PizzaSlicer {

    private final Pizza pizza;

    public PizzaSlicer(final String name) throws IOException {
        pizza=new Pizza(name);
        System.out.println(pizza.toString());
        pizza.sliceSimple();
    }







}
