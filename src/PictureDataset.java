import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

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
                pictures.add(new Picture(format,tags,i));
            }
        }
    }

    public ArrayList<Slide> genSlides() {
        ArrayList<Picture> vpics = new ArrayList();
        ArrayList<Slide> slides = new ArrayList<>();
        for (Picture picture : pictures) {
            if (picture.format == 'V') {
                vpics.add(picture);
            } else {
                slides.add(new Slide(picture));
            }
        }
        slides.addAll(VerticalPhotoUnification.naiveUnify(vpics));
        return slides;
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


    public static void CreateOutputFile(final String filename,final ArrayList<Slide> slides){
        StringBuilder builder=new StringBuilder();
        builder.append(slides.size()).append("\n");
        for(final Slide slide:slides){
            for(Picture p:slide.pictures){
                builder.append(p.indx).append(" ");
            }
            builder.append("\n");
        }
        try {
            Files.write(Paths.get(filename),builder.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
