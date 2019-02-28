import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("WeakerAccess")
public class Slide {

	//1 oder 2 lang
	public final ArrayList<Picture> pictures;
	//are calculated in the constructors
	public final ArrayList<String> tags;

	public Slide(Picture p1){
		pictures=new ArrayList<>();
		pictures.add(p1);
		tags=new ArrayList<>();
		for(final Picture p:pictures){
			tags.addAll(p.tags);
		}
	}

	public Slide(Picture p1,Picture p2){
		pictures=new ArrayList<>();
		pictures.add(p1);
		pictures.add(p2);
		tags=new ArrayList<>();
		for(final Picture p:pictures){
			tags.addAll(p.tags);
		}
	}


	@Override
	public String toString(){
		StringBuilder builder=new StringBuilder();
		for(final String tag:tags){
			builder.append(tag).append(" ");
		}
		return builder.toString();
	}
	
	
}
