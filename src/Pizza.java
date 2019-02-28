import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@SuppressWarnings("WeakerAccess")
public class Pizza {
    final int R;
    final int C;
    final int L;
    final int H;
    final char[][] toppings;

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
