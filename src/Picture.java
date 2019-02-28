import java.util.ArrayList;
import java.util.Arrays;

@SuppressWarnings("WeakerAccess")
public class Picture {
    final char format;
    ArrayList<String> tags;
    final int indx;

    Picture(final char format, final String[] tags,final int idx){
        this.format=format;
        this.tags=new ArrayList<>(Arrays.asList(tags));
        this.indx=idx;
    }


    public int getLength() {
        return tags.size();
    }


    @Override
    public String toString(){
        StringBuilder builder=new StringBuilder();
        builder.append(format).append(" ");
        for(final String tag:tags){
            builder.append(tag).append(" ");
        }
        return builder.toString();
    }
}
