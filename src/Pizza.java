import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

@SuppressWarnings("WeakerAccess")
public class Pizza {
    //Variable names follow the definitions in the Problem Statement
    final int R;
    final int C;
    final int L;
    final int H;
    final char[][] toppings;

    static final char TOMATO='T';
    static final char MUSHROOM='M';

    static final String OUTPUT_FILENAME=Main.FOLDER+"\\result.txt";

    //Construct a pizza from input file
    public Pizza(final String filename) throws IOException {
        try(BufferedReader br = new BufferedReader(new FileReader(filename))) {
            final String firstLine=br.readLine();
            assert firstLine != null;
            final String[] tmp=firstLine.split(" ");
            assert tmp.length==4;
            R=Integer.parseInt(tmp[0]);
            C=Integer.parseInt(tmp[1]);
            L=Integer.parseInt(tmp[2]);
            H=Integer.parseInt(tmp[3]);
            toppings =new char[R][C];
            for(int i=0;i<R;i++){
                final String line=br.readLine();
                assert line!=null;
                for(int j=0;j<line.length();j++){
                    final char c=line.charAt(j);
                    toppings[i][j]=c;
                }
            }
        }
    }


    //Implemented the solution from this video https://www.youtube.com/watch?v=gXSUKdf7_GE in java
    public void sliceSimple(){

        ArrayList<Slice> validSlices=new ArrayList<>();
        for(int row=0;row<R;row++){
            int beg=0,end=0;
            int mushroom_count=0;
            int tomato_count=0;
            while(end<C){
                if(toppings[row][end]==MUSHROOM)
                    mushroom_count++;
                else if(toppings[row][end]==TOMATO)
                    tomato_count++;
                end+=1;

                if(end-beg>H){
                    if(toppings[row][beg]==MUSHROOM)
                        mushroom_count--;
                    else if(toppings[row][beg]==TOMATO)
                        tomato_count--;
                    beg++;
                }
                //System.out.println("TC"+tomato_count+"MC"+mushroom_count);
                if(end-beg<=H && mushroom_count>=L && tomato_count>=L){
                    validSlices.add(new Slice(row,beg,row,end-1));
                    beg=end;
                    tomato_count=0;
                    mushroom_count=0;
                }
            }
        }
        Slice.writeOutputFile(OUTPUT_FILENAME,validSlices);

        for(final Slice slice:validSlices){
            System.out.println(slice.toString());
        }
    }


    @Override
    public String toString(){
        StringBuilder builder=new StringBuilder();
        builder.append("R=").append(R).append(" C=").append(C).append(" L=").append(L).append(" H=").append(H).append("\n");
        for(int row=0;row<R;row++){
            for(int col=0;col<C;col++){
                builder.append(toppings[row][col]);
            }
            builder.append("\n");
        }
        return builder.toString();
    }
}
