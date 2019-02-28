import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

@SuppressWarnings("WeakerAccess")
public class PictureDataset {


    ArrayList<Picture> pictures=new ArrayList<>();
    final int nPictures;


    PictureDataset(final String filename) throws IOException {
        try(BufferedReader br = new BufferedReader(new FileReader(filename))) {
            final String firstLine=br.readLine();
            assert firstLine != null;
            nPictures=Integer.parseInt(firstLine);
            for(int i=0;i<nPictures;i++){
                final String line=br.readLine();
                assert line!=null;
                final String[] tmp=line.split(" ");
                final char format=tmp[0].charAt(0);
                final int nTags=Integer.parseInt(tmp[1]);
                //rest are tags
                assert nTags==tmp.length-2;
                final String[] tags=new String[nTags];
                for(int t=0;t<nTags;t++){
                    tags[t]=tmp[t+2];
                }
                pictures.add(new Picture(format,tags));
            }
        }
    }

    //For testing/ debugging
    @Override
    public String toString(){
        StringBuilder builder=new StringBuilder();
        for(final Picture picture:pictures){
            builder.append(picture.toString());
            builder.append("\n");
        }
        return builder.toString();
    }

}
