import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

@SuppressWarnings("WeakerAccess")
public class Slice {

    final int r1,c1,r2,c2;

    Slice(int r1,int c1,int r2,int c2){
        this.r1=r1;
        this.c1=c1;
        this.r2=r2;
        this.c2=c2;
    }

    //as human readable sting
    @Override
    public String toString(){
        //return "r1="+r1+" c1="+c1+" r2="+r2+" c2="+c2;
        return r1+" "+c1+" "+r2+" "+c2;
    }


    public static void writeOutputFile(final String filename,final ArrayList<Slice> validSLices){
        StringBuilder builder=new StringBuilder();
        //write the first line containing number of lsices
        builder.append(validSLices.size()).append("\n");
        for(final Slice slice: validSLices){
            builder.append(slice.toString()).append("\n");
        }
        try {
            Files.write(Paths.get(filename), builder.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
