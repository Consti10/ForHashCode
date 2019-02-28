import java.util.ArrayList;
import java.util.Arrays;

@SuppressWarnings("WeakerAccess")
public class Picture {
    final char format;
    ArrayList<String> tags;

    Picture(final char format, final String[] tags){
        this.format=format;
        this.tags=new ArrayList<>(Arrays.asList(tags));
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
